package com.example.employee;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String SSN;
    private String department;
    private Integer salary;
    private Boolean active;
    private String startDate;




    public Employee(String id, String firstName, String lastName, String SSN,String department, Integer salary, Boolean active, String startDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.department=department;
        this.salary = salary;
        this.active = active;
        this.startDate = startDate;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    /* "id": Number,
            "firstName": String,
            "lastName": String,
            "SSN": String,
            "department": String,
            "salary": Number,
            "active": Boolean,
            "startDate": String*/
}
