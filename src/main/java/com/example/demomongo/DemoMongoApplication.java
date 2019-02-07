package com.example.demomongo;

import com.example.demomongo.model.Employee;
import com.example.demomongo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoMongoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoMongoApplication.class);

	@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository){
		return args -> {
			employeeRepository.deleteAll()
					.subscribe(null, null , () -> {
						Stream.of(new Employee(UUID.randomUUID().toString(),"Peter", 20000L),
								new Employee(UUID.randomUUID().toString(),"Hari", 22000L),
								new Employee(UUID.randomUUID().toString(),"Jan", 23000L))
								.forEach(employee -> {
									employeeRepository.save(employee)
									.subscribe(System.out::println);
								});
					});
		};
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoMongoApplication.class, args);
	}



}

