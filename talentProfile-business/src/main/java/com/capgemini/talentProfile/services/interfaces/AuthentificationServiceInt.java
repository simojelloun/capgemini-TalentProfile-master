package com.capgemini.talentProfile.services.interfaces;

import com.capgemini.talentProfile.dto.UserRoleDto;

public interface AuthentificationServiceInt {

    UserRoleDto getUserRoleByLoginAndPassword(final long ggid, final String password);

}
