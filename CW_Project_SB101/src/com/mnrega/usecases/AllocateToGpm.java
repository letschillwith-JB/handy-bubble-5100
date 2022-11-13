package com.mnrega.usecases;
import java.util.*;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Exception.BDOException;

public class AllocateToGpm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GpmId ");
		int gpmId = sc.nextInt();
		
		System.out.println("Enter ProjId ");
		int projId = sc.nextInt();
		
		BdoDaoImpl bdo = new BdoDaoImpl();
		try {
			String message = bdo.allocateToGpm(projId, gpmId);
			System.out.println(message);
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
