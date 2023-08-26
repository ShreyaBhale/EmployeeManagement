package com.empManage;

import java.sql.*;

public class EmployeeDaoImp implements EmployeeDaoInterface{

	Connection con;
	
	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		con = DBConnection.createDBConnection();
		String query = "insert into employee values(?, ?, ?, ?);";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setInt(3, emp.getAge());
			pstm.setDouble(4, emp.getSalary());
			
			int cnt = pstm.executeUpdate();
			if(cnt != 0) {
				System.out.println("Employee added successfully");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void showEmployee() {
		// TODO Auto-generated method stub
		con = DBConnection.createDBConnection();
		String query = "select * from employee";
		
		System.out.println("Employee Details: ");
		System.out.println("-----------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Age", "Salary");
		System.out.println("-----------------------------------------");

		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%d\t%f\n", 
						result.getInt(1),
						result.getString(2),
						result.getInt(3),
						result.getDouble(4));
				System.out.println("-----------------------------------------");

			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedonID(int id) {
		// TODO Auto-generated method stub
		con = DBConnection.createDBConnection();
		String query = "select * from employee where id="+id;
		
		System.out.println("Employee Details: ");
		System.out.println("-----------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Age", "Salary");
		System.out.println("-----------------------------------------");

		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%d\t%f\n", 
						result.getInt(1),
						result.getString(2),
						result.getInt(3),
						result.getDouble(4));

			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con = DBConnection.createDBConnection();
		String query = "update employee set name=? where id=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			
			int cnt = pstm.executeUpdate();
			if(cnt != 0) {
				System.out.println("Employee details updated successfully");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		con = DBConnection.createDBConnection();
		String query = "delete from employee where id=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			int cnt = pstm.executeUpdate();
			if(cnt != 0) {
				System.out.println("Employee details deleted successfully");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
