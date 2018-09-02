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
public class CollabCm implements Serializable {
    @Id
    private Long ggid;
    private String puCollab;
    private String ville;
    private String nomCollab;
    private String prenomCollab;
    private Long ggidCM;
    private String nomCM;
    private String prenomCM;

}


