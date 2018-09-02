package com.capgemini.talentProfile.services.interfaces;

import com.capgemini.talentProfile.dto.CollaboratorDto;
import com.capgemini.talentProfile.dto.FicheCollabDto;

import java.util.List;

public interface CollaboratorsServiceInt {

    public List<CollaboratorDto> getAllCollaborators();

    public FicheCollabDto getCollabByGgid(Long ggid);

    public List<CollaboratorDto> getCollabByCM(Long ggidCM);
}
