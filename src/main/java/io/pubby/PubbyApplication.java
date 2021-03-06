package io.pubby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.pubby.repositories.PlayerRepository;
import io.pubby.models.Player;

@SpringBootApplication
public class PubbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubbyApplication.class, args);

	}

}
