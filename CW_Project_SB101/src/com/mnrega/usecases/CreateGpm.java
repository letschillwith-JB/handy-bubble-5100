package com.mnrega.usecases;
import java.util.Scanner;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Exception.BDOException;

public class CreateGpm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GpmId");
		int gpmId = sc.nextInt();
		
		System.out.println("Enter Gpm Name");
		String gpmname = sc.next();
		
		System.out.println("Enter Gpm Location");
		String gpmaddress = sc.next();
		
		BdoDaoImpl bdoImpl = new BdoDaoImpl();
		try {
			String message = bdoImpl.createGpm(gpmId, gpmname, gpmaddress);
			System.out.println(message);
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
