package com.mnrega.usecases;

import java.util.ArrayList;
import java.util.List;

import com.mnrega.Dao.GpmDaoImpl;
import com.mnrega.Exception.GPMException;

public class GetEmployee {

	public static void main(String[] args) {
		GpmDaoImpl gpm = new GpmDaoImpl();
		List<Object> l1 = new ArrayList<>();
		try {
			l1 = gpm.getEmployees();
			l1.forEach(I -> System.out.println(I));
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
