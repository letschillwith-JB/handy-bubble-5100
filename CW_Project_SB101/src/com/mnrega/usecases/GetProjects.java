package com.mnrega.usecases;

import java.util.ArrayList;
import java.util.List;

import com.mnrega.Dao.BdoDaoImpl;

public class GetProjects {
	
	public static void main(String[] args) {
		BdoDaoImpl bdoImpl = new BdoDaoImpl();
		
		List<Object> l1 = new ArrayList<>();
		l1 = bdoImpl.getProjects();
		if(l1.size()>0)
		l1.forEach(i -> System.out.println(i));
		else
			System.out.println("No Project exist ");
	}
}
