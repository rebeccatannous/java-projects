package q2;

public class Main {
	public void menu() {
		DoublyLinkedListHeader list= new DoublyLinkedListHeader();


		int exit=1;
		//menu is displayed after every choice except 6 that sets exit to 0 and exits the menu
		while(exit!=0) {
			System.out.println("1.	Make list");
			System.out.println("2.	Insert");
			System.out.println("3.	Delete ");
			System.out.println("4.	Reverse");
			System.out.println("5.	Add");
			System.out.println("6.	Split");
			System.out.println("7.	Exit ");
			System.out.println("- - - - - -");
			System.out.println("Input your choice:");
			int choice=list.chooseNum();

			switch(choice) {
			case 1:
				list.add();
				break;
			case 2:
				list.emptyList();
				list.insert();
				break;

			case 3:
				list.emptyList();
				list.delete();
				break;
			case 4:
				list.emptyList();
				list.reverse();
				break;
			case 5:
				list.emptyList();
				System.out.println("Sum of elements is: " + list.sum());
				System.out.println();
				break;
			case 6:
				list.emptyList();
				list.split();
				break;
			case 7:
				System.out.println("Exiting the program");
				exit=0;
				break;
			default: 
				System.out.println("Invalid choice");

			}
		}
	}
	public static void main(String[] Args) {
		Main m =new Main();
		m.menu();
	}





}
