package assignment1;

public class Employee {

	protected String name;
	protected String recruitment_date; 
	protected double salary;
	private static int size;

	

	public Employee (String Ename ,String Erecruitment_date,  double Esalary ) {
		//constructor 
		name=Ename;
		recruitment_date=Erecruitment_date; 
		salary=Esalary;
	}

	

	//getters and setters 
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}

	public String getRecruitment_date() {
		return recruitment_date;
	}
	public void setRecruitment_date(String recruitment_date) {
		this.recruitment_date = recruitment_date;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static int getSize() {
		return size;
	}
	public static void setSize(int size) {
		Employee.size = size;
	}
	
	
	
	
	public boolean equals(Employee E) {
		//compares the two strings, returns true if the strings are the same, false otherwise
		return E.getName().equals(name);
	}



	public String toString(){
		//override to String method
		String STR = "Name: " + name + " ||  " + "Date of recruitment: "  + recruitment_date + " || " + "Salary: " + salary;
		return STR;
	}
	
	

	/* increment and decrement the static variable size that 
	 keeps count of the number of employees currently at the university */
	public static void increment() {
		size++;
	}
	public static void decrement() {
		size--;
	}






}
