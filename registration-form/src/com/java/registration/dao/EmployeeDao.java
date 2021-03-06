package com.java.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.registration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		String sql="INSERT INTO Employee" + "(id, first_name, last_name, username, password, address, contact) VALUES"+"(?,?,?,?,?,?,?);";
		
		int result=0;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "aditi@123");
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, employee.getFirstname());
			pstmt.setString(3, employee.getLastname());
			pstmt.setString(4, employee.getUsername());
			pstmt.setString(5, employee.getPassword());
			pstmt.setString(6, employee.getAddress());
			pstmt.setString(7, employee.getContact());
			
			System.out.println(pstmt);
			
			result=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
