package com.security.Autenticacao_avancada.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.Autenticacao_avancada.dto.CadastroDTO;
import com.security.Autenticacao_avancada.dto.LoginRequest;
import com.security.Autenticacao_avancada.entidades.Usuario;
import com.security.Autenticacao_avancada.repositories.UsuarioRepository;
import com.security.Autenticacao_avancada.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtService jwtService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {

		Usuario usuario = usuarioRepository.findByUsername(request.getUsername()).orElse(null);
  		if (usuario == null) {
			return ResponseEntity.status(401).body("Usuário ou senha inválidos");
		}

		if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
			return ResponseEntity.status(401).body("Usuário ou senha inválidos");
		}

		String token = jwtService.gerarToken(usuario.getUsername(),  usuario.getRole());

		return ResponseEntity.ok(Map.of("token", token));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrar(@RequestBody CadastroDTO request) {

		if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {

			return ResponseEntity.badRequest().body("Usuário já existe");
		}

		Usuario usuario = new Usuario();

		usuario.setNome(request.getNome());
		usuario.setUsername(request.getUsername());

		usuario.setPassword(passwordEncoder.encode(request.getPassword()));

		usuario.setRole("ADMIN");

		usuarioRepository.save(usuario);

		return ResponseEntity.ok("Usuário cadastrado com sucesso");
	}
}
