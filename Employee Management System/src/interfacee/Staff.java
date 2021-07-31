package interfacee;

public class Staff extends Employee implements Member {

	public Staff(String Ename, double Esalary) {
		super(Ename, Esalary);
	}

	
	public void raise(double percent) {
		salary+= (salary* (percent/100.0)) ; 			
	}

//override toString() method
	public String toString() {
		String STR = "Name: " + name + " || " + "Salary: " + salary;
		return STR;
	}

}
