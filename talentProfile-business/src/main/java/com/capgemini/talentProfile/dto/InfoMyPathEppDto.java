package com.capgemini.talentProfile.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoMyPathEppDto {
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

}
