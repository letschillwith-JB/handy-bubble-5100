package com.mnrega.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mnrega.Dao.GpmDaoImpl;
import com.mnrega.Exception.GPMException;

public class GetEmpWagesWorkDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Object> l1 = new ArrayList<>();
		
		System.out.println("Enter EmpID ");
		int empId = sc.nextInt();
		
		GpmDaoImpl gpm = new GpmDaoImpl();
		try {
			l1 = gpm.getEmpWages(empId);
			if(l1.size()==0)System.out.println("No employee exist with id="+empId);
			else
			l1.forEach(I -> System.out.println(I));
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
