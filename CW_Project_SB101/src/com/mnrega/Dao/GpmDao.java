package com.mnrega.Dao;

import java.util.List;

import com.mnrega.Exception.BDOException;
import com.mnrega.Exception.GPMException;
import com.mnrega.model.BdoDetails;

public interface GpmDao {
	
	public void Gpmlogin(String username, String password) throws  GPMException;
	
	public String createEmployee(int empId, String ename, String location) throws GPMException;
	
	public List<Object> getEmployees() throws GPMException;
	
	public String assignProjectToEmployee(int empId, int projId) throws GPMException;
	
	public List<Object> getEmpWages(int empId) throws GPMException;

}
