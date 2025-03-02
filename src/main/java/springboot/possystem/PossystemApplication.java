package springboot.possystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "springboot.possystem")
public class PossystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PossystemApplication.class, args);
	}

}
