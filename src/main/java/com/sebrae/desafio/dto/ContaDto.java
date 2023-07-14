package com.sebrae.desafio.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContaDto {

    Long id;
    String nome;
    String descricao;
}
