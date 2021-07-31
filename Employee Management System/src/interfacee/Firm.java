package interfacee;
import java.util.*;

/* Name: Rebecca Tannous
Date last modified: 13/3/2020
Project description: This program manages employees in a firm 
by hiring, listing , firing  and raising their salary
Other files: Employee.java , Staff.java , Executive.java , Member.java , FullTime.java*/

public class Firm {
	/*to store employees in the firm*/
	Employee[] firm = new Employee[10];
	/*array to store meeting, a max of 5 meetings can be held*/
	String[] meeting=new String[5];
	//int to keep track of meetings
	static int meeting_count=0;
	//keeps track of number of employees in the firm
	static int count = 0;
	int staff;
	int exec;	
	//a meeting can only be held at 1,2,3,4 and 5 PM
	int five=0, four=0 , three=0, two=0, one=0;


	public void ensureCapacity() {
		//increases the capacity of the array of employees
		Employee[] temp=new Employee[firm.length*2+1];
		//copy the element of firm to temp
		for (int i = 0; i < firm.length; i++) {
			temp[i]=firm[i];
		}
		//point to the same object
		firm=temp;
	}   


	public void display() {
		//if the array is not empty all employees are displayed
		if (count!=0) {
			if(exec!=0) {
				System.out.println("----------------------");
				System.out.println("Executives are:");
				System.out.println("----------------------");


				for (int i=0; i<count; i++)
				{
					if (firm[i] instanceof Executive)
						System.out.println(firm[i]);
				}
			}

			if (staff!=0) {
				System.out.println("");
				System.out.println("");
				System.out.println("----------------------");
				System.out.println("Staff are:");
				System.out.println("----------------------");

				for (int i=0; i<count; i++)
				{
					if (firm[i] instanceof Staff)
						System.out.println(firm[i]);

				}

			}
		}
		else 
			System.out.println("No employees in this firm");
	}


	public int find(String name) {
		/* returns the index of the employee according to the name, -1 if employee is not found.*/
		int index=-1;
		//search in array for the name
		//we assume that names are unique, no employees have the same name
		for (int i = 0; i < count; i++) {
			if(firm[i].getName().equalsIgnoreCase(name)) {
				index = i;	
			}
		}
		return index;
	}


	public void hire() {

		if(count == firm.length)
			ensureCapacity();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee you want to hire");
		String name=scan.next();
		System.out.println("Enter the salary of the employee");
		double salary=chooseDouble();
		while(salary<0) {
			System.out.println("Invalid enter again");
			salary=chooseDouble();
		}
		System.out.println("");
		System.out.println("Choose the type of the  employee");
		System.out.println("1-Staff");
		System.out.println("2-Executive");

		int x = chooseInt();
		switch(x) {
		/*checks if the employee is an executive or staff */
		case 1:
			Employee SS = new Staff (name, salary);
			firm[count] = SS;
			count++;
			staff++;
			break;

		case 2:
			Employee EE = new Executive (name , salary, false);
			firm[count] = EE;
			count++;
			exec++;
			break;	

		default:
			System.out.println("Invalid choice");
		}

		System.out.println("");
		System.out.println("Employee " + name + " added");

	}


	public void awardBonus() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter name of Employee that you want to award a bonus");
		String bonus=scan.next();
		//search for employee
		int index=find(bonus);
		if (index<0) {
			System.out.println("Employee not found");
		}
		else {
			//only executives can be awarded a bonus
			if (firm[index] instanceof Executive) {
				((Executive)firm[index]).addBonus();
				System.out.println("Bonus added");
				System.out.println("Executive's salary is now:" + firm[index].getSalary() + "$");
			}
			else {
				System.out.println("Only Executives can be awarded bonus");
			}
		}

	}


	public void fire() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee you want to fire");
		String name= scan.next();
		int index=-1;

		index =find(name);	

		if(index <0)//not found
			System.out.println("Employee not found.");
		else {
			//the employee has been found
			System.out.println("Would you like to fire this employee? y/n");
			System.out.println(firm[index]);
			String choice= scan.next();
			if(choice.equalsIgnoreCase("y")) {
				//the user wants to fire the employee
				if (firm[index] instanceof Staff){
					staff--;
				}else {
					exec--;
				}
				firm[index]=firm[count-1];
				firm[count-1]=null;
				count--;
				
				System.out.println(name + " was fired");
			}
			else if(choice.equalsIgnoreCase("n")) {
				//the user does not want to delete the employee
				System.out.println("Employee will not be fired");
			} else {
				System.out.println("Invalid input.");
			}

		}
	}


