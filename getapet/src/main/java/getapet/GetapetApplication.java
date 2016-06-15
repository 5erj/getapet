package getapet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"controller"})
public class GetapetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetapetApplication.class, args);
	}
}
