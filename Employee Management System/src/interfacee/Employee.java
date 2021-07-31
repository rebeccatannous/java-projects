package interfacee;


public abstract class Employee{
	protected String name;
	protected double salary;
	
	public Employee (String Ename , double Esalary ) {
		//constructor 
		name=Ename;
		salary=Esalary;
	}
	
	//getters and setters 
		public String getName() {
			return name;
		}	
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		//Override method equals()
		public boolean equals(Object obj) {
			try {
				if(((Employee)obj).getName().equals(this.name))
					return true;
				else
					return false;
			}catch(ClassCastException e) {
				return false;
			}
			
		}
		
	public abstract String toString();	
}
