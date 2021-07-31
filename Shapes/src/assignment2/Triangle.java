package assignment2;

public class Triangle extends Shape {
	protected int side1;
	protected int side2;
	protected int side3;

	//constructor
	public Triangle(String color, int x, int y ,int side1, int side2, int side3 ) {
		super(color, x, y);
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);
		shape="Triangle";
	}

	//getters and setters
	public int getSide1() {
		return side1;
	}

	public void setSide1(int side1) {
		this.side1 = side1;
	}

	public int getSide2() {
		return side2;
	}

	public void setSide2(int side2) {
		this.side2 = side2;
	}

	public int getSide3() {
		return side3;
	}

	public void setSide3(int side3) {
		this.side3 = side3;
	}

	//compute area
	public double area() {
		double a=((side1+side2+side3)/2);
		return (Math.sqrt(a*(a-side2)*(a-side2)*(a-side3)));
	}

	//compute perimeter
	public double perimeter() {
		return (side1+side2+side3);
	}

	//override method toString
	public String toString() {
		String STR="\n| length of the sides: " + side1 + " "+ side2 +" "+side3;
		STR+="\n| color: " + color;
		STR+="\n| x-coordinate: " + x ;
		STR+="\n| y-coordinate: " + y ;
		STR+="\n| area: " + area() ;
		STR+="\n| perimeter: " + perimeter() ;		
		return STR;
	}


//move shape
	public void move(int x2,int y2) {
		setX(x2);
		setY(y2);
	}



}
