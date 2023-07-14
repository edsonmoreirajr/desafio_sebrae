package com.sebrae.desafio.service;

import com.sebrae.desafio.dto.ContaDto;
import com.sebrae.desafio.dto.request.ContaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaService {

    Page<ContaDto> getAllContas(Pageable pageable);

    ContaDto createConta(ContaRequest contatoRequest);

    ContaDto updateConta(Long id, ContaRequest contatoRequest);

    ContaDto getContaById(Long id);

    void deleteConta(Long id);
}
