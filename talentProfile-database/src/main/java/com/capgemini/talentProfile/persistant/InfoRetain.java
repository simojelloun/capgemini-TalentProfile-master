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
public class InfoRetain implements Serializable {

    private String productionUnitName;
    @Id
    private Long ggid;
    private String lastName;
    private String firstName;
    private String grade;
    private String skills;
    private String techno;
    private String affectationType;
    private String projectName;
    private String joinDate;
    private String office;


    public InfoRetain(String productionUnitName, Long ggid, String lastName, String firstName, String grade,
                       String skills, String techno, String affectationType, String projectName, String joinDate,
                       String office) {
        super();
        this.productionUnitName = productionUnitName;
        this.ggid = ggid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
        this.skills = skills;
        this.techno = techno;
        this.affectationType = affectationType;
        this.projectName = projectName;
        this.joinDate = joinDate;
        this.office = office;

    }

}
