package com.sebrae.desafio.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ViaCepDto {

    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String gia;
    String ddd;
    String siafi;
}
