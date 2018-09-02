package com.capgemini.talentProfile.persistant;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sesame implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String importData;
    private String region;
    @Id
    private Long globalGroupId;
    private String localEmployeeNumber;
    private String login;
    private String civility;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String officeBase;
    private String birthday;
    private String gender;
    private String startDate;
    private String entityStartDate;
    private String leaversLastWorkingDate;
    private String employeeStatus;
    private String activeStatutsDescription;
    private String suspensionStatusDescription;
    private String terminationStatusDescription;
    private String empStatusEffectiveDate;
    private String discipline;
    private String classification;
    private String groupeGrade;
    private String localGrade;
    private String workPourcentage;
    private String recruitementTitle;
    private String resignmentReasons;
    private String adress1;
    private String adress2;
    private String adress3;
    private String postalCode;
    private String city;
    private String reviewingManagerGGID;
    private String hrManagerGGID;
    private String puCode;
    private String homePhone;
    private String officePhone;
    private String Professionalmobile;
    private String trainee;
    private String jobTitle;
    private String keySkills;
    private String globalPractice;
    private String securityLevel1;
    private String clearanceAgency1;
    private String securityExpiry1;
    private String securityLevel2;
    private String securityExpiry2;
    private String localPractice;
    private String qectorExperience;
    private String resourceManagerGGID;
    private String team;
    private String teamManagerGGID;
    private String qpeciality;
    private String peopleLeaderGGID;
    private String peopleManagerGGID;
    private String tli;
    private String forecastLastUpdated;
    private String visaType;
    private String country;
    private String costRate;
    private String bcsCoefficient;
    private String availabilityDate;
    private String diaryCode;
    private String represented;
    private String trainingApproverCGID;
    private String localOrg;
    private String qerviceLineBPO;
    private String engagementBPO;
    private String highPotentialBPO;
    private String jobQualif;
    private String jobPosition;
    private String jobCoef;
    private String maturityRole;
    private String collegeHire;
    private String localJobName;
    private String salaryLevel;
    private String rmAssistantGGID;
    private String categorie;
    private String typeContrat;

}
