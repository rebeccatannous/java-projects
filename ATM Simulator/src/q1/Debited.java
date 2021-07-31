package q1;

public class Debited extends Transaction{
private int acc;
	public Debited(Person person, double amount) {
		super(person, amount);
	}
	public Debited(Person person, double amount, int acc) {
		super(person, amount);
		this.acc=acc;
	}
	public void makeTransQ(double money, int a) 
		{
				person.withdrawQ(money, a);
	}

	public void makeTrans(double money, int a) 
	{

		
			person.withdraw(money, a);
		

}

	
	public int getAcc() {
		return acc;
	}

	
	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	public String toString() {
		String STR="Type: Debited\n";
		 STR+="Amount: " + amount + "$\n";
		 STR+="Account Number: "+ person.getAcc().get(acc).getData().getAcc_num()+ "\n";
		 return STR;

	}

	public String displayFile() {
		String STR="Debited" + " , "+ person.getClient_num() + " , " + amount + " , " + acc;
		return STR;
	}

}
