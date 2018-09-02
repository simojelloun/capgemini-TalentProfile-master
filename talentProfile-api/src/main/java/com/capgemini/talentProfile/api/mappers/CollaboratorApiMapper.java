package com.capgemini.talentProfile.api.mappers;

import com.capgemini.talentProfile.api.models.CollaboratorApiModel;
import com.capgemini.talentProfile.dto.CollaboratorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaboratorApiMapper implements Mapper<CollaboratorApiModel, CollaboratorDto> {

    /**
     *
     * @param collaboratorSimple
     * @return
     */
    @Override
    public CollaboratorDto fromApiToDto(final CollaboratorApiModel collaboratorSimple) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(collaboratorSimple, CollaboratorDto.class);
    }

    /**
     *
     * @param apiModels the api models
     * @return
     */
    @Override
    public List<CollaboratorDto> fromApiModelToDto(List<CollaboratorApiModel> apiModels) {
        final List<CollaboratorDto> dtos = new ArrayList<>();
        for(final CollaboratorApiModel model:apiModels) {
            dtos.add(fromApiToDto(model));
        }
        return dtos;
    }

    /**
     *
     * @param dto the dto
     * @return
     */
    @Override
    public CollaboratorApiModel fromDtoToApiModel(CollaboratorDto dto) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dto, CollaboratorApiModel.class);
    }

    /**
     *
     * @param dtos the dtos
     * @return
     */
    @Override
    public List<CollaboratorApiModel> fromDtoToApiModel(List<CollaboratorDto> dtos) {
        final List<CollaboratorApiModel> models = new ArrayList<>();
        for(final CollaboratorDto dto:dtos) {
            models.add(fromDtoToApiModel(dto));
        }
        return models;
    }
}
