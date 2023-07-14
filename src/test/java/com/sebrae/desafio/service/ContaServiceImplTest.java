package com.sebrae.desafio.service;

import com.sebrae.desafio.dto.ContaDto;
import com.sebrae.desafio.entity.Conta;
import com.sebrae.desafio.mapper.ContaMapper;
import com.sebrae.desafio.mapper.ContaMapperImpl;
import com.sebrae.desafio.repository.ContaRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContaServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    @Mock
    private ContaRepository contaRepository;
  
    @InjectMocks
    private ContaServiceImpl contaService;

    @Test
    void deveRetornarPageDeContaDto_QuandoGetAllContas() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("status", "nome"));
        Page<Conta> contaPage = new PageImpl<>(easyRandom.objects(Conta.class, 10).toList(), pageable, 15);
        var contaDto = easyRandom.nextObject(ContaDto.class);

        when(contaRepository.findAll(pageable)).thenReturn(contaPage);
        Page<ContaDto> contaDtoPageResult = contaService.getAllContas(pageable);

        assertNotNull(contaDtoPageResult);
        assertEquals(contaPage.getContent().size(), contaDtoPageResult.getContent().size());
        assertThat(contaPage.getContent()).usingRecursiveComparison().isEqualTo(contaDtoPageResult.getContent());
        verify(contaRepository).findAll(pageable);
    }
}
