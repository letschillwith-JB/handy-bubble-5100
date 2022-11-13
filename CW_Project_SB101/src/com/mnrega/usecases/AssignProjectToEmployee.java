package com.mnrega.usecases;

import java.util.Scanner;

import com.mnrega.Dao.GpmDaoImpl;
import com.mnrega.Exception.GPMException;

public class AssignProjectToEmployee {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ProjId: ");
		int projId = sc.nextInt();
		
		System.out.println("Enter EmpId: ");
		int empId = sc.nextInt();
		
		GpmDaoImpl gpm = new GpmDaoImpl();
		try {
			String message = gpm.assignProjectToEmployee(empId, projId);
			System.out.println(message);
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
