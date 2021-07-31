package q1;

public class Credited extends Transaction{
private int acc;
	public Credited(Person person, double amount) {
		super(person, amount);
	}
	public Credited(Person person, double amount, int acc) {
		super(person, amount);
		this.acc=acc;
	}
	public void makeTrans(double money, int a) {

		person.deposit(money, a);



	}
	public void makeTransQ(double money, int a) {

		person.depositQ(money, a);



	}

	
	public int getAcc() {
		return acc;
	}

	
	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	//for file format
	public String displayFile() {
		String STR="Credited" + " , "+ person.getClient_num() + " , " + amount + " , " + acc;
		return STR;
	}
	
	public String toString() {
		String STR="Type: Credited\n";
		 STR+="Amount: " + amount + "$\n";
		 STR+="Account Number: "+ person.getAcc().get(acc).getData().getAcc_num()+ "\n";
		 return STR;

	}
}
