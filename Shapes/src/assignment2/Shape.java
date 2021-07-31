package assignment2;

public abstract class Shape {
	protected String color;
	protected int x;
	protected int y;
	protected String shape;

	//constructor
	public Shape(String color, int x , int y) {
		this.color=color;
		this.x=x;
		this.y=y;
	}

	//getters and setters
	public String getColor() {
		return color;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public String getShape() {
		return shape;
	}


	//abstract methods
	public abstract double area();
	public abstract double perimeter();
	public abstract String toString();

}
