package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import repository.PetRepository;

@SpringBootApplication
@ComponentScan(basePackages={"controller", "service"})
@EnableMongoRepositories(basePackageClasses=PetRepository.class)
public class GetapetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetapetApplication.class, args);
	}
}
