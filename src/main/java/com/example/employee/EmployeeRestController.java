package com.example.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> employee(@PathVariable String id){
        //ResponseEntity.status(HttpStatus.NOT_FOUND);
        Employee getEmployee = repository.getEmployee(id);

        if(getEmployee!=null)
           return ResponseEntity.status(HttpStatus.OK).body(getEmployee);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getEmployee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> post(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.addEmployee(employee));


    }

    @PutMapping("/employees/{id}")
    public Employee put(@PathVariable String id, @RequestBody Employee employeeFromBody) {
        employeeFromBody.setId(id);
        System.out.println(employeeFromBody.getActive());
        return repository.editEmployee(employeeFromBody);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String>  delete(@PathVariable String id) {

       Boolean employeeExist = repository.deleteEmployee(id);

        if(employeeExist)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }
}
