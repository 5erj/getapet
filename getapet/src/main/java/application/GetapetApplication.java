package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import repository.PetRepository;

@SpringBootApplication
@ComponentScan(basePackages={"controller", "service"})
@EnableMongoRepositories(basePackageClasses=PetRepository.class)
public class GetapetApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GetapetApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GetapetApplication.class, args);
	}
}
