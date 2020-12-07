package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository(){
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "Greta", "Garbo","19450408","Sales",500000,false,"1965-01-01"));
        employees.add(new Employee(2L, "Arne", "Bengtsspn","19450412","Business Tech",300000,false,"1965-01-01"));
        employees.add(new Employee(3L, "Lena", "Johansson","19450401","Marketing",600000,false,"1965-01-01"));
        employees.add(new Employee(4L, "Gösta", "Aronsson","19690108","IT",700000,false,"1965-01-01"));
        employees.add(new Employee(5L, "Berit", "Goransson","19800458","Customer Service",500000,false,"1965-01-01"));
        employees.add(new Employee(6L, "Hasse", "Hansson","19800458","Customer Service",500000,false,"1965-01-01"));
        employees.add(new Employee(7L, "Niklas", "Istenes","19860458","Customer Service",500000,false,"1965-01-01"));
        employees.add(new Employee(8L, "Test", "testsson","19860458","TEST",500000,false,"1965-01-01"));
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
        employee.setId(lastEmployee.getId()+1);
        if(employee.getActive()==null)
            employee.setActive(false);// set an id on the new book, should be unique, will be done by the database in future exercises
        employees.add(employee);
        return employee;


    }


    // edit an employee
    public Employee editEmployee(Employee employee) {
        Employee employeeToEdit = this.getEmployee(employee.getId());
        if (employeeToEdit != null) {
            employeeToEdit.setId(employee.getId());
            employeeToEdit.setFirstName(employee.getFirstName());
         //  if(employee.getLastName()!=null && employee.getLastName().equals(employeeToEdit.getLastName()))
                employeeToEdit.setLastName(employee.getLastName());
            employeeToEdit.setDepartment(employee.getDepartment());
            employeeToEdit.setSalary(employee.getSalary());
            employeeToEdit.setActive(employee.getActive());
            //ssn och startdate inte möjlighet att editera.

        }
        return employeeToEdit;
    }

    // delete an employee
    public Boolean deleteEmployee(Long id) {
        Employee employeeToDelete = this.getEmployee(id);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            return true;
        }
        return false;
    }
}
