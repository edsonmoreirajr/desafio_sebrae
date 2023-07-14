package com.sebrae.desafio.mapper;

import com.sebrae.desafio.dto.ContaDto;
import com.sebrae.desafio.dto.request.ContaRequest;
import com.sebrae.desafio.entity.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = SPRING)
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);
    ContaDto toContaDto(Conta contato);
    Conta toConta(ContaRequest contatoRequest);
    void updateContaFromContaRequest(ContaRequest contatoRequest, @MappingTarget Conta contato);
}
