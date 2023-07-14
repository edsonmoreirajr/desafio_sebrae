package com.sebrae.desafio.controller;

import com.sebrae.desafio.dto.ContaDto;
import com.sebrae.desafio.dto.request.ContaRequest;
import com.sebrae.desafio.dto.response.PagedResponse;
import com.sebrae.desafio.service.ContaService;
import com.sebrae.desafio.util.HateoasUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/v1/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;
    private final HateoasUtil<ContaDto> hateoasUtil;
    private final HateoasUtil<Map<String, Object>> hateoasUtilMap;

    @GetMapping
    public ResponseEntity<PagedResponse<ContaDto>> getAllContas(
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "nome", direction = Sort.Direction.ASC)
            })
            Pageable pageable) {

        Page<ContaDto> associadoDtos = contaService.getAllContas(pageable);
        return ResponseEntity.ok(hateoasUtil.buildResponseList(associadoDtos));
    }

    @PostMapping
    public ResponseEntity<ContaDto> createConta(@RequestBody ContaRequest contaRequest) {

        var contaDto = contaService.createConta(contaRequest);
        return ResponseEntity
                .created(hateoasUtil.getHateoasSelLik(ContaController.class, contaDto.getId()))
                .body(contaDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContaDto> updateConta(
            @PathVariable("id") Long id,
            @RequestBody ContaRequest contaRequest) {

        var contaDto = contaService.updateConta(id, contaRequest);
        return ResponseEntity.ok(contaDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaDto> getContaById(@PathVariable("id") Long id) {

        var contaDto = contaService.getContaById(id);

        if (nonNull(contaDto)) {
            return ResponseEntity.ok(contaDto);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable("id") Long id) {

        contaService.deleteConta(id);
        return ResponseEntity.noContent().build();
    }
}
