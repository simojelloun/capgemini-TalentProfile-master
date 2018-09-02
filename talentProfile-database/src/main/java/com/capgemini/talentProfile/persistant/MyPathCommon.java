package com.capgemini.talentProfile.persistant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class MyPathCommon {

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

    public MyPathCommon(String employeeLastName, String employeeFirstName, String customerSpecificStatus, String hireDate, String sbuGradeText, String localGradeText, String globalGrade, String reviewerName, String reviewerLocalId, String reviewerGlobalId, String sbuId, String sbuText, String gbuId, String gbuText, String buId, String buText, String gpuText, String puId, String puText, String localOrganization, String country, String personnelArea, String companyCode, String companyCodeText) {
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.customerSpecificStatus = customerSpecificStatus;
        this.hireDate = hireDate;
        this.sbuGradeText = sbuGradeText;
        this.localGradeText = localGradeText;
        this.globalGrade = globalGrade;
        this.reviewerName = reviewerName;
        this.reviewerLocalId = reviewerLocalId;
        this.reviewerGlobalId = reviewerGlobalId;
        this.sbuId = sbuId;
        this.sbuText = sbuText;
        this.gbuId = gbuId;
        this.gbuText = gbuText;
        this.buId = buId;
        this.buText = buText;
        this.gpuText = gpuText;
        this.puId = puId;
        this.puText = puText;
        this.localOrganization = localOrganization;
        this.country = country;
        this.personnelArea = personnelArea;
        this.companyCode = companyCode;
        this.companyCodeText = companyCodeText;
    }
}
