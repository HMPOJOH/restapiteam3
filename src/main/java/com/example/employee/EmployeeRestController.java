package com.example.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> employees(){
        return repository.getEmployees();

    }

    @GetMapping("/employees/{id}")
    public Employee employee(@PathVariable Long id){
        return repository.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee post(@RequestBody E,ploye book) {
        return repository.addBook(book);
    }

}
