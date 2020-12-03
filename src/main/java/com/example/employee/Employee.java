package com.example.employee;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String SSN;
    private Integer salary;
    private Boolean active;
    private String startDate;

    public Employee(Long id, String firstName, String lastName, String SSN, Integer salary, Boolean active, String startDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.salary = salary;
        this.active = false;
        this.startDate = startDate;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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




    /* "id": Number,
            "firstName": String,
            "lastName": String,
            "SSN": String,
            "department": String,
            "salary": Number,
            "active": Boolean,
            "startDate": String*/
}
