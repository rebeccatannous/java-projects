package assignment1;

public class Faculty extends Employee {

	private final  double BONUS;
	private int teachingload;



	public Faculty(String Ename ,String Erecruitment_date,  double Esalary, int t) {
		//constructor 
		super( Ename , Erecruitment_date,  Esalary);
		BONUS= salary*0.02;
		teachingload=t;
	}



	public void raise (double percent) {
		// raises employee's salary by a certain percentage
		salary+= (salary* (percent/100.0)) ; 
	}



	public void addBonus () {
		// adds a fixed bonus to the salary
		salary+=BONUS ; 
	}



	// getters and setters
	public double getBonus() {
		return BONUS;
	}

	public int getTeachingload() {
		return teachingload;
	}
	public void setTeachingload(int teachingload) {
		this.teachingload = teachingload;
	}



	public String toString() {
		//override to String method
		String STR = super.toString();
		STR += " || Teaching Load: " + teachingload;
		return STR;
	}



	public boolean equals(Faculty F) {
		/* compares the two strings, checks if they are the same and if the
		   objects are both of type Faculty and returns true, false otherwise */
		return super.equals(F) && F instanceof Faculty;
	}


}
