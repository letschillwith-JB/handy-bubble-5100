package com.mnrega.usecases;
import java.util.Scanner;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Exception.BDOException;
import com.mnrega.model.BdoDetails;

public class BdoLogin {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		BdoDetails bdo = new BdoDetails();
		
		BdoDaoImpl objImpl = new BdoDaoImpl();
		
		try {
			bdo = objImpl.login(username, password);
			
			//here you need to add switch case
			System.out.println("1 - Create a project ");
			System.out.println("2 - View List of project ");
			System.out.println("3 - Create a Gram Panchayat Member ");
			System.out.println("4 - Veiw all Gram Panchayat Member  ");
			System.out.println("5 - Allocate Project To Gram Panchayat Member");
			System.out.println("6 - See List of Emp working on projects & wages");
			
			int x = sc.nextInt();
			
			if(x==0) {
				System.out.println("Thank You ");sc.close();
			}else {
				while(x>0) {
					switch(x) {
					
					
					case (1):CreateProject.main(args); 
					break;
					
					case (2):GetProjects.main(args);
					break;
					
					case (3):CreateGpm.main(args); 
					break;
					
					case (4):GetGpm.main(args);
					break;
					
					case (5):AllocateToGpm.main(args); 
					break;
					
					case (6):GetEmployeeByBod.main(args);
					break;
					
					default: System.out.println("Please select valid number");
					
					}
					System.out.println("Want to Perform more y/n");
					if(sc.next().equals("y")) {
					
						System.out.println("Enter query Number : ");
						 x = sc.nextInt();
						 
						
					}else {
						System.out.println("Thank You! Have a nice day...");
						x=0;sc.close();
					}
				}
			}
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
