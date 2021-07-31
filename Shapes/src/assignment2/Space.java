package assignment2;
import java.util.*;
/* Name: Rebecca Tannous
Date last modified: 19/2/2020
Project description: This program defines shapes of objects in space and store them in an array,deletes them, computes their
area and perimeter,displays them and reads and write in files and creates objects accordingly
Other files: Shape.java , Circle.java , Triangle.java, EqilateralTriangle.java, Square.java, */

import java.io.*;
public class Space{
	private  Shape[] space = new Shape[10];
	private int count = 0;
	Scanner scan = new Scanner(System.in);

	//adds shapes to the array
	public void add(Shape p) {
		if(count == space.length)
			increaseSize();

		space[count] = p;
		count++;
	}

	//ensures capacity of the array
	public void increaseSize() {
		Shape[] temp= new Shape[count*2+1];
		for (int i=0; i<space.length;i++)
			temp[i]=space[i];
		space=temp;		
	}

	//search for an element according to its x and y coordinates. Returns the index of the element if found,-1 otherwise
	public int find(int x,int y) {
		int index=-1;
		for(int i=0; i<count; i++)
			if (x==(space[i].getX()) && y==(space[i].getY()))

				index=i;

		return index;


	}

	//deletes element according to its x and y coordinates
	public int delete(int x,int y) {

		int index =-1; //index of the shape to delete
		for (int i = 0; i < count; i++) {
			if (x==(space[i].getX()) && y==(space[i].getY())) {
				index=i; //save the index when found
			}
		}

		if(index ==-1 ) { //shape  is not found
			System.out.println("\n Shape could not be found");
		}else {

			space[index]=space[count-1];
			space[count-1]=null;
			count--;
		}

		return index;
	}

	//method to handle Number Format Exception
	public static int chooseNum()
	{
		Scanner scan = new Scanner(System.in);	
		String a;
		try 
		{
			a = scan.next();
			int i = Integer.parseInt(a);
			return i;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter again");
			return chooseNum();
		}
	}

