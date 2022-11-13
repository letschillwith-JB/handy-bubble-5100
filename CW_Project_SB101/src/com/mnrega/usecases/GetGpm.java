package com.mnrega.usecases;
import java.util.*;

import com.mnrega.Dao.BdoDaoImpl;

public class GetGpm {

	public static void main(String[] args) {
		List<Object> l1 = new ArrayList<>();
		BdoDaoImpl bdo = new BdoDaoImpl();
		
		l1 = bdo.getGpm();
		
		if(l1.size()>0)
		l1.forEach(I -> System.out.println(I));
		else
			System.out.println("Gpm Not exist...");
	}
}
