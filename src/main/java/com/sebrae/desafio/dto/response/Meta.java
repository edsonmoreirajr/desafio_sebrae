package com.sebrae.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Meta implements Serializable {
    private Long totalRecords;
    private Integer totalPages;
}
