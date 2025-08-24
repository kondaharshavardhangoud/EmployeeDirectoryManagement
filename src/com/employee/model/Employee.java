package com.employee.model;

public class Employee {
    int id;
    String name;
    String email;
    String department;
    Double salary;

    public Employee(int id,String name,String department, Double salary,String email){
        this.department=department;
        this.email=email;
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
