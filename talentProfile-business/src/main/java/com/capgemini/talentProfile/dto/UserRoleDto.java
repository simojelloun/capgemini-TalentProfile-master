package com.capgemini.talentProfile.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserRoleDto {

    private long ggid;
    private String role;

    public UserRoleDto(long ggid, String role) {
        this.ggid = ggid;
        this.role = role;
    }

}
