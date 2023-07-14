package com.sebrae.desafio.controller;

import com.sebrae.desafio.dto.ViaCepDto;
import com.sebrae.desafio.service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/external")
@RequiredArgsConstructor
public class ExternalServiceController {

    private final ExternalService externalService;
    @GetMapping("/viacep")
    public ResponseEntity<ViaCepDto> getViaCep() {

        var viaCep = externalService.getViaCep();
        return ResponseEntity.ok(viaCep);
    }
}
