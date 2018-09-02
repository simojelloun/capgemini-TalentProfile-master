package com.capgemini.talentProfile.services.implementations;

import com.capgemini.talentProfile.dto.UserRoleDto;
import com.capgemini.talentProfile.persistant.UserRole;
import com.capgemini.talentProfile.repository.UserRoleRepo;
import com.capgemini.talentProfile.services.interfaces.AuthentificationServiceInt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuhenticationServiceImpl implements AuthentificationServiceInt {
    private static final Logger LOGGER = Logger.getLogger(AuhenticationServiceImpl.class);

    @Autowired
    UserRoleRepo userRoleRepo;

    /**
     * @param ggid
     * @param password
     * @return
     */
    public UserRoleDto getUserRoleByLoginAndPassword(final long ggid, final String password) {
        LOGGER.info("+ Start getUserRoleByLoginAndPassword :" + ggid);

        UserRoleDto userRoleDto = null;
        UserRole userRole = userRoleRepo.findUserRoleByGgidAndPassword(ggid, password);
        LOGGER.debug("+ user role : " + userRole);

        if (userRole != null) {
            userRoleDto = UserRoleDto.builder().//
                    ggid(userRole.getGgid()).//
                    role(userRole.getRole()).//
                    build();
        }
        LOGGER.info("- End getUserRoleByLoginAndPassword");
        return userRoleDto;
    }

}
