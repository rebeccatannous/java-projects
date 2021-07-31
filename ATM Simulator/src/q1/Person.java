package q1;

public class Person {
	private String name;
	private long client_num;
	private LinkedList Acc;

	public Person(String name, long client_num, LinkedList Acc) {
		this.name = name;
		this.client_num = client_num;
		this.Acc=Acc;
	}

	public int getAccount(long s) {
		int index=-1;
		for(int i=0;i<Acc.size();i++) {
			if(Acc.get(i).getData().getAcc_num()==s) {
				index=i;
			}

		}
		return index;
	}

	public String toString() {
		String STR="Name: "+ name+ "\n";
		STR+="Client Number=" + client_num + "\n";
		STR+="Accounts:\n" + Acc.display();

		return STR;
	}

	public String displayAcc() {
		String STR="";
		STR+="Accounts:\n" + Acc.display();
		return STR;
	}

	public String displayFile() {
		String STR="";
		STR+=Acc.displayFile();
		return STR;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getClient_num() {
		return client_num;
	}
	public void setClient_num(long client_num) {
		this.client_num = client_num;
	}
	public LinkedList getAcc() {
		return Acc;
	}
	public void setAcc(LinkedList acc) {
		Acc = acc;
	}

	public void add_Account(Account c) {
		Acc.add(c);
	}

	public void deposit(double money, int i) {
		Acc.get(i).getData().deposit(money);
	}
	public void depositQ(double money, int i) {
		Acc.get(i).getData().depositQ(money);
	}
	public void withdraw(double money, int i) {
		boolean f=Acc.get(i).getData().withdraw(money);
		if(f==false) {
			System.out.println("Withdrawal Declined");
		}
	}

	
	public void withdrawQ(double money, int i) {
		boolean f=Acc.get(i).getData().withdrawQ(money);
		
	}
	public void transfer(double money, int from,int to) {
		boolean f=Acc.get(from).getData().withdraw(money);
		if(f==true) 
			Acc.get(to).getData().deposit(money);
		else 
			System.out.println("Transfer Declined");


	}
	
	public void transferQ(double money, int from,int to) {
		boolean f=Acc.get(from).getData().withdrawQ(money);
		if(f==true) 
			Acc.get(to).getData().depositQ(money);
		


	}
}
