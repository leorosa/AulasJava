package com.security.Autenticacao_avancada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.Autenticacao_avancada.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
