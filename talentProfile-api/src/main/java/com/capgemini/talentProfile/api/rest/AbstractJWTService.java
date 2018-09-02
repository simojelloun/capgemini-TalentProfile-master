package com.capgemini.talentProfile.api.rest;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.capgemini.talentProfile.dto.UserRoleDto;
import com.google.common.util.concurrent.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 * Base class fo all JWT-aware services.
 */
public class AbstractJWTService extends AbstractService {
    public static final String CHARSET_UTF_8 = ";charset=UTF-8";

    private static final Logger LOG      = LoggerFactory.getLogger(AbstractJWTService.class);

    /**
     * The constant SECRET.
     */
    protected final static String SECRET = "qsQSdMù$:;=oiàaç!arbad:))àç@&";

    /**
     * The constant TOKEN_KEY.
     */
    protected final static String TOKEN_KEY         = "token";

    /**
     * The constant USER_UUID_KEY.
     */
    protected final static String GGID_KEY = "ggid";
    /**
     * The constant ROLE_UUID_KEY.
     */
    protected final static String ROLE_KEY = "role";

    /**
     * Decode jwt decoded jwt.
     *
     * @param token
     *     the token
     * @return the decoded jwt
     *
     * @throws UnsupportedEncodingException
     *     the unsupported encoding exception
     */
    protected DecodedJWT decodeJWT(String token) throws UnsupportedEncodingException {
        DecodedJWT jwt;
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        jwt = verifier.verify(token);
        return jwt;
    }

    private String createToken(Serializable ggid, Serializable role) throws UnsupportedEncodingException {

        int validationHours = 24 ;

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Date now = new Date();
        Calendar expires = Calendar.getInstance();
        expires.setTime(now);
        expires.add(Calendar.HOUR_OF_DAY, validationHours);
        //expires.add(Calendar.SECOND, 5);
        return JWT.create().withIssuedAt(now).withIssuer("Talent Profile").withNotBefore(now).withExpiresAt(expires.getTime())
                .withClaim(GGID_KEY, ggid.toString()).withClaim(ROLE_KEY, role.toString()).sign(algorithm);
    }

    /**
     * Create jwt payload json object.
     *
     * @param userUUID
     *     the user uuid
     * @param roleUUID
     *     the role uuid
     * @return the json object
     *
     * @throws JSONException
     *     the json exception
     * @throws UnsupportedEncodingException
     *     the unsupported encoding exception
     */
    protected JSONObject createJWTPayload(long userUUID, String roleUUID)
            throws JSONException, UnsupportedEncodingException {
        return createJWTPayload(createToken(userUUID, roleUUID));
    }

    /**
     * Create jwt payload json object.
     *
     * @param token
     *     the token
     * @return the json object
     *
     * @throws JSONException
     *     the json exception
     */
    protected JSONObject createJWTPayload(String token) throws JSONException {
        JSONObject jwtPayload = new JSONObject();
        jwtPayload.put(TOKEN_KEY, token);
        return jwtPayload;
    }

    protected UserRoleDto initExecution(String token) {

        UserRoleDto userRoleDto = null;
        if (StringUtils.isBlank(token)) {
            LOG.warn("The token cannot be null. Sending back a 403 HTTP response code.");
            return null;
        }

        try {
            DecodedJWT decodedJWT = decodeJWT(token);
            if (decodedJWT != null) {
                Claim ggidClaim = decodedJWT.getClaim(GGID_KEY);
                Claim roleClaim = decodedJWT.getClaim(ROLE_KEY);
                if (!ggidClaim.isNull()&& !roleClaim.isNull()) {
                    userRoleDto = new UserRoleDto(Long.parseLong(ggidClaim.asString()), roleClaim.asString());
                }
            }

        } catch (UnsupportedEncodingException e) {
            LOG.warn(e.getMessage());
            return null;
        }

        return userRoleDto;
    }


    @Override
    protected void doStart() {

    }

    @Override
    protected void doStop() {

    }

    /**
     *
     * @param loggedInUser
     * @param token
     * @return
     */
    protected String createAuthenticationPayload (UserRoleDto loggedInUser, String token){
        try {

            JSONObject authenticationPayload;
            if (token == null) {
                authenticationPayload = createJWTPayload(loggedInUser.getGgid(), loggedInUser.getRole());
            } else {
                authenticationPayload = createJWTPayload(token);
            }

            return authenticationPayload.get(TOKEN_KEY).toString();
        } catch (JSONException | UnsupportedEncodingException | NullPointerException e) {
            LOG.error("A technical error occured when creating the authentication payload", e);
            return "INTERNAL_SERVER_ERROR";
        }
    }

}
