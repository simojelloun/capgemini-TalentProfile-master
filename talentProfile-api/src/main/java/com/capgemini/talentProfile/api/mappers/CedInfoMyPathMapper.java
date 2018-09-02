package com.capgemini.talentProfile.api.mappers;

import com.capgemini.talentProfile.api.models.Ced;
import com.capgemini.talentProfile.dto.InfoMyPathCedDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CedInfoMyPathMapper implements Mapper<Ced, InfoMyPathCedDto> {

    /**
     *
     * @param collaboratorSimple
     * @return
     */
    @Override
    public InfoMyPathCedDto fromApiToDto(final Ced collaboratorSimple) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(collaboratorSimple, InfoMyPathCedDto.class);
    }

    /**
     *
     * @param apiModels the api models
     * @return
     */
    @Override
    public List<InfoMyPathCedDto> fromApiModelToDto(List<Ced> apiModels) {
        final List<InfoMyPathCedDto> dtos = new ArrayList<>();
        for(final Ced model:apiModels) {
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
    public Ced fromDtoToApiModel(InfoMyPathCedDto dto) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dto, Ced.class);
    }

    /**
     *
     * @param dtos the dtos
     * @return
     */
    @Override
    public List<Ced> fromDtoToApiModel(List<InfoMyPathCedDto> dtos) {
        final List<Ced> models = new ArrayList<>();
        for(final InfoMyPathCedDto dto:dtos) {
            models.add(fromDtoToApiModel(dto));
        }
        return models;
    }
}
