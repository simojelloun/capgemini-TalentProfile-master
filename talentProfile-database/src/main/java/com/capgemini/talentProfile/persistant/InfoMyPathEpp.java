package com.capgemini.talentProfile.persistant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InfoMyPathEpp implements Serializable {
    @Id
    private Long id;
    private Long employeeGlobalId;/**/
    private String employeeFirstName;/**/
    private String employeeLastName;/**/
    private String personnelNumber;
    private String employeeLocalId;/**/
    private String performanceStatus;
    private String performanceSubstatus;
    private String employeeEmail;
    private String sbuCode;/**/
    private String sbuText;/**/
    private String gbuCode;/**/
    private String gbuText;/**/
    private String buCode;/**/
    private String buText;/**/
    private String gpuText;/**/
    private String puCode;/**/
    private String puText;/**/
    private String employeeLocalGrade;/**/
    private String employeeGlobalGrade;/**/
    private String localOrganization;/**/
    private String workLocation;
    private String personnelArea;/**/
    private String personnelSubarea;
    private String employeeGroup;
    private String employeeSubGroup;
    private String latestEmployeeHireDate;/**/
    private String employeeStatus;
    private String customerSpecificStatus;/**/
    private String reviewerFirstName;/**/
    private String reviewerLastName;
    private String reviewerPernr;
    private String reviewerGlobalId;/**/
    private String reviewerLocalId;/**/
    private String reviewerEmail;
    private String reviewerLocalGrade;
    private String reviewerStatus;
    private String appraisalDocumentName;
    private String startDate;
    private String endDate;
    private String assignmentObjectiveName1;
    private String assignmentObjectiveDescription1;
    private String assignmentObjectiveName2;
    private String assignmentObjectiveDescription2;
    private String assignmentObjectiveName3;
    private String assignmentObjectiveDescription3;
    private String assignmentObjectiveName4;
    private String assignmentObjectiveDescription4;
    private String assignmentObjectiveName5;
    private String assignmentObjectiveDescription5;
    private String assignmentObjectiveName6;
    private String assignmentObjectiveDescription6;
    private String assignmentObjectiveName7;
    private String assignmentObjectiveDescription7;
    private String assignmentObjectiveName8;
    private String assignmentObjectiveDescription8;
    private String assignmentObjectiveName9;
    private String assignmentObjectiveDescription9;
    private String clientName;
    private String projectCode;
    private String otherSignificantFeaturesOfAssignment;
    private String revenueManaged;
    private String sizeOfTeamManaged;
    private String employeeCommentsAgainstObjectives;
    private String managerCommentsForObjectives;
    private String competenciesKeyStrengths;
    private String competenciesAreasForDevelopment;
    private String assignmentRating;
    private String employeeSignoffComments;
    private String assignmentAppraisalHrComments;

    public InfoMyPathEpp(Long id, Long employeeGlobalId, String employeeFirstName, String employeeLastName, String personnelNumber, String employeeLocalId, String performanceStatus, String performanceSubstatus, String employeeEmail, String sbuCode, String sbuText, String gbuCode, String gbuText, String buCode, String buText, String gpuText, String puCode, String puText, String employeeLocalGrade, String employeeGlobalGrade, String localOrganization, String workLocation, String personnelArea, String personnelSubarea, String employeeGroup, String employeeSubGroup, String latestEmployeeHireDate, String employeeStatus, String customerSpecificStatus, String reviewerFirstName, String reviewerLastName, String reviewerPernr, String reviewerGlobalId, String reviewerLocalId, String reviewerEmail, String reviewerLocalGrade, String reviewerStatus, String appraisalDocumentName, String startDate, String endDate, String assignmentObjectiveName1, String assignmentObjectiveDescription1, String assignmentObjectiveName2, String assignmentObjectiveDescription2, String assignmentObjectiveName3, String assignmentObjectiveDescription3, String assignmentObjectiveName4, String assignmentObjectiveDescription4, String assignmentObjectiveName5, String assignmentObjectiveDescription5, String assignmentObjectiveName6, String assignmentObjectiveDescription6, String assignmentObjectiveName7, String assignmentObjectiveDescription7, String assignmentObjectiveName8, String assignmentObjectiveDescription8, String assignmentObjectiveName9, String assignmentObjectiveDescription9, String clientName, String projectCode, String otherSignificantFeaturesOfAssignment, String revenueManaged, String sizeOfTeamManaged, String employeeCommentsAgainstObjectives, String managerCommentsForObjectives, String competenciesKeyStrengths, String competenciesAreasForDevelopment, String assignmentRating, String employeeSignoffComments, String assignmentAppraisalHrComments) {
        this.id = id;
        this.employeeGlobalId = employeeGlobalId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.personnelNumber = personnelNumber;
        this.employeeLocalId = employeeLocalId;
        this.performanceStatus = performanceStatus;
        this.performanceSubstatus = performanceSubstatus;
        this.employeeEmail = employeeEmail;
        this.sbuCode = sbuCode;
        this.sbuText = sbuText;
        this.gbuCode = gbuCode;
        this.gbuText = gbuText;
        this.buCode = buCode;
        this.buText = buText;
        this.gpuText = gpuText;
        this.puCode = puCode;
        this.puText = puText;
        this.employeeLocalGrade = employeeLocalGrade;
        this.employeeGlobalGrade = employeeGlobalGrade;
        this.localOrganization = localOrganization;
        this.workLocation = workLocation;
        this.personnelArea = personnelArea;
        this.personnelSubarea = personnelSubarea;
        this.employeeGroup = employeeGroup;
        this.employeeSubGroup = employeeSubGroup;
        this.latestEmployeeHireDate = latestEmployeeHireDate;
        this.employeeStatus = employeeStatus;
        this.customerSpecificStatus = customerSpecificStatus;
        this.reviewerFirstName = reviewerFirstName;
        this.reviewerLastName = reviewerLastName;
        this.reviewerPernr = reviewerPernr;
        this.reviewerGlobalId = reviewerGlobalId;
        this.reviewerLocalId = reviewerLocalId;
        this.reviewerEmail = reviewerEmail;
        this.reviewerLocalGrade = reviewerLocalGrade;
        this.reviewerStatus = reviewerStatus;
        this.appraisalDocumentName = appraisalDocumentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assignmentObjectiveName1 = assignmentObjectiveName1;
        this.assignmentObjectiveDescription1 = assignmentObjectiveDescription1;
        this.assignmentObjectiveName2 = assignmentObjectiveName2;
        this.assignmentObjectiveDescription2 = assignmentObjectiveDescription2;
        this.assignmentObjectiveName3 = assignmentObjectiveName3;
        this.assignmentObjectiveDescription3 = assignmentObjectiveDescription3;
        this.assignmentObjectiveName4 = assignmentObjectiveName4;
        this.assignmentObjectiveDescription4 = assignmentObjectiveDescription4;
        this.assignmentObjectiveName5 = assignmentObjectiveName5;
        this.assignmentObjectiveDescription5 = assignmentObjectiveDescription5;
        this.assignmentObjectiveName6 = assignmentObjectiveName6;
        this.assignmentObjectiveDescription6 = assignmentObjectiveDescription6;
        this.assignmentObjectiveName7 = assignmentObjectiveName7;
        this.assignmentObjectiveDescription7 = assignmentObjectiveDescription7;
        this.assignmentObjectiveName8 = assignmentObjectiveName8;
        this.assignmentObjectiveDescription8 = assignmentObjectiveDescription8;
        this.assignmentObjectiveName9 = assignmentObjectiveName9;
        this.assignmentObjectiveDescription9 = assignmentObjectiveDescription9;
        this.clientName = clientName;
        this.projectCode = projectCode;
        this.otherSignificantFeaturesOfAssignment = otherSignificantFeaturesOfAssignment;
        this.revenueManaged = revenueManaged;
        this.sizeOfTeamManaged = sizeOfTeamManaged;
        this.employeeCommentsAgainstObjectives = employeeCommentsAgainstObjectives;
        this.managerCommentsForObjectives = managerCommentsForObjectives;
        this.competenciesKeyStrengths = competenciesKeyStrengths;
        this.competenciesAreasForDevelopment = competenciesAreasForDevelopment;
        this.assignmentRating = assignmentRating;
        this.employeeSignoffComments = employeeSignoffComments;
        this.assignmentAppraisalHrComments = assignmentAppraisalHrComments;
    }

}
