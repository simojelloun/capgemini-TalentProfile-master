package com.capgemini.talentProfile.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FicheCollabApiModel {

    private Long ggid;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String groupeGrade;
    private String localGrade;
    private String puCode;
    private String birthday;
    private String projectName;
    private String affectationType;
    private String techno;
    private String reviewerName;
    private String entityStartDate;
    private String officeBase;
    private String leaversLastWorking;
    private String typeContrat;
    private String categorie;
    private String classification;
    private String employeeStatus;
    private String provisionalPerformanceRating;
    private String asignmentRating;
    private String provisionalPotentialRating;
    private List<Ced> cedList;
    private List<Epp> eppList;

}
