package assignment3;

import java.util.Scanner;

public class Recursion {
	
	/********************Question 2**********************************/	
   /****************************************************************/
	
	public static String removeDuplicate(String S) {
		if (S.length()==1)
			return S;
		//checks if two consecutive chars are the same
		else if (S.charAt(0)==S.charAt(1)) {
			return removeDuplicate(S.substring(1)); 
		}
		else
			return S.charAt(0) + removeDuplicate(S.substring(1));
	}

	public static int Fibonacci(int n) {
		if (n<0)
			return n;
		else if (n==0)
			return 0;
		else if (n==1)
			return 1;
		else 
			return Fibonacci(n-1) + Fibonacci(n-2);
	}

	public static boolean notAdjacent(int[] num, int index, int i) {
		if (index >= num.length) {
			return i==0;
		}
		if (notAdjacent(num, index+1,i))
			return true;
		if (notAdjacent(num,index+2,i-num[index]))
			return true;
		return false;
	}

	public static boolean equalSum(int[]num, int i, int firstSum,int secondSum) {
		if(i>=num.length)
			return firstSum==secondSum;
		int a=num[i];
		if (equalSum(num, i+1,firstSum+a,secondSum))
			return true;
		if (equalSum(num, i+1,firstSum,secondSum+a));
		return true;
	}




	public static int[]  promptArray() {
		//methods that promts the user for the size and elements of an array
		System.out.println("How many numbers does your array have?");
		int size=chooseNum();
		System.out.println(" ");
		int [] integers = new int[size];
		for(int i=0;i<size;i++) {
			System.out.println("Enter element "+ i + " of your array");
			int a=chooseNum();
			integers[i]=a;
		}
		System.out.println(" ");

		return integers;
	}


	//method to handle Number Format Exception
	public static int chooseNum()
	{
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
			return chooseNum();
		}
	}


	//menu
	public void menu() {
		int choice = 0;
		int exit=1;
		//menu is displayed after every choice except 5 that sets exit to 0 and exits the menu
		while(exit!=0) {
			System.out.println("");
			System.out.println("1.	Equal Sum");
			System.out.println("2.	Remove Duplicates");
			System.out.println("3.	Fibonacci");
			System.out.println("4.	Sums but not adjacent");
			System.out.println("5.	Exit");
			System.out.println("--------------------");
			System.out.println("Enter choice");


			// prompts the user for a number
			choice = chooseNum();

			switch(choice) {
			case 1:	
				System.out.println(" ");
				if (equalSum(promptArray(),0,0,0)==false) { 
					System.out.println("false");
					System.out.println("Your array cannot be split into two groups of equal sum");
				}
				else {
					System.out.println("true");
					System.out.println("Your array can be split into two groups of equal sum");
				}
				System.out.println(" ");
				break;


			case 2:
				Scanner scan=new Scanner (System.in);
				System.out.println(" ");
				System.out.println("Enter a string that you want to remove its consecutive duplicate characters");
				String s=scan.next();
				System.out.println("Your string without consecutive duplicate characters:  "+ removeDuplicate(s));
				System.out.println(" ");
				break;				


			case 3:
				System.out.println(" ");
				System.out.println("The Fibonacci sequence is: 1, 1, 2, 3, 5, 8, 13, … ");
				System.out.println( "Where each the number is the sum of the  previous two numbers.");
				System.out.println("Which number of the Fibonacci sequence do you want?");
				int fibo = chooseNum();
				System.out.println("The number is: "+ Fibonacci(fibo));
				System.out.println(" ");
				break;


			case 4:
				System.out.println(" ");
				System.out.println("Choose a number");
				int i=chooseNum();
				if (notAdjacent(promptArray(),0,i)==false) {
					System.out.println("false");
					System.out.println("We cannot choose numbers from your array such that the sum of these  non adjacent numbers is equal to the number you chose");
				}
				else {
					System.out.println("true");
					System.out.println("We can choose numbers from your array such that the sum of these  non adjacent numbers is equal to the number you chose");
				}
				System.out.println(" ");
				break;


			case 5:
				System.out.println(" ");
				System.out.println("Exiting...");
				exit=0;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

	public static void main(String[] Args) {
		Recursion r=new Recursion();
		r.menu();

	}
}

