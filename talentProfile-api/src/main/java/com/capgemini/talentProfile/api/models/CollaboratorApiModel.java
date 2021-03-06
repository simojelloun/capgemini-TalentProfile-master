package com.capgemini.talentProfile.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CollaboratorApiModel implements Serializable {

    private Long ggid;
    private String firstName;
    private String lastName;
    private String grade;
    private Integer age;
    private String role;
    private String project;
    private String provisionalNote;
    private String provisionalPotentiel;
}
