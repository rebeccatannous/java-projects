package q1;

import java.util.Scanner;

public class Main {


	public void menu() {
		LinkedList initial_list= new LinkedList();
		Scanner scan=new Scanner(System.in);
		LinkedList l=new LinkedList();
		//prompts the user for the size of the list
		System.out.println("Enter the size of your list");
		int size=initial_list.chooseNum();
		//checks if the user entered a valid value for the size
		while(size<1) {
			System.out.println("Choose a positive integer different than 0");
			size=initial_list.chooseNum();
		}
		//prompts the user for the elements of his list
		for (int i=0;i<size;i++) {
			System.out.println("Enter element " + i + " of your list");
			String s=scan.next();
			initial_list.add(s);
		}	
		initial_list.display();


		int exit=1;
		/*menu is displayed after every choice except 6 and any other 
		invalid choice that sets exit to 0 and exits the menu*/
		while(exit!=0) {
			System.out.println("1.	Includes");
			System.out.println("2.	Remove Duplicates");
			System.out.println("3.	Reverse");
			System.out.println("4.	Return Odd");
			System.out.println("5.	Make Doubly Linked List");
			System.out.println("6.	Exit ");
			System.out.println("- - - - - -");
			System.out.println("Input your choice:");
			String a;
			try 
			{
				a = scan.next();
				int i = Integer.parseInt(a);
				switch(i) {
				case 1:
					initial_list.included(initial_list.makeList());
					break;
				case 2:
					initial_list.removeDuplicate(initial_list.makeList());
					break;

				case 3:
					initial_list.reverse();
					break;
				case 4:
					initial_list.odd();
					break;
				case 5:
					initial_list.DLL();
					break;
				case 6:
					//sets exit to 0 to exit the program
					System.out.println("Exiting the program");
					exit=0;
					break;
				default:
					//any invalid choice sets exit to 0
					exit=0;
					System.out.println("Invalid choice");
					System.out.println("Exiting the program");


				}
			}
			catch(NumberFormatException e)
			{
				//any choice other than integers sets exit to 0
				System.out.println("Invalid choice.");
				System.out.println("Exiting the program.");
				exit=0;
			}


		}
	}

	public static void main(String[] Args) {
		Main m=new Main();
		m.menu();	
	}

}




