package assignment2;

public class Circle extends Shape {
	private int radius;

	public Circle(String color, int x, int y , int radius) {
		//constructor
		super(color, x, y);
		shape="Circle";
		this.radius=radius;
	}

	//getter and setter
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	//method to compute area
	public double area() {	
		double area=(Math.PI * (radius*radius));
		return area;
	}

	//method to compute perimeter
	public double perimeter() {
		double perimeter=(2*(Math.PI)*radius);
		return perimeter;
	}

	//Override method toString
	public String toString() {
		String STR="\n| radius: " + radius;
		STR+="\n| color: " + color;
		STR+="\n| x-coordinate: " + x ;
		STR+="\n| y-coordinate: " + y ;
		STR+="\n| area: " + area() ;
		STR+="\n| perimeter: " + perimeter() ;
		return STR;

	}

}
