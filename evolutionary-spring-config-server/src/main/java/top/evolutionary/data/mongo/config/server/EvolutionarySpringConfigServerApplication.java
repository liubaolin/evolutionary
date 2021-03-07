package top.evolutionary.data.mongo.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EvolutionarySpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolutionarySpringConfigServerApplication.class, args);
	}

}
