package com.sebrae.desafio.service;

import com.sebrae.desafio.dto.ContaDto;
import com.sebrae.desafio.dto.request.ContaRequest;
import com.sebrae.desafio.mapper.ContaMapper;
import com.sebrae.desafio.repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    @Override
    public Page<ContaDto> getAllContas(Pageable pageable) {
        var contas = contaRepository.findAll(pageable);
        return new PageImpl<>(contas.stream()
                .map(ContaMapper.INSTANCE::toContaDto)
                .collect(Collectors.toList()), pageable, contas.getTotalElements());
    }

    @Override
    public ContaDto createConta(ContaRequest contaRequest) {
        var conta = ContaMapper.INSTANCE.toConta(contaRequest);
        return ContaMapper.INSTANCE.toContaDto(contaRepository.save(conta));
    }

    @Override
    public ContaDto updateConta(Long id, ContaRequest contaRequest) {
        var conta = contaRepository.findById(id).orElse(null);
        if (isNull(conta)) {
            throw new EntityNotFoundException("Não foi encontra uma conta com id:" + id);
        }
        ContaMapper.INSTANCE.updateContaFromContaRequest(contaRequest, conta);
        return ContaMapper.INSTANCE.toContaDto(contaRepository.save(conta));
    }

    @Override
    public ContaDto getContaById(Long id) {
        var conta = contaRepository.findById(id).orElse(null);
        return ContaMapper.INSTANCE.toContaDto(conta);
    }

    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}
