package com.mnrega.usecases;
import java.util.*;

import com.mnrega.Dao.GpmDaoImpl;
import com.mnrega.Exception.GPMException; 
public class CreateEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter EmpId: ");
		int empId = sc.nextInt();
		
		System.out.println("Enter EmpName: ");
		String ename = sc.next();
		
		System.out.println("Enter EmpLocation: ");
		String elocation = sc.next();
		
		GpmDaoImpl gpm = new GpmDaoImpl();
		try {
			String message = gpm.createEmployee(empId, ename, elocation);
			System.out.println(message);
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
