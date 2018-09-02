package com.capgemini.talentProfile.persistant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InfoMyPathHisto extends MyPathCommon implements Serializable {
    @Id
    private long id;
    private String employeePpernr;
    private String localId;/**/
    private Long globalId;/**/

    @Column(length = 3000)
    private String reviewerYearEndAssessment;
    private String provisionalPerformanceRating;
    private String finalPerformanceRating;
    private String provisionalPromotionNomination;
    private String finalPromotionNomination;
    private String provisionalPotentialRating;
    private String finalPotentialRating;
    private String provisionalExperienceInRole;
    private String finalExperienceInRole;
    private String provisionalCareerTrack;
    private String finalCareerTrack;
    private String provisionalVpPotentialRating;
    private String finalVpPotentialRating;
    private String totalEvaluation;
    private String performanceYearStartDate;

    public InfoMyPathHisto(long id,
                           String employeePpernr,
                           String localId,
                           Long globalId,
                           String employeeLastName,
                           String employeeFirstName,
                           String customerSpecificStatus,
                           String hireDate,
                           String sbuGradeText,
                           String localGradeText,
                           String globalGrade,
                           String reviewerName,
                           String reviewerLocalId,
                           String reviewerGlobalId,
                           String performanceYearStartDate,
                           String sbuId,
                           String sbuText,
                           String gbuId,
                           String gbuText,
                           String buId,
                           String buText,
                           String gpuText,
                           String puId,
                           String puText,
                           String localOrganization,
                           String country,
                           String personnelArea,
                           String companyCode,
                           String companyCodeText,
                           String reviewerYearEndAssessment,
                           String provisionalPerformanceRating,
                           String finalPerformanceRating,
                           String provisionalPromotionNomination,
                           String finalPromotionNomination,
                           String provisionalPotentialRating,
                           String finalPotentialRating,
                           String provisionalExperienceInRole,
                           String finalExperienceInRole,
                           String provisionalCareerTrack,
                           String finalCareerTrack,
                           String provisionalVpPotentialRating,
                           String finalVpPotentialRating,
                           String totalEvaluation) {
        super(employeeLastName, employeeFirstName, customerSpecificStatus, hireDate, sbuGradeText, localGradeText, globalGrade, reviewerName, reviewerLocalId, reviewerGlobalId, sbuId, sbuText, gbuId, gbuText, buId, buText, gpuText, puId, puText, localOrganization, country, personnelArea, companyCode, companyCodeText);
        this.id = id;
        this.employeePpernr = employeePpernr;
        this.localId = localId;
        this.globalId = globalId;
        this.reviewerYearEndAssessment = reviewerYearEndAssessment;
        this.provisionalPerformanceRating = provisionalPerformanceRating;
        this.finalPerformanceRating = finalPerformanceRating;
        this.provisionalPromotionNomination = provisionalPromotionNomination;
        this.finalPromotionNomination = finalPromotionNomination;
        this.provisionalPotentialRating = provisionalPotentialRating;
        this.finalPotentialRating = finalPotentialRating;
        this.provisionalExperienceInRole = provisionalExperienceInRole;
        this.finalExperienceInRole = finalExperienceInRole;
        this.provisionalCareerTrack = provisionalCareerTrack;
        this.finalCareerTrack = finalCareerTrack;
        this.provisionalVpPotentialRating = provisionalVpPotentialRating;
        this.finalVpPotentialRating = finalVpPotentialRating;
        this.totalEvaluation = totalEvaluation;
        this.performanceYearStartDate = performanceYearStartDate;
    }
}
