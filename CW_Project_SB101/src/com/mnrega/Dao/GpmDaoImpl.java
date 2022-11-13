package com.mnrega.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mnrega.Exception.GPMException;
import com.mnrega.Jdbc_Connector.Jdbc_Connection;
import com.mnrega.model.BdoDetails;

public class GpmDaoImpl implements GpmDao{

	@Override
	public void Gpmlogin(String username, String password) throws GPMException {
		
		Connection conn = Jdbc_Connection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT username,password from gpm where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String un = rs.getString("username");
				String pass = rs.getString("password");
				
				if(un.equals(username) && pass.equals(password)) {
					
					PreparedStatement ps2 = conn.prepareStatement("SELECT GpmName from gpm where username=? AND password=?");
					ps2.setString(1, username);
					ps2.setString(2, password);
					
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						String gpmName = rs2.getString("GpmName");
						System.out.println("Welcome: "+gpmName);
					}else {
						System.out.println("Name not specified yet");
					}
					
					
				}
				
				else {
					throw new GPMException("Invalid username or password");
				}
			}
			else {
				throw new GPMException("No user exits");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public String createEmployee(int empId, String ename, String location) throws GPMException {
		// TODO Auto-generated method stub
		String message = "Employee not added";
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee(empId,empName,empLocation) values(?,?,?)");
			ps.setInt(1, empId);
			ps.setString(2, ename);
			ps.setString(3, location);
			
			int x = ps.executeUpdate();
			message = x+" Employee added successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Object> getEmployees() throws GPMException {
		// TODO Auto-generated method stub
		List<Object> l1 = new ArrayList<>();
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("empId");
				String empname = rs.getString("empName");
				String empLocation = rs.getString("empLocation");
				int projId = rs.getInt("projId");
				
				l1.add("EmpId is: "+empId+", EmpName: "+empname +", EmpLocation: "+empLocation+", ProjId: "+projId);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		return l1;
	}

	@Override
	public String assignProjectToEmployee(int empId, int projId) throws GPMException {
		// TODO Auto-generated method stub
		String message = "Project not assigned";
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set projId=? where empId = ?");
			ps.setInt(1, projId);
			ps.setInt(2, empId);
			
			int x = ps.executeUpdate();
			
			message = x+" Query updated successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				
		
		return message;
	}

	@Override
	public List<Object> getEmpWages(int empId) throws GPMException {
		// TODO Auto-generated method stub
		List<Object> l1 = new ArrayList<>();
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from salary where empId=?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int worked = rs.getInt("NodWorked");
				int wages = rs.getInt("wages");
				int salary = rs.getInt("totalSalary");
				
				l1.add("No Of Days Worked: "+worked+", Wages: "+wages+", Total Salary: "+salary);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new GPMException("No employee exist with empId "+empId);
		}
		
		return l1;
	}

}
