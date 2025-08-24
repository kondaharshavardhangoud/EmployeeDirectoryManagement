# Employee Directory Management System

A simple **Java-based Employee Management System** using JDBC and MySQL.  
This project allows adding, updating, viewing, and deleting employee records from a MySQL database.

---

## Features

- Add new employees with details: Name, Department, Salary, Email
- View single employee by ID
- View all employees
- Update employee details
- Delete employee records
- Console-based menu interface

---

## Technology Stack

- **Language:** Java 21
- **Database:** MySQL
- **JDBC:** Java Database Connectivity for DB operations
- **IDE:** IntelliJ IDEA (recommended)
- **Build Tool:** Maven (optional)

---

## Project Structure

Employee Directory Management System/
│
├── src/
│ ├── com.employee.main/ # Main class with menu system
│ ├── com.employee.dao/ # DAO interfaces and implementations
│ ├── com.employee.model/ # Employee model class
│ └── com.employee.util/ # DBConnection utility
│
├── target/ # Compiled classes (ignored in Git)
├── .gitignore # Git ignore file
├── pom.xml # Maven build file
└── README.md


---

## Database Setup

1. Create a MySQL database:

```sql
CREATE DATABASE employee_db;
Create the employees table:

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(100),
    salary DOUBLE,
    email VARCHAR(100) UNIQUE
);


Update your DBConnection.java with database credentials:

String url = "jdbc:mysql://localhost:3306/employee_db";
String username = "root";
String password = "your_password";

**How to Run**

Clone the repository:

git clone https://github.com/kondaharshavardhangoud/EmployeeDirectoryManagement.git


Open the project in IntelliJ IDEA.

Build and run the project.

Follow the console menu to manage employees.

Usage Example
==========Employee Management System===========
1. Add Employee
2. View Employee
3. View All Employees
4. Update Employee
5. Delete Employee
6. Exit
Enter your choice:

Notes

Do not commit the target/ folder or compiled .class files.

Recommended to use a .gitignore file to exclude:

target/
*.class
.idea/
*.iml
