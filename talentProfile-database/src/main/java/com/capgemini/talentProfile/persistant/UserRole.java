package com.capgemini.talentProfile.persistant;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Builder
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long ggid;

    private String password;

    private String role;

    private String firstName;

    private String lastName;

    private String startDate;

    private String endDate;

    private String etablissement;

    private String uniteOrganisat;

    private String pusap;

}
