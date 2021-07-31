/* Name: Rebecca Tannous
   Date last modified: 29/4/2020
   Project description: This program manages an ATM
   Other files: Queue.java , Account.java , Credited,java , Debited,java
    LinkedList.java , Node,java , Person.java , Transaction.java , Transferred.java
    Identification.txt , Users.txt , Transactions.txt  */
 
package q1;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class ATM {
	Vector Users;
	Queue transact;
	//keeps track of how many items are enqueued
	static int transaction_queued;
	
	public ATM() {

		Users = new Vector();
		transact=new Queue(3);
		transaction_queued=0;
	}

	//methods to handle Number Format Exceptions
	public static int chooseInt()
	{
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			int i = Integer.parseInt(a);
			while(i<=0) {
				a = scan.next();
				i = Integer.parseInt(a);
			}
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseInt();
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

	public static double chooseDouble()
	{
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			double i = Double.parseDouble(a);
			while(i<=0) {
				a = scan.next();
				i = Double.parseDouble(a);
			}
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseDouble();
		}
	}


	public void updateFile() {
		try {
			//writes in file
			FileWriter fw = new FileWriter("C:\\Users\\other\\Desktop\\LAU\\Spring 2020\\CP2\\CP2 Zip\\Assignment5\\src\\q1\\Users");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < Users.size(); i++)
			{
				Person p=(Person) Users.elementAt(i);

				bw.write(p.getName()+ " , " + p.getClient_num() + " , "+ p.displayFile()+"\n");

			}
			bw.close();	
			fw.close();

		}
		catch(IOException e) {
			System.out.println();
		}



	}




	public void readTrans() {
		//methods that reads transactions from the last run of the code and enqueues them after creating the appropriate objects
		try {
			FileReader fr = new FileReader(new File("C:\\Users\\other\\Desktop\\LAU\\Spring 2020\\CP2\\CP2 Zip\\Assignment5\\src\\q1\\Transactions"));
			BufferedReader br = new BufferedReader(fr);

			String line="";
			while((line=br.readLine())!=null) {
				try {

					String[] tran=line.split(" , ");	
					Person p=(Person) Users.elementAt(Integer.parseInt(tran[0]));
					if(tran[1].equalsIgnoreCase("Credited")) {
						Credited c=new Credited(p,Double.parseDouble(tran[3]),Integer.parseInt(tran[4]));
						transact.enqueue(c);
						transaction_queued++;
					}else if(tran[1].equalsIgnoreCase("Transferred"))
					{
						Transferred t=new Transferred(p,Double.parseDouble(tran[3]),Integer.parseInt(tran[4]),Integer.parseInt(tran[5]));
						transact.enqueue(t);
						transaction_queued++;
					}else  {
						Debited d=new Debited(p,Double.parseDouble(tran[3]),Integer.parseInt(tran[4]));
						transact.enqueue(d);
						transaction_queued++;

					}
					
				}
				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}
			br.close();

		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("Users.txt not found");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeTransaction(int x) {
		//Writes all the enqueued transactions to a file after the user logs off
		try {
			int front=transact.getFront();
			int rear=transact.getRear();

			FileWriter fw = new FileWriter("C:\\Users\\other\\Desktop\\LAU\\Spring 2020\\CP2\\CP2 Zip\\Assignment5\\src\\q1\\Transactions");
			BufferedWriter bw = new BufferedWriter(fw);

			if(transaction_queued==0)
				bw.write("");
			else if(transaction_queued==1) {
				if(transact.get(front) instanceof Credited)
					bw.write(x+ " , "+((Credited) transact.get(front)).displayFile() +"\n");
				else if(transact.get(front) instanceof Debited)
					bw.write(x+ " , "+((Debited) transact.get(front)).displayFile() +"\n");
				else 
					bw.write(x+ " , "+((Transferred) transact.get(front)).displayFile() +"\n");
			}
			else if(rear>front) {
				for(int j=0;j<transaction_queued;j++) {
					if(transact.get(j)!=null) {
						if(transact.get(front) instanceof Credited)
							bw.write(x+ " , "+((Credited) transact.get(j)).displayFile() +"\n");
						else if(transact.get(j) instanceof Debited)
							bw.write(x+ " , "+((Debited) transact.get(j)).displayFile() +"\n");
						else 
							bw.write(x+ " , "+((Transferred) transact.get(j)).displayFile() +"\n");
					}

				}

			}

			else if (rear<front) {
				for(int i=front;i<transaction_queued;i++) {
					if(transact.get(i)!=null) {
						if(transact.get(i) instanceof Credited)
							bw.write(x+ " , "+((Credited) transact.get(i)).displayFile() +"\n");
						else if(transact.get(i) instanceof Debited)
							bw.write(x+ " , "+((Debited) transact.get(i)).displayFile() +"\n");
						else 
							bw.write(x+ " , "+((Transferred) transact.get(i)).displayFile() +"\n");
					}

				}

				for(int j=0;j<=rear;j++) {
					if(transact.get(j) instanceof Credited)
						bw.write(x+ " , "+((Credited) transact.get(j)).displayFile() +"\n");
					else if(transact.get(j) instanceof Debited)
						bw.write(x+ " , "+((Debited) transact.get(j)).displayFile() +"\n");
					else 
						bw.write(x+ " , "+((Transferred) transact.get(j)).displayFile() +"\n");
				}

			}
			bw.close();	
			fw.close();

		}
		catch(IOException e) {
			System.out.println();
		}
		catch(ClassCastException e) {
			System.out.println();
		}


	}

	public void displayTransaction(long a) {
		//displays each user's transactions
		int front=transact.getFront();
		int rear=transact.getRear();
		try {
			if(transaction_queued==0)
				System.out.println();
			else if(transaction_queued==1 && transact.get(front)!=null && ((Transaction) transact.get(front)).getPerson().getClient_num()==a) {
				System.out.println(transact.get(front) +"\n");

			}
			else if(rear>front) {
				for(int j=0;j<transaction_queued;j++) {
					if(transact.get(j)!=null && ((Transaction) transact.get(j)).getPerson().getClient_num()==a) {

						System.out.print(transact.get(j) +"\n");

					}
				}
			}
			else if (rear<front) {
				for(int i=front;i<transaction_queued;i++) {
					if(transact.get(i)!=null && ((Transaction) transact.get(i)).getPerson().getClient_num()==a) {

						System.out.print(transact.get(i)+"\n");
					}
					for(int j=0;j<=rear;j++) {
						if(transact.get(j)!=null && ((Transaction) transact.get(j)).getPerson().getClient_num()==a) {

							System.out.print(transact.get(j)+"\n");
						}
					}
				}

			}
		}
		catch(ClassCastException e) {
			System.out.println();
		}

	}	

	public int hasTransaction(long a) {
		//checks if the user has any pending transaction
		int front=transact.getFront();
		int rear=transact.getRear();
		int d=0;
		try {
			if(transaction_queued==1 && transact.get(front)!=null && ((Transaction) transact.get(front)).getPerson().getClient_num()==a) {
				d++;
			}
			else if(rear>front) {
				for(int j=0;j<transaction_queued;j++) {
					if(transact.get(j)!=null && ((Transaction) transact.get(j)).getPerson().getClient_num()==a) {
						d++;

					}
				}
			}
			else if (rear<front) {
				for(int i=front;i<transaction_queued;i++) {
					if(transact.get(i)!=null && ((Transaction) transact.get(i)).getPerson().getClient_num()==a) {
						d++;
					}
					for(int j=0;j<=rear;j++) {
						if(transact.get(j)!=null && ((Transaction) transact.get(j)).getPerson().getClient_num()==a) {
							d++;
						}
					}
				}

			}
		}
		catch(ClassCastException e) {
			System.out.println();
		}
		return d;
	}

	public void createUsers() {
		//reads the users from a file and creates them
		int skip=0;
		try {
			FileReader fr = new FileReader(new File("C:\\Users\\other\\Desktop\\LAU\\Spring 2020\\CP2\\CP2 Zip\\Assignment5\\src\\q1\\Users"));
			BufferedReader br = new BufferedReader(fr);
			int s=0;

			String line="";
			while((line=br.readLine())!=null) {
				try {

					String[] users=line.split(" , ");	
					LinkedList Accounts=new LinkedList();
					for(int i=2;i<users.length;i=i+3) {
						if(users[i+1].equalsIgnoreCase("Checking")||users[i+1].equalsIgnoreCase("Savings")) {
							Account acc=new Account(Long.parseLong(users[i]),users[i+1],Double.parseDouble(users[i+2]));
							Accounts.add(acc);
							s++;
						}
						else {
							skip=1;
							continue;

						}
					}
					if(skip==0) {
						Person p = new Person(users[0],Long.parseLong(users[1]),Accounts);
						Users.addElement(p);


					}
					skip=0;
				}
				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}
			br.close();

		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("Users.txt not found");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AtmClosed(){
		//method to output a message if ATM is closed
		System.out.println("The ATM is closed");
		System.out.print("Your transactions will be processed");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime today = LocalTime.now();
		String timeString = today.format(formatter);
		int time=Integer.parseInt(timeString.substring(0, 2));
		LocalDate date = LocalDate.now(); 
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue();
		if(dayOfWeekIntValue==6) 
			System.out.print(" Monday after 6:00 AM");
		else
			System.out.print(" Tomorrow after 6:00 AM");

	}

	public boolean time() {
		//Checks if it's a working day/hour
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime today = LocalTime.now();
		String timeString = today.format(formatter);
		int time=Integer.parseInt(timeString.substring(0, 2));
		LocalDate date = LocalDate.now(); 
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue();
		if(dayOfWeekIntValue==7) 
			return true;
		else if(time>18 || time<6) 
			return true;
		else 
			return false;
	}

	public void dequeuing() {
		//dequeues and makes transactions at working hours
		if(time()==false) {
			while(transact.empty()==false) {
				if(transact.peek() instanceof Transferred) {
					Transferred t=(Transferred) transact.peek();
					t.makeTransQ(t.getAmount(), t.getFrom(),t.getTo());
					transact.dequeue();
					transaction_queued--;
				}
				else if(transact.peek() instanceof Credited) {
					Credited c=(Credited) transact.peek();
					c.makeTransQ(c.getAmount(), c.getAcc());
					transaction_queued--;
					transact.dequeue();
				}
				else {
					Debited d=(Debited) transact.peek();
					d.makeTransQ(d.getAmount(), d.getAcc());
					transaction_queued--;
					transact.dequeue();
				}
			}
			updateFile();
		}
	}

	public Object[] enterCredentials() {
		//asks the user for their number and password
		Scanner scan =new Scanner(System.in);
		Object[] O = new Object[2];
		System.out.println("Enter your identification number");
		Long num=chooseLong();
		O[0]=num;
		System.out.println("Enter your password");
		String pass=scan.next();
		O[1]=pass;
		return O;
	}

	public long login() {
		long log=password(enterCredentials());
		while(log==-1) {
			log=password(enterCredentials());
		}
		return log;		
	}

	public long password(Object[] O) {
		//reads all passwords from file
		Scanner scan =new Scanner(System.in);
		int validpass=-1;
		int validnum=-1;
		long valid=-1;
		Long num=(Long) O[0];
		String pass=(String) O[1];

		try {
			FileReader fr = new FileReader(new File("C:\\Users\\other\\Desktop\\LAU\\Spring 2020\\CP2\\CP2 Zip\\Assignment5\\src\\q1\\Identification"));
			BufferedReader br = new BufferedReader(fr);

			String line="";
			while((line=br.readLine())!=null) { 
				validpass=-1;
				validnum=-1;
				try {

					String[] passwords=line.split(" , ");

					if(Long.parseLong(passwords[0])==num) {
						validnum=0;
					}
					if(passwords[1].equals(pass))
						validpass=0;

					if(validnum==0 && validpass==0) {
						valid=num;
						break;
					}
				}

				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}

			}
			br.close();

		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("Users.txt not found");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validnum==-1) {
			System.out.println("Invalid identification number");
			System.out.println();
		}
		else if(validpass==-1) {
			System.out.println("Invalid password");
			System.out.println();
		}
		else {
		}

		return valid;
	}

	public int search(long a) {
		int index=-1;
		if(a!=-1)
			for (int i=0; i<Users.size(); i++) {
				if (((Person) Users.elementAt(i)).getClient_num()==a) {
					index=i;
				}

			}
		return index;
	}

	public void menu() {

		readTrans();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
		LocalTime today = LocalTime.now();
		String time = today.format(formatter);
		LocalDate date = LocalDate.now(); 
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		int exit=0;
		int repeat=0;
		while(repeat==0) {
			exit=0;
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println("Automated Teller Machine");
		System.out.println("-------------------------");
		System.out.println("-------------------------");

		int index=search(login());
		while(index==-1) {
			System.out.println("User not Found");
			System.out.println("Try again");
			index=search(login());	
		}
		System.out.println("Welcome !");
		while(exit==0) {
			System.out.println("");
			System.out.println("1.	Withdraw money");
			System.out.println("2.	Deposit money");
			System.out.println("3.	Transfer of Money");
			System.out.println("4.	Display account info");
			System.out.println("5.	Exit");
			System.out.println("--------------------");
			System.out.println("Enter choice");
			int choice=chooseInt();
			switch(choice) {
			case 1:
				dequeuing();
				System.out.println(((Person) Users.elementAt(index)).displayAcc());	
				System.out.println("From which account do you want to withdraw money?");
				long acc=chooseLong();
				int withdraw=((Person) Users.elementAt(index)).getAccount(acc);
				if(withdraw!=-1) {
					System.out.println("How much do you want to withdraw from this account?");
					double amountwith=chooseDouble();
					Debited d=new Debited(((Person) Users.elementAt(index)),amountwith);
					if(time()==false) {
						d.makeTrans(amountwith,withdraw);

						updateFile();
					}
					else {
						AtmClosed();
						transact.enqueue(d);
						transaction_queued++;
					}
				}

				else {
					System.out.println("Account not found");
					System.out.println("Could not process your transaction");
				}
				dequeuing();

				break;

			case 2:
				dequeuing();

				System.out.println(((Person) Users.elementAt(index)).displayAcc());	
				System.out.println("To which account do you want to deposit money?");
				long accc=chooseLong();
				int deposit=((Person) Users.elementAt(index)).getAccount(accc);
				if(deposit!=-1) {
					System.out.println("How much do you want to credit this account?");
					double amountdep=chooseDouble();
					Credited c=new Credited(((Person) Users.elementAt(index)),amountdep);
					if(time()==false) {
						c.makeTrans(amountdep,deposit);
						System.out.println(((Person) Users.elementAt(index)).getAcc().get(deposit).getData().getBalance());
						updateFile();
					}
					else {
						AtmClosed();

						transact.enqueue(c);
						transaction_queued++;
					}
				}
				else {
					System.out.println("Account not found");
					System.out.println("Could not process your transaction");
				}
				break;

			case 3:
				dequeuing();

				System.out.println(((Person) Users.elementAt(index)).displayAcc());	
				System.out.println("From which account do you want to transfer money?");
				long ac=chooseLong();
				int trans=((Person) Users.elementAt(index)).getAccount(ac);
				if(trans!=-1) {
					System.out.println("How much money do you want to transfer?");
					double amounttrans=chooseDouble();
					if(time()==false) {
						Transferred t=new Transferred(((Person) Users.elementAt(index)),amounttrans);
						t.makeTrans(amounttrans,trans);
						System.out.println(((Person) Users.elementAt(index)).getAcc().get(trans).getData().getBalance());
						updateFile();

					}
					else {

						System.out.println("To which account do you wish to transfer " + amounttrans +"$ ?");
						((Person) Users.elementAt(index)).displayAcc();
						long tran1=chooseLong();
						int to=((Person) Users.elementAt(index)).getAccount(tran1);
						if(to!=-1) {
							Transferred t2=new Transferred(((Person) Users.elementAt(index)),amounttrans,trans,to);
							transact.enqueue(t2);
							AtmClosed();
							transaction_queued++;
						}

						else {
							System.out.println("Account not found");
							System.out.println("Could not process your transaction");
						}
					}
				}


				else {
					System.out.println("Account not found");
					System.out.println("Could not process your transaction");
				}
				break;

			case 4:
				dequeuing();

				System.out.println(((Person) Users.elementAt(index)).displayAcc());
				break;
			case 5:
				if (hasTransaction(((Person) Users.elementAt(index)).getClient_num())!=0) {
					System.out.println();
					System.out.println("The following transactions are pending: \n");
					displayTransaction(((Person) Users.elementAt(index)).getClient_num());
				}

				dequeuing();
				writeTransaction(index);
				updateFile();
				exit=1;
				break;
			}
		}
	}
}
	public void display() {
		for (int i=0; i<Users.size(); i++)
		{
			System.out.println((Users.elementAt(i)).toString());
			System.out.println();
		}
	}

	public static void main(String[] Args) {

		ATM a=new ATM();
		a.createUsers();
		a.menu();
	}
}
