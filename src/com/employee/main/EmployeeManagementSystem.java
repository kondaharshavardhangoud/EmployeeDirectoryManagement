package com.employee.main;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImpl;
import com.employee.model.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();
        while(true){
            System.out.println("\n ===========Employee Management System===========");
            System.out.println("1.Add Employee");
            System.out.println("2.View Employee");
            System.out.println("3.View All Employees");
            System.out.println("4.Update Employee");
            System.out.println("5.Delete Employee");
            System.out.println("6.Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Department : ");
                    String dept = sc.nextLine();
                    System.out.println("Enter Salary : ");
                    Double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    Employee emp = new Employee(0,name,dept,salary,email);
                    dao.addEmployee(emp);
                    break;
                case 2:
                    System.out.println("Enter Employee ID :");
                    int id = sc.nextInt();
                    Employee empl = dao.getEmployeeById(id);
                    if(empl!=null){
                        System.out.println(empl);
                    }else{
                        System.out.println("Employee NOT FOUND");
                    }
                    break;
                case 3:
                    List<Employee> allEmployees = dao.getAllEmployees();
                    allEmployees.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter Employee ID to Update ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Employee employeees = dao.getEmployeeById(updateId);
                    if(employeees!=null){
                        System.out.println("Enter the updated Name ");
                        String updatedName = sc.nextLine();
                        employeees.setName(updatedName);
                        System.out.println("Enter the updated Department ");
                        String updatedDepartment = sc.nextLine();
                        employeees.setDepartment(updatedDepartment);
                        System.out.println("Enter the updated Salary ");
                        Double updatedSalary = sc.nextDouble();
                        sc.nextLine();
                        employeees.setSalary(updatedSalary);
                        System.out.println("Enter the update Email");
                        String updatedMail = sc.nextLine();
                        employeees.setEmail(updatedMail);
                        dao.updateEmployee(employeees);
                    }else{
                        System.out.println("Employee NOT FOUND");
                    }
                    break;
                case 5:
                    System.out.println("Enter the Employee ID to Delete");
                    int delID = sc.nextInt();
                    boolean k = dao.deleteEmployee(delID);
                    if(k) System.out.println("Employee Deleted Successfully! ");
                    break;
                case 6:
                    System.out.println("Exiting... GoodBye!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try Again.");
            }
        }
    }
}
