package com.capgemini.talentProfile.persistant;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class InfoMyPathCed extends MyPathCommon implements Serializable {

    @Id
    private Long id;
    private Long globalId;/**/
    private String employeePernr;
    private String localId;/**/
    @Column(length = 3000)
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
    private String performanceYearStartDate;

    public InfoMyPathCed(long id, long globalID, String employeePERNR, String localID, String employeeLastName,
                         String employeeFirstName, String customerSpecificStatus, String hireDate, String sBUGradeText,
                         String localGradeText, String globalGrade, String reviewerName, String reviewerLocalID,
                         String reviewerGlobalID, String performanceYearStartDate, String sBUId, String sBUText,
                         String gBUId, String gBUText, String bUId, String bUText, String gPUText, String pUId, String pUText,
                         String localOrganization, String country, String personnelArea, String companyCode,
                         String companyCodeText, String reviewerYearEndAssessment, String provisionalPerformanceRating,
                         String finalPerformanceRating, String provisionalPromotionNomination, String finalPromotionNomination,
                         String provisionalPotentialRating, String finalPotentialRating, String provisionalExperienceinRole,
                         String finalExperienceinRole, String provisionalCareerTrack, String finalCareerTrack,
                         String provisionalVPPotentialRating, String finalVPPotentialRating, String totalEvaluation) {
        super(employeeLastName, employeeFirstName, customerSpecificStatus, hireDate, sBUGradeText, localGradeText, globalGrade, reviewerName, reviewerLocalID, reviewerGlobalID, sBUId, sBUText, gBUId, gBUText, bUId, bUText, gPUText, pUId, pUText, localOrganization, country, personnelArea, companyCode, companyCodeText);
        this.id = id;
        this.globalId = globalID;
        this.employeePernr = employeePERNR;
        this.localId = localID;
        this.reviewerYearEndAssessment = reviewerYearEndAssessment;
        this.provisionalPerformanceRating = provisionalPerformanceRating;
        this.finalPerformanceRating = finalPerformanceRating;
        this.provisionalPromotionNomination = provisionalPromotionNomination;
        this.finalPromotionNomination = finalPromotionNomination;
        this.provisionalPotentialRating = provisionalPotentialRating;
        this.finalPotentialRating = finalPotentialRating;
        this.provisionalExperienceinRole = provisionalExperienceinRole;
        this.finalExperienceinRole = finalExperienceinRole;
        this.provisionalCareerTrack = provisionalCareerTrack;
        this.finalCareerTrack = finalCareerTrack;
        this.provisionalVPPotentialRating = provisionalVPPotentialRating;
        this.finalVPPotentialRating = finalVPPotentialRating;
        this.totalEvaluation = totalEvaluation;
        this.performanceYearStartDate = performanceYearStartDate;
    }
}

