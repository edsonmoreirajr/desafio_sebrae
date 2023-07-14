package com.sebrae.desafio.repository;

import com.sebrae.desafio.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
