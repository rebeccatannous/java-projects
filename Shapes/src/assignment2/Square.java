package assignment2;

public class Square extends Shape {
	private int side;

	//constructor
	public Square(String color, int x, int y, int side) {
		super(color, x, y );
		shape="Square";
		this.setSide(side);
	}

	//getter and setter
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}


	//compute perimeter
	public double perimeter() {
		return (4*side);
	}

	//compute area
	public double area() {
		return (side*side);
	}

	//method to move shape
	public void move(int x2,int y2) {
		setX(x2);
		setY(y2);
	}

	//override method toString
	public String toString() {
		String STR="\n| length of the sides: " + side;
		STR+="\n| color: " + color;
		STR+="\n| x-coordinate: " + x ;
		STR+="\n| y-coordinate: " + y ;
		STR+="\n| area: " + area() ;
		STR+="\n| perimeter: " + perimeter() ;

		return STR;

	}

}
