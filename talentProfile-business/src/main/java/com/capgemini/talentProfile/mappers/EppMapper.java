package com.capgemini.talentProfile.mappers;

import com.capgemini.talentProfile.dto.InfoMyPathEppDto;
import com.capgemini.talentProfile.persistant.InfoMyPathEpp;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EppMapper implements Mapper<InfoMyPathEpp,InfoMyPathEppDto> {

    @Override
    public InfoMyPathEpp fromDtoToEntity(InfoMyPathEppDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(dto,InfoMyPathEpp.class);
    }

    @Override
    public List<InfoMyPathEpp> fromDtoToEntity(List<InfoMyPathEppDto> dtos) {
        final List<InfoMyPathEpp> entities=new ArrayList<>();
        for(final InfoMyPathEppDto dto:dtos) {
            entities.add(fromDtoToEntity(dto));
        }
        return entities;
    }
    @Override
    public InfoMyPathEppDto fromEntityToDto(InfoMyPathEpp entity) {
        ObjectMapper mapper =new ObjectMapper();
        return mapper.convertValue(entity,InfoMyPathEppDto.class);
    }
    @Override
    public List<InfoMyPathEppDto> fromEntityToDto(List<InfoMyPathEpp> entities) {
        final List<InfoMyPathEppDto> dtos =new ArrayList<>();
        for(final InfoMyPathEpp model:entities) {
            dtos.add(fromEntityToDto(model));
        }
            return dtos;
    }

 }
