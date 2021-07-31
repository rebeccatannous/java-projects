package assignment1;

public class Staff extends Employee {

	
	
	public Staff(String Ename ,String Erecruitment_date,  double Esalary) {
		//constructor 
		super( Ename , Erecruitment_date,  Esalary);
	}

	
	
	
	public String toString() {
		//override to String method
		String STR = super.toString();
		return STR;
	}


	
	public void raise (double percent) {
		// raises employee's salary by a certain percentage
		salary+= salary* (percent/100.0); 
	}

	
	
	
	public boolean equals(Staff S) {
		/* compares the two strings, checks if they are the same and if the
		   objects are both of type Staff and returns true, false otherwise */
		return super.equals(S) && S instanceof Staff;
	}

}


