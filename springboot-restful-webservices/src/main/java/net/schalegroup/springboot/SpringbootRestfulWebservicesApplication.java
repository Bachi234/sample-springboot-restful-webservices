package net.schalegroup.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "SCHALE REST API Documentation",
				version = "1.0.0",
				contact = @Contact(
						name = "Jared Chan",
						email = "jgchan2541@gmail.com",
						url = "https://github.com/Bachi234"
				),
				license = @License(
						name = "Apache 2.4.63",
						url = "https://www.SCHALE-GROUP.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot SCHALE Management Documentation",
				url = "https://www.SCHALE-GROUP.com/schale_management.html"
		)
)
public class SpringbootRestfulWebservicesApplication {
	@Bean //configure ModelMapper class as a SPRING BEAN and will register in out app context.
	public ModelMapper modelMapper(){
		return new ModelMapper();//method for ModelMapper
	}
	public static void main(String[] args) {SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);}
}