	//menu
	public void menu() {
		int choice = 0;
		int exit=1;
		//menu is displayed after every choice except 6 that sets exit to 0 and exits the menu
		while(exit!=0) {
			System.out.println("");
			System.out.println("1.	Add a shape");
			System.out.println("2.	Delete a shape");
			System.out.println("3.	Compute Area and Perimeter");
			System.out.println("4.	Display all");
			System.out.println("5.	Read from File");
			System.out.println("6.	Exit");
			System.out.println("--------------------");
			System.out.println("Enter choice");


			// prompts the user for a number
			choice = chooseNum();

			switch(choice) {
			case 1:	
				//adds shape to the array
				int D_choice=1;
				//menu is displayed after every choice except D that sets D_choice  to 0 and exits the menu
				while(D_choice!=0){
					System.out.println("");
					System.out.println("Which shape do you want to add?");
					System.out.println("A.	Add a Circle");
					System.out.println("B.	Add a Square");
					System.out.println("C.	Add a Triangle");
					System.out.println("D.	Return to main menu");
					System.out.println("- -- - - - - - - - - - - - -");

					//prompts the user for shape type then adds it to the array
					String add_choice=scan.next();
					if (add_choice.equalsIgnoreCase("A")) 
					{
						System.out.println("");
						System.out.println("Enter radius");
						int radius=chooseNum();
						while(radius<0 || radius==0) {
							System.out.println("A radius can't be negative or 0"); //make sure that measures are not negative or null
							System.out.println("Enter again");
							radius=chooseNum();
						}
						System.out.println("Enter x-coordinate");
						int c_x=chooseNum();
						System.out.println("Enter y-coordinate");
						int c_y=chooseNum();
						System.out.println("Enter color");
						String circle_color;
						try {
							circle_color=scan.next();
							Shape circle=new Circle(circle_color,c_x,c_y,radius);
							add(circle);
							System.out.println("Circle Added");
						}catch (InputMismatchException e) {
							System.out.println("You enetered an invalid value");

						}

					}


					else if (add_choice.equalsIgnoreCase("B")) {
						System.out.println("");
						System.out.println("Enter length of sides");
						int square_side=chooseNum();
						while(square_side<0 || square_side==0) {
							System.out.println("A side length can't be negative or 0");
							System.out.println("Enter again");

							square_side=chooseNum();
						}

						System.out.println("Enter x-coordinate");
						int s_x=chooseNum();
						System.out.println("Enter y-coordinate");
						int s_y=chooseNum();
						System.out.println("Enter color");
						String square_color;
						try {
							square_color=scan.next();
							Shape square=new Square(square_color,s_x,s_y,square_side);
							add(square);
							System.out.println("Square Added");
						}catch (InputMismatchException e) {
							System.out.println("You enetered an invalid value");
						}

					}


					else if (add_choice.equalsIgnoreCase("C")) {
						System.out.println("");
						System.out.println("Enter the length of the first side");
						int side1=chooseNum();
						while(side1<0 || side1==0) {
							System.out.println("A side length can't be negative or 0");
							System.out.println("Enter again");

							side1=chooseNum();
						}
						System.out.println("Enter the length of the second side");
						int side2=chooseNum();
						while(side2<0 || side2==0) {
							System.out.println("A side length can't be negative or 0");
							System.out.println("Enter again");

							side2=chooseNum();
						}
						System.out.println("Enter the length of the third side");
						int side3=chooseNum();
						while(side3<0 || side3==0) {
							System.out.println("A side length can't be third or 0");
							System.out.println("Enter again");
							side1=chooseNum();
						}
						System.out.println("Enter x-coordinate");
						int t_x=chooseNum();
						System.out.println("Enter y-coordinate");
						int t_y=chooseNum();
						System.out.println("Enter color");
						try{
							String triangle_color=scan.next();
							if (side1==side2 && side2==side3) {
								Shape etriangle =new EquilateralTriangle(triangle_color,t_x,t_y,side1,side2,side3);
								System.out.println("Equilateral triangle  Added");
								add(etriangle);

							}
							else {
								Shape triangle =new Triangle(triangle_color,t_x,t_y,side1,side2,side3);
								System.out.println("Triangle  Added");
								add(triangle);
							}
						}catch (InputMismatchException e) {
							System.out.println("You enetered an invalid value");
						}

					}
					else if (add_choice.equalsIgnoreCase("D")) {
						D_choice=0;
					}
					else
						System.out.println("Invalid Choice");
				}
				System.out.println("");

				break;	

			case 2:		
				//prompts the user for the x and y coordinates 
				System.out.println("Enter x-coordinate of the shapes you want to delete");
				int x_coo=chooseNum();
				System.out.println("Enter Y-coordinate of the shapes you want to delete");
				int y_coo=chooseNum();
				int found=delete(x_coo,y_coo);
				//deletes all the shapes in this location
				while(found>0)
				{
					found=delete(x_coo,y_coo);

				}
				System.out.println("");

				break;

			case 3:
				//displays the area and perimeter of all the elements at the location specified by the user
				System.out.println("Enter x-coordinate");
				int x_co=chooseNum();
				System.out.println("Enter Y-coordinate");
				int y_co=chooseNum();
				int find=0;
				for(int i=0; i<count;i++) {
					find=find(x_co,y_co);
					if (find>0) {
						System.out.println(" " + space[i].getShape() + " Perimeter: " + space[i].perimeter()+ " area:" + space[i].area() +"\n" );
					}else
						System.out.println("Shape not found");
				}
				System.out.println("");


				break;


			case 4:
				//displays all the elements in the array
				for(int i=0; i<count;i++) {
					System.out.println(space[i].getShape()+":"+ space[i]);
					System.out.println("");
				}
				System.out.println("");

				break;


			case 5:
				try {
					//reads from file
					//file directory to be modified
					FileReader fr = new FileReader("input.txt");
					BufferedReader br = new BufferedReader(fr);

					String s = null;

					while((s= br.readLine()) != null){
						try {
							String[] a = s.split(", ");
							String shape=a[0];
							String colour=a[1];	
							//only creates object of type Circle
							if (a[0].equalsIgnoreCase("Circle")){
								int xco=Integer.parseInt(a[2]);
								int yco=Integer.parseInt(a[3]);
								int rad=Integer.parseInt(a[4]);
								Shape S= new Circle(colour,xco,yco,rad);
								add(S);
							}
						}
						catch (NumberFormatException e) {
							continue;
						}
						catch(ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
					br.close();
				}
				catch (IOException e) {
					System.out.println("");

				}

				break;
			case 6:
				try {
					//writes in file
					FileWriter fw = new FileWriter("output.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for(int i = 0; i < count; i++)
					{
						if(space[i].getShape().equalsIgnoreCase("Circle")){
							bw.write("circle, "+ space[i].getColor()+", "+space[i].getX()+", "+ space[i].getY()+", "+((Circle)space[i]).getRadius() + "\n");
						}
						else if(space[i].getShape().equalsIgnoreCase("Square")){
							bw.write("square, "+ space[i].getColor()+", "+space[i].getX()+", "+ space[i].getY()+", "+((Square)space[i]).getSide()+ "\n");
						}
						else if(space[i].getShape().equalsIgnoreCase("triangle")){
							bw.write("triangle, "+ space[i].getColor()+", "+space[i].getX()+", "+ space[i].getY()+", "+((Triangle)space[i]).getSide1()+", "+((Triangle)space[i]).getSide2()+", "+((Triangle)space[i]).getSide3()+ "\n");
						}
						else{
							bw.write("equilateral triangle, "+ space[i].getColor()+", "+space[i].getX()+", "+ space[i].getY()+", "+((Triangle)space[i]).getSide1()+", "+((Triangle)space[i]).getSide2()+", "+((Triangle)space[i]).getSide3()+ "\n");
						}
					}
					bw.close();	
					fw.close();

				}
				catch(IOException e) {
					System.out.println();
				}
				//setting exit to 0 to exit the while lopp and end the program
				exit=0;
				System.out.println("");
				break;

			default:
				System.out.println("Invalid choice");


			}


		}
	}
	public static void main(String[] args) {
		Space c=new Space();
		c.menu();
		System.out.println("Program ended");
	}
}
