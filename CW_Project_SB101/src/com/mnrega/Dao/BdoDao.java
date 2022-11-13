package com.mnrega.Dao;

import java.util.List;

import com.mnrega.Exception.BDOException;
import com.mnrega.model.BdoDetails;

public interface BdoDao {
	
	public BdoDetails login(String username, String password) throws BDOException;
	
	public String createProject(int projId, String pname, String start_Date, String completionDate) throws BDOException;
	
	public List<Object> getProjects();
	
	public String createGpm(int gpmId, String name, String address) throws BDOException;
	
	public List<Object> getGpm();
	
	public String allocateToGpm(int projId, int gpmId) throws BDOException;
	
	public List<Object> getEmployeeByBod(int projId) throws BDOException;

}
