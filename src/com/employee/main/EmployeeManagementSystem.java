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
            System.out.println("2.View Employees");
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
                    String name = sc.nextLine().toLowerCase();
                    System.out.println("Enter Department : ");
                    String dept = sc.nextLine().toLowerCase();
                    System.out.println("Enter Salary : ");
                    Double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine().toLowerCase();
                    Employee emp = new Employee(0,name,dept,salary,email);
                    dao.addEmployee(emp);
                    break;
                case 2:
                    System.out.println("Choices to Find Employee by :");
                    System.out.println("1.By Employee Id");
                    System.out.println("2.By Employee name ");
                    System.out.println("3.By Employee department");
                    System.out.println("4.By Employee salary");
                    System.out.println("5.By Employee Email");
                    System.out.println("6.EXIT");
                    System.out.println("Enter your choice : ");
                    int choicesToFind = sc.nextInt();
                    sc.nextLine();
                    switch (choicesToFind){
                        case 1:
                            System.out.println("Enter Employee ID :");
                            int id = sc.nextInt();
                            Employee empl = dao.getEmployeeById(id);
                            if(empl!=null){
                                System.out.println(empl);
                            }else{
                                System.out.println("Employee NOT FOUND");
                            }
                            break;
                        case 2:
                            System.out.println("Enter Employee name :");
                            String empName = sc.nextLine().toLowerCase();
                            Employee empl1 = dao.getEmployeeByName(empName);
                            if(empl1!=null){
                                System.out.println(empl1);
                            }else{
                                System.out.println("Employee NOT FOUND");
                            }
                            break;
                        case 3:
                            System.out.println("Enter Employee department :");
                            String empDepartment = sc.nextLine().toLowerCase();
                            List<Employee> empl2 = dao.getEmployeesByDepartment(empDepartment);
                            if(empl2!=null){
                                empl2.forEach(System.out::println);
                            }else{
                                System.out.println("Employee NOT FOUND");
                            }
                            break;
                        case 4:
                            System.out.println("Enter Employee salary :");
                            Double empSalary = sc.nextDouble();
                            sc.nextLine();
                            List<Employee> empl3 = dao.getEmployeesBySalary(empSalary);
                            if(empl3!=null){
                                empl3.forEach(System.out::println);
                            }else{
                                System.out.println("Employee NOT FOUND");
                            }
                            break;
                        case 5:
                            System.out.println("Enter Employee Email :");
                            String empEmail = sc.nextLine().toLowerCase();
                            Employee empl4 = dao.getEmployeeByName(empEmail);
                            if(empl4!=null){
                                System.out.println(empl4);
                            }else{
                                System.out.println("Employee NOT FOUND");
                            }
                            break;
                        case 6:
                            System.out.println("Exiting... GoodBye!");
                            sc.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice! Try Again.");
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
