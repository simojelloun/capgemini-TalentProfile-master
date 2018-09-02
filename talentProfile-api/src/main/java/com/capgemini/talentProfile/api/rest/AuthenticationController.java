package com.capgemini.talentProfile.api.rest;

import com.capgemini.talentProfile.api.models.TokenRole;
import com.capgemini.talentProfile.dto.UserRoleDto;
import com.capgemini.talentProfile.services.interfaces.AuthentificationServiceInt;
import com.capgemini.talentProfile.utils.WSResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController extends AbstractJWTService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthentificationServiceInt authentificationServiceInt;

    /**
     *
     * @param payloadAsString
     * @return
     */
    @PostMapping(value = "/talentProfile/authenticate")
    public ResponseEntity authenticate(@RequestBody String payloadAsString) {
        LOGGER.info("+ Start authenticate");

        long ggid;
        String password;
        UserRoleDto userRoleDto = null;

        try {
            JSONObject payload = new JSONObject(payloadAsString);
            ggid = payload.getLong("ggid");
            password = payload.getString("password");

            userRoleDto = authentificationServiceInt.getUserRoleByLoginAndPassword(ggid, password);

        } catch (JSONException e) {
            String errorMessage = "An invalid JSON request payload was received " + payloadAsString;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        if (userRoleDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WSResponseMessage("Invalid Login / Password"));
        }

        TokenRole tokenRole = new TokenRole(createAuthenticationPayload(userRoleDto, null), userRoleDto.getRole());

        LOGGER.info("- End authenticate");
        return new ResponseEntity<>(tokenRole, HttpStatus.OK);
    }

}
