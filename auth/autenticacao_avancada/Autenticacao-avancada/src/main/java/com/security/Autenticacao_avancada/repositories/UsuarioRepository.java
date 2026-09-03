package com.security.Autenticacao_avancada.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.Autenticacao_avancada.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	 Optional<Usuario> findByUsername(String username);
}
