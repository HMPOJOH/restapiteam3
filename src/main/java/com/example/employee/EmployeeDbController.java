package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeDbController {

    EmployeeDbRepository DbRepository;

    @Autowired
    public EmployeeDbController(EmployeeDbRepository DbRepository){
        this.DbRepository = DbRepository;
    }

    @GetMapping("/dbemployees")
    public List<Employee> employees(){
        return DbRepository.getEmployees();

    }

    @GetMapping("/dbemployees/{id}")
    public Employee employee(@PathVariable String id, HttpServletResponse response){
        Optional<Employee> getEmployee = DbRepository.getEmployee(id);
        if(getEmployee.isPresent()){
            return getEmployee.get();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

    }

    @PostMapping("/dbemployees")
    public Employee post(@RequestBody Employee employee) {
       DbRepository.createEmployee(employee);
        return employee;

    }

}
