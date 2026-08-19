package com.aulaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaApiApplication.class, args);
	}

}

/*
	controler -> receber requisição http
	service -> regras de negócio
	repository -> armazenamento (JPA)
		banco de dados -> ORM (h2=memória, depois pode migrar para mysql)
*/
