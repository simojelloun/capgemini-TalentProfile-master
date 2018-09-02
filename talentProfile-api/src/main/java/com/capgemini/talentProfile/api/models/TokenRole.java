package com.capgemini.talentProfile.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenRole {

    private String token;;
    private String role;

    public TokenRole(String token, String role) {
        this.token = token;
        this.role = role;
    }
}
