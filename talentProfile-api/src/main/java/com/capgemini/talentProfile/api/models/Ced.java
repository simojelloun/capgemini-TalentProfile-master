package com.capgemini.talentProfile.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Ced {
    private long ggid;/**/
    private String employeePernr;
    private String localId;/**/
    private String employeeLastName;/**/
    private String employeeFirstName;/**/
    private String customerSpecificStatus;/**/
    private String hireDate;/**/
    private String sbuGradeText;
    private String localGradeText;/**/
    private String globalGrade;/**/
    private String reviewerName;/**/
    private String reviewerLocalId;/**/
    private String reviewerGlobalId;/**/
    private String performanceYearStartDate;
    private String sbuId;/**/
    private String sbuText;/**/
    private String gbuId;/**/
    private String gbuText;/**/
    private String buId;/**/
    private String buText;/**/
    private String gpuText;/**/
    private String puId;/**/
    private String puText;/**/
    private String localOrganization;/**/
    private String country;
    private String personnelArea;/**/
    private String companyCode;
    private String companyCodeText;
    private String dompanyCodeText;
    private String reviewerYearEndAssessment;
    private String provisionalPerformanceRating;
    private String finalPerformanceRating;
    private String provisionalPromotionNomination;
    private String finalPromotionNomination;
    private String provisionalPotentialRating;
    private String finalPotentialRating;
    private String provisionalExperienceinRole;
    private String finalExperienceinRole;
    private String provisionalCareerTrack;
    private String finalCareerTrack;
    private String provisionalVPPotentialRating;
    private String finalVPPotentialRating;
    private String totalEvaluation;

}

