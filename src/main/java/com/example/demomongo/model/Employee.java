package com.example.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
    @Id
    String Id;
    String name;
    Long salary;

    public Employee() {
    }

    public Employee(String id, String name, Long salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
