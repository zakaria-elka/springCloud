package com.SpringCloud.Spring_Cloud;


import com.SpringCloud.Spring_Cloud.entities.Customer;
import com.SpringCloud.Spring_Cloud.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"zakaria","zakaria@gmail.com"));
			customerRepository.save(new Customer(null,"test2","test3@hotmail.com"));
			customerRepository.save(new Customer(null,"ali","ali@gmail.com"));
			customerRepository.findAll().forEach(customer -> System.out.println(customer));

		};
	}
}