//	public void takeVacation() {
//		Scanner scan = new Scanner (System.in);
//		//prompts the user for the name of the employee that he wants to give a vacation to
//		System.out.println("Enter name of employee that you want to give a vacation to");
//		String vacay=scan.next();
//		int index=find(vacay);
//		if (index<0) {
//			System.out.println("Employee not found");
//		}
//		else {
//			String choice="y";
//			if(((Executive)firm[index]).getVacation()==false) {
//			System.out.println("Executives who go on vacations will not be able to hold meetings");		
//			System.out.println("Their meetings will be held in their absence");
//			System.out.println("Would you like to give a vacation to this employee? y/n");
//			System.out.println(firm[index]);
//				choice= scan.next();
//			}
//			if(choice.equalsIgnoreCase("y")) {
//				//if the employee is an executive he can go on vacation
//				if (firm[index] instanceof Executive) {
//					((Executive)firm[index]).vacation();
//
//
//				}else if(choice.equalsIgnoreCase("n")) {
//					//the user does not want to delete the employee
//					System.out.println("Employee will not go pn vacation");
//				}
//				else
//					System.out.println("Invalid input");
//			}
//			else {
//				//if the employee is a staff he cannot take a vacation
//				System.out.println("Only Executives can have vacations");
//			}
//		}
//	}



	public void raisesal() {

		Scanner scan = new Scanner (System.in);
		System.out.println("Enter name of Employee that you want to give a raise");
		String name=scan.next();
		System.out.println("By how much do you want to raise the salary?");
		int percent=chooseInt();
		//search for the employee
		int index=find(name);
		if (index<0) {
			System.out.println("Employee not found");
		}
		else {
			if (firm[index] instanceof Executive)
				((Executive)firm[index]).raise(percent);
			else
				((Staff)firm[index]).raise(percent);

			System.out.println("Salary raised by " + percent + "%");
			System.out.println("Salary is now:" + firm[index].getSalary() + "$");
		}

	}


	public void holdMeeting() {
		Scanner scan = new Scanner (System.in);

		if (meeting_count==5) {
			System.out.println("A maximum of five meetings can be held");
		}
		else {	
			System.out.println("Enter name of Employee that wants to hold a meeting");
			String holder=scan.next();
			int index=find(holder);
			if (index<0) {
				System.out.println("Employee not found");
			}
			else
				if (firm[index] instanceof Executive) {

					/*only executives who are not on vacation can hold meetings*/
					if(((Executive)firm[index]).getVacation()==false) {
						System.out.println("When do you wanna schedule the meeting?");
						System.out.println("1.	1:00 PM");
						System.out.println("2.	2:00 PM");
						System.out.println("3.	3:00 PM");
						System.out.println("4.	4:00 PM");
						System.out.println("5.	5:00 PM");
						int hour=chooseInt();
						switch(hour) {
						case 1:
							if(one==0) {
								one++;

								((Executive) firm[index]).holdMeeting(1);
								meeting[meeting_count]="Meeting at 1:00 PM with " + holder;
								meeting_count++;
							} 
							else {
								System.out.println("There's already a meeting at 1:00PM");
							}
							break;
						case 2:
							if(two==0) {
								two++;

								((Executive) firm[index]).holdMeeting(2);
								meeting[meeting_count]="Meeting at 2:00 PM with " + holder;
								meeting_count++;
							} 
							else {
								System.out.println("There's already a meeting at 2:00PM");
							}
							break;
						case 3:
							if(three==0) {
								three++;

								((Executive) firm[index]).holdMeeting(3);
								meeting[meeting_count]="Meeting at 3:00 PM with " + holder;
								meeting_count++;
							} 
							else {
								System.out.println("There's already a meeting at 3:00PM");
							}
							break;
						case 4:
							if(four==0) {
								four++;

								((Executive) firm[index]).holdMeeting(4);
								meeting[meeting_count]="Meeting at 4:00 PM with " + holder;
								meeting_count++;
							} 
							else {
								System.out.println("There's already a meeting at 4:00PM");
							}

							break;
						case 5:
							if(five==0) {
								five++;

								((Executive) firm[index]).holdMeeting(4);
								meeting[meeting_count]="Meeting at 5:00 PM with " + holder;
								meeting_count++;
							} 
							else {
								System.out.println("There's already a meeting at 5:00PM");
							}

							break;

						default:
							System.out.println("Invalid input");

						}
					}
					else {
						System.out.println("This employee is on vacation and cannot hold a meeting");
					}
				}


				else {
					System.out.println("Only Executives can hold meetings");
				}
		}
	}


	public void viewMeeting() {
		if (meeting_count!=0) {
			System.out.println("Meetings:");
			System.out.println("---------------------");
			for(int i=0;i<meeting_count;i++) {
				System.out.println(meeting[i]);
			}
			System.out.println("---------------------");
		}else {
			System.out.println("No meetings");
		}
	}


	public static int chooseInt()
	{	//method to handle Number Format Exception
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			int i = Integer.parseInt(a);
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseInt();
		}
	}


	public static double chooseDouble()
	{
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			double i = Double.parseDouble(a);
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseDouble();
		}
	}


	public void menu(){
		int choice = 0;
		int exit=1;
		Scanner scan=new Scanner (System.in);
		//menu is displayed after every choice except 7 that sets exit to 0 and exits the menu
		while(exit!=0) {
			System.out.println("");
			System.out.println("1.	Hire Employee");
			System.out.println("2.	Fire Employee");
			System.out.println("3.	Payment");
			System.out.println("4.	List Employees");
			System.out.println("5.	Meeting");
			System.out.println("6.	Exit");
			System.out.println("--------------------");
			System.out.println("Enter choice");


			// prompts the user for a number
			choice = chooseInt();

			switch(choice) {

			case 1:
				System.out.println("");
				hire();
				System.out.println("");
				break;

			case 2:
				System.out.println("");
				fire();
				System.out.println("");
				break;

			case 3:
				System.out.println("");
				System.out.println("1.	Raise salary");
				System.out.println("2.	Add bonus");
				int choose=chooseInt();

				switch(choose) {
				case 1:
					System.out.println("");
					raisesal();
					break;

				case 2:
					System.out.println("");
					awardBonus();
					break;
				}
				break;

			case 4:
				System.out.println("");
				display();
				break;	

			case 5:
				System.out.println("");
				System.out.println("1.	Hold meeting");
				System.out.println("2.	View meetings");
				int choice1 = chooseInt();
				switch(choice1) {
				case 1:
					System.out.println("");
					holdMeeting();
					break;
				case 2: 
					System.out.println("");
					viewMeeting();
					break;
				}

				break;

			case 6:
					
				System.out.println("Exiting...");
				System.out.println("");
				exit=0;
				break;

			default:
				System.out.println("Invalid input");
			}
		}
	}


	public static void main(String[] args) {
		Firm f = new Firm();
		f.menu();
	}
}

