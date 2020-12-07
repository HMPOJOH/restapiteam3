package com.example.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDbRepository {
    EmployeeMongoRepository emp;

   /* EmployeeDbRepository(){

        createEmployee(new Employee("1", "Greta", "Garbo","19450408","Sales",500000,false,"1965-01-01"));

    }*/

    EmployeeDbRepository(EmployeeMongoRepository emp) {

        this.emp = emp;
    }


    public List<Employee> getEmployees() {
        return emp.findAll();
    }

    public void createEmployee(Employee employee){
        if(employee.getActive()==null)
            employee.setActive(false);

        emp.insert(employee);
    }

    public Optional<Employee> getEmployee(String id) {
        Optional<Employee> getEmp = emp.findById(id);
        return getEmp;
    }
}


interface EmployeeMongoRepository extends MongoRepository<Employee, String> {}