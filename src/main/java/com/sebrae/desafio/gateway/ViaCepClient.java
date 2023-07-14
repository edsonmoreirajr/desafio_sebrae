package com.sebrae.desafio.gateway;

import com.sebrae.desafio.dto.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "viaCepClient", url = "http://viacep.com.br")
public interface ViaCepClient {

    @GetMapping("/ws/01001000/json/")
    ViaCepDto getViaCep();
}
