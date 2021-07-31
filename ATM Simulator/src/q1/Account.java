package q1;

public class Account {
	private long acc_num;
	private String type;
	private double balance;


	public Account(long acc_num, String type, double balance) {
		this.acc_num = acc_num;
		this.type = type;
		this.balance = balance;
	}

	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean withdraw(double money) {
		if (money>balance) {
			return false;
		}
		else {
			balance=balance - money;
			System.out.println(money+ "$ has been deducted from your account " +  getAcc_num());
			return true;
		}
	}
//all methods with Q in them are for dequeuing only because the do not output anything on the screen
	public boolean withdrawQ(double money) {
		if (money>balance) {
			return false;
		}
		else {
			balance=balance - money;
			return true;
		}
	}
	public void deposit(double money) {
		balance+=money;
		System.out.println(money + "$ has been deposited into your account " +  getAcc_num());
	}
	public void depositQ(double money) {
		balance+=money;
	}

	public String toString() 
	{
		return "Number:" + acc_num + "\nType: " + type + "\nBalance: " + balance + "$\n";
	}
	
	public String displayFile() {
		return acc_num +" , "+ type +" , "+balance ;
	}
}






