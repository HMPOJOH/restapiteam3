package com.example.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository(){
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "Greta", "Garbo","19450458",500000,false,"1965-01-01"));

    }

    // get one Employee
    public Employee getEmployee(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
    //get all employees
    public List<Employee> getEmployees() {
        return employees;
    }

    // add an employee
    public Employee addEmployee(Employee employee) {
        Employee lastEmployee = employees.get(employees.size()-1);
        employee.setId(lastEmployee.getId()+1); // set an id on the new book, should be unique, will be done by the database in future exercises
        employees.add(employee);
        return employee;
    }


    // edit an employee
    public Employee editEmployee(Employee employee) {
        Employee employeeToEdit = this.getEmployee(employee.getId());
        if (employeeToEdit != null) {
            employeeToEdit.setFirstName(employee.getFirstName());
            employeeToEdit.setLastName(employee.getLastName());
            employeeToEdit.setSSN(employee.getSSN());

            employeeToEdit.setSalary(employee.getSalary());
            employeeToEdit.setActive(employee.getActive());
            employeeToEdit.setStartDate(employee.getStartDate());
        }
        return employee;
    }

    // delete an employee
    public void deleteEmployee(Long id) {
        Employee employeeToDelete = this.getEmployee(id);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
        }
    }
}
