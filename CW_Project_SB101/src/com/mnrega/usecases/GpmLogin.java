package com.mnrega.usecases;

import java.util.Scanner;

import com.mnrega.Dao.BdoDaoImpl;
import com.mnrega.Dao.GpmDaoImpl;
import com.mnrega.Exception.BDOException;
import com.mnrega.Exception.GPMException;
import com.mnrega.model.BdoDetails;

public class GpmLogin {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		GpmDaoImpl gpm = new GpmDaoImpl();
		
		try {
			gpm.Gpmlogin(username, password);
			
			//here you need to add switch case
			System.out.println("1 - Create Employee ");
			System.out.println("2 - View Details of Employees");
			System.out.println("3 - Assign Employee to a Project");
			System.out.println("4 - Veiw No.of days Employee Worked & wages");
			
			int x = sc.nextInt();
			
			if(x==0) {
				System.out.println("Thank You ");sc.close();
			}else {
				while(x>0) {
					switch(x) {
					
					
					case (1):CreateEmployee.main(args); 
					break;
					
					case (2):GetEmployee.main(args);
					break;
					
					case (3):AssignProjectToEmployee.main(args); 
					break;
					
					case (4):GetEmpWagesWorkDays.main(args);
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
			
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
