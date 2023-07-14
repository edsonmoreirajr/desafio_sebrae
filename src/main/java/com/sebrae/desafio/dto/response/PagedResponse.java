package com.sebrae.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> implements Serializable {
    private List<T> data;
    private Meta meta;
    private Links links;
}
