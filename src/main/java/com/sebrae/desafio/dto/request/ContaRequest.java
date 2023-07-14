package com.sebrae.desafio.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContaRequest {

    String nome;
    String descricao;
}
