package com.example.demomongo.resources;

import com.example.demomongo.model.Employee;
import com.example.demomongo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {


    private EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getId(@PathVariable("id") final String empid){
        return employeeRepository.findById(empid);
    }


}
