package com.SpringCloud.Spring_Cloud;

import com.SpringCloud.Spring_Cloud.Entities.Customer;
import com.SpringCloud.Spring_Cloud.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"test","test@email.com"));
			customerRepository.save(new Customer(null,"test2","test3@email.com"));
			customerRepository.save(new Customer(null,"test","test4@email.com"));
			customerRepository.findAll().forEach(customer -> System.out.println(customer));

		};
	}
}
