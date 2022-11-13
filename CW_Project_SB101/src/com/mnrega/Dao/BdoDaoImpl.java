package com.mnrega.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mnrega.Exception.BDOException;
import com.mnrega.Jdbc_Connector.Jdbc_Connection;
import com.mnrega.model.BdoDetails;
import com.mnrega.model.ProjectDetails;
import com.mysql.cj.xdevapi.Result;

public class BdoDaoImpl implements BdoDao{

	@Override
	public BdoDetails login(String username, String password) throws BDOException {
		
		BdoDetails obj = new BdoDetails();
		
		Connection conn = Jdbc_Connection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT username,password from bdo");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String un = rs.getString("username");
				String pass = rs.getString("password");
				
				if(un.equals(username) && pass.equals(password)) {
					
					PreparedStatement ps2 = conn.prepareStatement("SELECT Bdoname from BDO where username=? AND password=?");
					ps2.setString(1, username);
					ps2.setString(2, password);
					
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						String name = rs2.getString("bdoname");
						System.out.println("Welcome: "+name);
					}else {
						System.out.println("Name not specified yet");
					}
					
					return obj;
				}
				
				else {
					throw new BDOException("Invalid username or password");
				}
			}
			else {
				throw new BDOException("No user exits");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public String createProject(int projId, String pname, String startDate, String completionDate)
			throws BDOException {
		String message = "Project not created";
		
		Connection conn = Jdbc_Connection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into project(projId,pname,Start_date,completion_date) Values(?,?,?,?)");
			
			ps.setInt(1, projId);
			ps.setString(2, pname);
			ps.setString(3, startDate);
			ps.setString(4, completionDate);
			
			int x = ps.executeUpdate();
		
			message = (x+" Query updated successfuly");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			//throw new BDOException("Incorrect data type inserted");
		}
		
		return message;
	}

	@Override
	public List<Object> getProjects() {
		// TODO Auto-generated method stub
		List<Object> l1 = new ArrayList<>();
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Select * from project");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int projId = rs.getInt("projId");
				String pname = rs.getString("pname");
				String startDate = rs.getString("start_Date");
				String completionDate = rs.getString("completion_date");
				int gpmId = rs.getInt("gpmId");
				
				l1.add("ProjId: "+projId+", Project name: "+pname+", Start Date: "+startDate+", Completion Date: "+completionDate+", GpmId: "+gpmId);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return l1;
	}

	@Override
	public String createGpm(int gpmId, String name, String address) throws BDOException {
		String message = "GPM not Inserted ";
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into gpm(gpmId,gpmname,gpmlocation) values(?,?,?)");
			ps.setInt(1, gpmId);
			ps.setString(2,name);
			ps.setString(3,address);
			
			int x = ps.executeUpdate();
			message = x+" Query updated successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return message;
	}

	@Override
	public List<Object> getGpm() {
		// TODO Auto-generated method stub
		List<Object> l1 = new ArrayList<>();
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Select * from GPM");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int gpmid = rs.getInt("gpmId");
				String gpmName = rs.getString("gpmname");
				String gpmlocation = rs.getString("gpmlocation");
				int projid = rs.getInt("projId");
				
				l1.add("GpmId is: "+gpmid+", GpmName is: "+gpmName+", GpmLocation is: "+gpmlocation+", ProjId is: "+projid);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return l1;
	}

	@Override
	public String allocateToGpm(int projId, int gpmId) throws BDOException {
		String message = "Not Allocated";
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update gpm set projId=? where gpmId=?");
			ps.setInt(1, projId);
			ps.setInt(2, gpmId);
			
			int x = ps.executeUpdate();
			
			message = x+" query updated successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Object> getEmployeeByBod(int projId) throws BDOException {
		List<Object> l1 = new ArrayList<>();
		
		Connection conn = Jdbc_Connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(" select e.projId, e.empId, e.empname, s.wages from employee e INNER JOIN salary s ON e.empId = s.empId where projId = ?");
			ps.setInt(1, projId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int proId = rs.getInt("projId");
				int empId = rs.getInt("empId");
				String ename = rs.getString("empname");
				int wages = rs.getInt("wages");
				
				l1.add("ProjId is: "+proId+", EmpId is: "+empId+", EmpName is: "+ename+", Wages are: "+wages);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				
		
		
		return l1;
	}
}
