package com.sebrae.desafio.service;

import com.sebrae.desafio.dto.ViaCepDto;
import com.sebrae.desafio.gateway.ViaCepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalServiceImpl implements ExternalService {

    private final ViaCepClient viaCepClient;
    @Override
    public ViaCepDto getViaCep() {
        return viaCepClient.getViaCep();
    }
}
