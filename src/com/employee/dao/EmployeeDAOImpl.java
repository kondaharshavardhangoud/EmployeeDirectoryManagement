package com.employee.dao;

import com.employee.model.Employee;
import com.employee.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee emp) {
        String query = "INSERT INTO employees (name,department,salary,email) VALUES (?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1,emp.getName());
            ps.setString(2,emp.getDepartment());
            ps.setDouble(3,emp.getSalary());
            ps.setString(4,emp.getEmail());
            ps.executeUpdate();
            System.out.println("Employee added Successfully!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> newEmployees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                newEmployees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("email")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newEmployees;
    }

    @Override
    public void updateEmployee(Employee emp) {
        String query = "UPDATE employees SET name=?,department=?,salary=?,email=? WHERE id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1,emp.getName());
            ps.setString(2,emp.getDepartment());
            ps.setDouble(3,emp.getSalary());
            ps.setString(4,emp.getEmail());
            ps.setInt(5,emp.getId());
            ps.executeUpdate();
            System.out.println("Employee Updated Successfully!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            if(i!=0){
                System.out.println("Employee with id "+id+"Deleted Successfully.");
                return true;
            }else{
                System.out.println("Employee NOT FOUND");
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
