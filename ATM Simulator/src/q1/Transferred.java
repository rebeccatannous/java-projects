package q1;

import java.util.Scanner;

public class Transferred extends Transaction{
private int to;
private int from;

	public Transferred(Person person, double amount) {
		super(person, amount);
	}
	public Transferred(Person person, double amount, int from,int to) {
		super(person, amount);
		this.setFrom(from);
		this.to=to;
	}

	//function to handle Number Format Exception
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

	public static Long chooseLong()
	{
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			long i = Long.parseLong(a);
			while(i<=0) {
				a = scan.next();
				i = Long.parseLong(a);
			}
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseLong();
		}
	}
	
	public void makeTrans(double money, int a) {
		System.out.println("To which account do you wish to transfer " + money +"$ ?");
		person.displayAcc();
		long acc=chooseLong();
		int to=person.getAccount(acc);
		if(to!=-1) {
		person.transfer(money, a, to);	
		}
		else {
			System.out.println("Account not found");
			System.out.println("Could not process your transaction");
		}		
	}

	public String displayFile() {
		String STR="Transferred" + " , "+ person.getClient_num() + " , " + amount + " , " + to +" , "+ from;
		return STR;
	}
	
	public void makeTransQ(double money, int a,int b) {
		person.transferQ(money, a, b);	
	}


	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String toString() {
		String STR="Type: Transferred\n";
		 STR+="Amount: " + amount + "$\n";
		 STR+="From Account : "+ person.getAcc().get(from).getData().getAcc_num() +"\n";
		 STR+="To Account : "+ person.getAcc().get(to).getData().getAcc_num()+ "\n";

		 return STR;

	}

	
}
