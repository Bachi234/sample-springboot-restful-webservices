package net.schalegroup.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRestfulWebservicesApplication {
	@Bean //configure ModelMapper class as a SPRING BEAN and will register in out app context.
	public ModelMapper modelMapper(){
		return new ModelMapper();//method for ModelMapper
	}
	public static void main(String[] args) {SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);}
}
