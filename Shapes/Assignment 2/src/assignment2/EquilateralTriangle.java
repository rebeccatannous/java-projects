package assignment2;

public class EquilateralTriangle extends Triangle {

	//constructor
	public EquilateralTriangle(String color, int x, int y,int side1, int side2, int side3) {
		super(color, x, y, side1, side2, side3);
		side1=side2;
		side3=side2;
		shape="Equilateral Triangle";
	}

	//compute area
	public double area() {
		double a=((side1+side2+side3)/2);
		return (Math.sqrt(a*(a-side2)*(a-side2)*(a-side3)));
	}

	//compute perimeter
	public double perimeter() {	
		return super.perimeter();
	}

	//Override method toString
	public String toString() {
		String STR= "\n| length of the 3 sides: " + side1 + "";
		STR+="\n| color: " + color;
		STR+="\n| x-coordinate: " + x ;
		STR+="\n| y-coordinate: " + y ;
		STR+="\n| area: " + area() ;
		STR+="\n| perimeter: " + perimeter() ;		
		return STR;
	}

	//move shape
	public void move(int x2,int y2) {
		super.move(x2, y2);
	}
}
