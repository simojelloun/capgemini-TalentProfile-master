package com.capgemini.talentProfile.api.mappers;


import com.capgemini.talentProfile.api.mappers.Mapper;
import com.capgemini.talentProfile.api.models.FicheCollabApiModel;
import com.capgemini.talentProfile.dto.FicheCollabDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FicheCollabApiMapper implements Mapper<FicheCollabApiModel, FicheCollabDto> {

    /**
     *
     * @param apiModel the api model
     * @return
     */
    @Override
    public FicheCollabDto fromApiToDto(FicheCollabApiModel apiModel) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(apiModel, FicheCollabDto.class);
    }

    /**
     *
     * @param apiModels the api models
     * @return
     */
    @Override
    public List<FicheCollabDto> fromApiModelToDto(List<FicheCollabApiModel> apiModels) {
        final List<FicheCollabDto> models = new ArrayList<>();
        for(final FicheCollabApiModel apiModel:apiModels) {
            models.add(fromApiToDto(apiModel));
        }
        return models;
    }

    /**
     *
     * @param dto the dto
     * @return
     */
    @Override
    public FicheCollabApiModel fromDtoToApiModel(FicheCollabDto dto) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(dto, FicheCollabApiModel.class);
    }

    /**
     *
     * @param dtos the dtos
     * @return
     */
    @Override
    public List<FicheCollabApiModel> fromDtoToApiModel(List<FicheCollabDto> dtos) {
        final List<FicheCollabApiModel> models = new ArrayList<>();
        for(final FicheCollabDto dto:dtos) {
            models.add(fromDtoToApiModel(dto));
        }
        return models;
    }
}
