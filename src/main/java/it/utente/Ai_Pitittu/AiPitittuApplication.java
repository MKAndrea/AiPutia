package it.utente.Ai_Pitittu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "it.utente.Ai_Pitittu")
@EntityScan(basePackages = "it.utente.Ai_Pitittu.Model")
@EnableJpaRepositories(basePackages = "it.utente.Ai_Pitittu.Repository")
public class AiPitittuApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiPitittuApplication.class, args);
	}

}
