package com.mnrega.usecases;

import java.util.*;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Exception.BDOException;
import com.mnrega.model.ProjectDetails;

public class CreateProject {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ProjId");
		int projId = sc.nextInt();
		
		System.out.println("Enter Project name");
		String pname = sc.next();
		
		System.out.println("Enter Starting date");
		String startingDate = sc.next();
		
		System.out.println("Enter expected Completion date");
		String completionDate = sc.next();
		
		BdoDaoImpl bdoimpl = new BdoDaoImpl();
		try {
			String message = bdoimpl.createProject(projId, pname, startingDate, completionDate);
			System.out.println(message);
			
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
