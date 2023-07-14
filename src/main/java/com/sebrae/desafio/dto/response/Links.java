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
public class Links implements Serializable {

    private String self;
    private String first;
    private String prev;
    private String next;
    private String last;
}
