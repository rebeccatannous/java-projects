package interfacee;

public class Executive extends Employee implements Member,FullTime{

	private boolean vacation;
	
	public Executive(String Ename,double Esalary, boolean vacation) {
		super(Ename, Esalary);
		this.vacation=vacation;
	}

	public boolean getVacation(){
		return vacation;
	}
	
	public void holdMeeting(int hour) {
	System.out.println("Meeting will be held at "+ hour +":00 PM");
		
	}

	public void vacation() {
		if (vacation==false) {
		System.out.println("This employee will go on vacation");
		vacation=true;
		}
		else
			System.out.println("This employee already took a vacation");
		}

	public void addBonus() {
		salary+=BONUS ; 
	}

	public void raise(double percent) {
		salary+= (salary* (percent/100.0)) ; 		
	}

	//override method toString()
	public String toString() {
		String STR = "Name: " + name + " ||  " + "Took vacation: "  + vacation + " || " + "Salary: " + salary;
		return STR;
	}


}
