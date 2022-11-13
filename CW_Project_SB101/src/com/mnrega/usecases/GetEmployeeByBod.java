package com.mnrega.usecases;
import java.util.*;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Exception.BDOException;

public class GetEmployeeByBod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Object> l1 = new ArrayList<>();
		
		System.out.println("Enter projId to get list of employees");
		int projId = sc.nextInt();
		
		BdoDaoImpl bdo = new BdoDaoImpl();
		try {
			l1 = bdo.getEmployeeByBod(projId);
			l1.forEach(I -> System.out.println(I));
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
