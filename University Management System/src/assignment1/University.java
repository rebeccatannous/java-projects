package assignment1;

import java.util.*;

/* Name: Rebecca Tannous
   Date last modified: 8/2/2020
   Project description: This program manages employees in a university 
   by adding, listing , deleting employees and raising their salary
   Other files: Employee.java , Staff.java , Faculty.java */
 
public class University {
	public static void main (String[] args){

		Scanner scan = new Scanner (System.in);
		Vector Employees = new Vector();
		int choice =0;
		int invalid =0;
		int attempts = 6;

		while (choice != 5 && invalid!=6) {

			//prints a message informing the user how many consecutive attempts are left before exiting the program
			if (attempts !=6 && invalid !=0)
			{
				if (attempts == 1) {
					System.out.println("----------------------");
					System.out.println("" + attempts + " attempt before exiting the program");
					System.out.println("----------------------");
				}
				else {
					System.out.println("----------------------");
					System.out.println("" + attempts + " attempts before exiting the program");
					System.out.println("----------------------");
					System.out.println("Enter again");
				}
			}



			// Menu 
			System.out.println("");
			System.out.println("----------------------");
			System.out.println("1.Add employee ");
			System.out.println("2.Delete employee ");
			System.out.println("3.List all");
			System.out.println("4.Raise Salary");
			System.out.println("5.Exit");
			System.out.println("----------------------");
			System.out.println("Enter your choice: ");
			System.out.println("");


			// prompts the user for a number
			choice = scan.nextInt();


			switch(choice) {
			case 1:
				//adds an employee
				invalid =0;
				attempts = 6;
				System.out.println("");
				System.out.println("Enter the first name of the employee you want to add");
				String fn=scan.next();
				System.out.println("Enter the last name of the employee you want to add");
				String ln=scan.next();
				String n= fn + " " + ln;
				System.out.println("Enter recruitment date of employee");
				String d= scan.next();
				System.out.println("Enter salary of employee");
				double s= scan.nextDouble();

				System.out.println("");
				System.out.println("Choose the type of the  employee");
				System.out.println("1-Staff");
				System.out.println("2-Faculty");

				int x = scan.nextInt();
				switch(x) {
				/*checks if the employee is a faculty or staff to see 
                whether to prompt the user for teaching load or not */
				case 1:
					Staff SS = new Staff (n , d , s);
					Employees.addElement(SS);
					Employee.increment();
					break;
				case 2:
					System.out.println("Enter teaching load ");
					int t =scan.nextInt();
					Faculty f = new Faculty (n , d , s , t);
					Employees.addElement(f);
					Employee.increment();
					break;	
				default:
					System.out.println("Invalid choice");
				}

				System.out.println("");
				System.out.println("Employee " + n + " added");
				break;



			case 2:
				/*prompts the user for the name of the employee, searches for it, 
				  deletes it if found, displays a message otherwise */
				invalid =0;
				attempts = 6;

				System.out.println("Enter the first name of the employee you want to delete");
				String fn1 = scan.next();
				System.out.println("Enter the last name of the employee you want to delete");
				String ln1 = scan.next();
				String name1= fn1 + " " + ln1;
				boolean found= false;

				for (int i=0; i<Employees.size();i++)
				{
					if ((((Employee) Employees.elementAt(i)).getName()).equalsIgnoreCase(name1))
					{
						found = true;

						System.out.println("Are you sure you want to delete: (y/n)");
						System.out.println((Employees.elementAt(i)).toString());
						String yn =scan.next();

						if (yn.equalsIgnoreCase("Y"))
						{
							Employees.remove(i);
							Employee.decrement();
							System.out.println("Employee "+ name1 + " deleted " );
						}
						else 
							System.out.println("operation cancelled");
					}

				}
				
				if (found == false)
					System.out.println("Employee not found");
				System.out.println("");

				break;


			case 3:	
				//lists the information of all faculty then all staff.
				attempts = 6;
				invalid =0;
				System.out.println("----------------------");
				System.out.println("Faculty members are:");
				System.out.println("----------------------");


				for (int i=0; i<Employees.size(); i++)
				{
					if (Employees.elementAt(i) instanceof Faculty)
						System.out.println((Employees.elementAt(i)).toString());
				}

				System.out.println("");
				System.out.println("");
				System.out.println("----------------------");
				System.out.println("Staff are:");
				System.out.println("----------------------");

				for (int i=0; i<Employees.size(); i++)
				{
					if (Employees.elementAt(i) instanceof Staff)
						System.out.println((Employees.elementAt(i)).toString());

				}


				break;


			case 4:
				/*prompts the user for the name of the employee and the percentage
				  then raises the salary according to the employee's type */
				attempts = 6;
				invalid =0;
				boolean found1 = false;
				System.out.println("----------------------");
				System.out.println("Enter first name of the employee you want to give a raise");
				String fn3 =scan.next();
				System.out.println("Enter last name of the employee you want to give a raise");
				String ln3 =scan.next();
				String name2 = fn3  + " " + ln3;
				for (int i=0; i<Employees.size();i++)
				{
					if ((((Employee) Employees.elementAt(i)).getName()).equalsIgnoreCase(name2))
					{
						found1 = true;
						System.out.println("By what percentage do you want to raise the salary?");
						double percent= scan.nextDouble();

						if ((Employees.elementAt(i)) instanceof Faculty)
						{
							((Faculty) Employees.elementAt(i)).raise(percent);
							((Faculty) Employees.elementAt(i)).addBonus();
						}
						else 
							((Staff) Employees.elementAt(i)).raise(percent);
						System.out.println("Salary raised by "+ percent + "%");

					}
				}
				if (found1 == false)
					System.out.println("Employee not found");
				System.out.println("");

				break;


			case 5:
				//Exits the program
				System.out.println("----------------------");
				System.out.println("Exiting the program");
				System.out.println("----------------------");
				break;


			default: 
				System.out.println("----------------------");
				System.out.println("Invalid choice");
				invalid++;
				attempts--;


			}

			if (invalid == 6)
			{
				//prints message informing the user that the program has ended after more than five consecutive invalid choices
				System.out.println("----------------------");
				System.out.println("You entered more than 5 consecutive invalid choices");
				System.out.println("Exiting the program");
				System.out.println("----------------------");
			}

		}

	}

}