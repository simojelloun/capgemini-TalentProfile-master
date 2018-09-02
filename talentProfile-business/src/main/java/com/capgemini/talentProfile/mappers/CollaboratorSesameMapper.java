package com.capgemini.talentProfile.mappers;

import com.capgemini.talentProfile.dto.CollaboratorDto;
import com.capgemini.talentProfile.persistant.Sesame;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaboratorSesameMapper implements Mapper<Sesame, CollaboratorDto> {

    @Override
    public Sesame fromDtoToEntity(CollaboratorDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(dto, Sesame.class);
    }

    @Override
    public List<Sesame> fromDtoToEntity(List<CollaboratorDto> dtos) {
        final List<Sesame> entities = new ArrayList<>();
        for(final CollaboratorDto dto:dtos) {
            entities.add(fromDtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public CollaboratorDto fromEntityToDto(Sesame entity) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(entity, CollaboratorDto.class);
    }

    @Override
    public List<CollaboratorDto> fromEntityToDto(List<Sesame> entities) {
        final List<CollaboratorDto> dtos = new ArrayList<>();
        for(final Sesame model:entities) {
            dtos.add(fromEntityToDto(model));
        }
        return dtos;
    }
}
