package q2;
import java.util.*;
public class DoublyLinkedListHeader {

	private HeaderNode header;
	//this int is to check if a list has been added
	int adder=0;
	
	public DoublyLinkedListHeader() {
		header= new HeaderNode();
	}

	public HeaderNode getHeader() {
		return header;
	}

	public int size() {
		//returns the number of nodes on the list
		if (header==null)
			return 0;
		else {
			int count=1;
			DNode current= header.getFirst();
			while (current.getNext()!=null){
				count++;
				current=current.getNext();
			}
			return count;
		}
	}
	
	public void add()
	{
	//adds DNodes to the end of the list
		Scanner scan =new Scanner (System.in);
		String choice="y";
		if (adder!=0) {
			int repeat=newlist();
			if (repeat==1)
				return;
		}
		do{
			System.out.println("Enter Element");
			Integer S =chooseNum();

			DNode n= new DNode(S);
			if (header.getFirst()==null) {
				header.setFirst(n);	
				header.setLast(n);
				header.setCount((header.getCount())+1);
				adder++;
			}
			else {
				n.setPrev(header.getLast());
				header.getLast().setNext(n);
				header.setLast(n);
				header.setCount((header.getCount())+1);
				adder++;
			}
			int	exit=1;
			while(exit!=0) {
				System.out.println("1. Add another element");
				System.out.println("2. Done");
				int z=chooseNum();
				switch(z) {
				case 1:
					exit=0;
					choice="y";
					break;
				case 2:
					exit=0;
					choice="n";
					break;
				default:
					System.out.println("Invalid input");
				}
			}
		}while(choice.equalsIgnoreCase("y"));
		display();
		System.out.println();
	}

	public void addObj(Object O)
	{
		//adds a specific object to the end of the list
		DNode n= new DNode(O);
		if (header.getFirst()==null) {
			header.setFirst(n);	
			header.setLast(n);
			header.setCount((header.getCount())+1);
			adder++;

		}
		else {
			n.setPrev(header.getLast());
			header.getLast().setNext(n);
			header.setLast(n);
			header.setCount((header.getCount())+1);
			adder++;
		}
	}

	public void delete() {
		/*deletes node at index i, returns a pointer to the deleted node,
		 * null if i is an invalid index*/
		System.out.println("What is the index of the element you want to delete?");
		int i=chooseNum();
		DNode current=header.getFirst();

		if ((i<0)||(i>size()-1))
			System.out.println("Invalid index");
		else {
			if(header==null) {
				System.out.println("List is empty");
			}
			else {
				if(i==0)
				{
					if (size()==1) {
						header.setLast(null);
						header.setFirst(null);
						header.setCount((header.getCount())-1);
						adder--;
						System.out.println("Element deleted");	
						display();
					}
					else {
						header.setFirst((header.getFirst()).getNext());
						current.setNext(null);
						(header.getFirst()).setPrev(null);
						header.setCount((header.getCount())-1);
						adder--;
						System.out.println("Element deleted");	
						display();
					}

				}


				else {
					/*deletes a node different than the 1st in the list*/
					for(int j=0;j<i;j++)
						current=current.getNext();
					(current.getPrev()).setNext(current.getNext());

					if (current.getNext()!=null) {
						current.getNext().setPrev(current.getPrev());
						current.setNext(null);	
					}
					else {
						header.setLast(current.getPrev());
					}
					current.setPrev(null);
					header.setCount((header.getCount())-1);
					adder--;
					System.out.println("Element deleted");	
					display();

				}

			}
		}
	}

	public void display() {
		//displays nodes in the list
		DNode current = header.getFirst();  
		if(header.getFirst()==null) {  
			System.out.println();
			System.out.println("List is empty");  
			System.out.println();
		}  
		else {
			System.out.println("List:");  
			System.out.print(current.getInfo());  
			while(current.getNext() != null) {  			
				current = current.getNext();  
				System.out.print(" <=> " + current.getInfo() );  
			}  
			System.out.println();
		}

	}

	public void emptyList() {
		//checks if the list is empty, if it is empty the user is asked to enter elements of the list
		if (adder==0) {
			System.out.println("Enter a new list first");
			System.out.println("New list:");
			add();
		}
	}

	public void reverse() { 
		//reverses the elements of the list
		DNode temp = null; 
		DNode current = header.getFirst(); 
		header.setLast(header.getFirst());
		while (current != null) { 
			temp = current.getPrev(); 
			current.setPrev(current.getNext()); 
			current.setNext(temp); 
			current = current.getPrev(); 
		} 
		if (temp != null) { 
			header.setFirst(temp.getPrev()); 
		} 
		System.out.print("Reversed ");
		display();
		System.out.println("");
	}

	public int sum() {
		//adds the elements of the list
		int SUM=0;
		DNode current = header.getFirst();  
		if (header==null)
			return 0;
		else {
			while(current !=null) {
				SUM+=((Integer) current.getInfo()).intValue();
				current = current.getNext();  

			}
			return SUM;
		}
	}

	public HeaderNode[] split() {
		/*splits the list and returns an array of pointer to two new lists
		one with nodes from 0 to i-1 another from i to size()-1*/
		System.out.println();
		System.out.println("At which index do you want to split your list?");
		int i=chooseNum();
		if (i<0 || i>size()|| i==0 || i==size()) {
			System.out.println("Invalid index");
			return null;
		}
		else if(adder==0) {
			//list has not been added yet
			System.out.println("Cannot split an empty list");
			return null;
		}
		
		else {
			DNode current=header.getFirst();
			DoublyLinkedListHeader l1= new DoublyLinkedListHeader();
			for (int j=0;j<i;j++) {
				l1.addObj(current.getInfo());
				current=current.getNext();
				l1.getHeader().setCount((l1.getHeader().getCount())+1);
			}
			DoublyLinkedListHeader l2= new DoublyLinkedListHeader();
			while(current!=null) {
				l2.addObj(current.getInfo());
				current=current.getNext();
				l1.getHeader().setCount((l1.getHeader().getCount())+1);
			}

			HeaderNode[] pointer= new HeaderNode [2];
			pointer[0]=l1.getHeader();
			pointer[1]=l2.getHeader();
			System.out.println("");
			System.out.print("First ");
			l1.display();
			System.out.print("Second ");
			l2.display();
			System.out.println();
			return pointer;
		}


	}

	public boolean insert() {
		//inserts element at specific index
		Scanner scan =new Scanner(System.in);
		System.out.println("What integer do you want to insert?");
		int O=chooseNum();
		System.out.println("At what index do you want to insert?");
		int i=chooseNum();
		DNode node=new DNode(O);
		if ((i<0) || (i>size())) {
			System.out.println("Invalid Index");
			return false;
		} else {
			if(i==0) {
				//next of the node points to what header is pointing to
				node.setNext(header.getFirst());
				header.getFirst().setPrev(node);
				//header points to the node
				header.setFirst(node);
				header.setCount((header.getCount())+1);
				adder++;
				System.out.println("Integer Inserted");
				display();
				return true;
			}
			else if(i==size()) {
				header.getLast().setNext(node);
				node.setPrev(header.getLast());
				header.setLast(node);
				header.setCount((header.getCount())+1);
				adder++;
				System.out.println("Integer Inserted");
				display();
				return true;
			}
			else {
				DNode current=header.getFirst();
				for(int j=0;j<i-1;j++)
					current=current.getNext();
				node.setNext(current.getNext());
				node.setPrev(current);
				current.setNext(node);
				current.getNext().getNext().setPrev(node);
				node.getNext().setPrev(node);
				header.setCount((header.getCount())+1);
				adder++;
				System.out.println("Integer Inserted");
				display();
				return true;
			}
		}

	}

	public int newlist() {
		//replaces the old list, adds elements to it, or cancels the operation
		System.out.println("You already made a list");
		display();
		System.out.println("1. Replace the old list");
		System.out.println("2. Add new element to old list");
		System.out.println("3. Cancel");
		int w=0;
		int s=chooseNum();
		switch (s) {
		case 1:
			header.setFirst(null);
			header.setLast(null);
			w=0;
			adder=0;
			header.setCount(0);
			break;
		case 2:
			adder=0;
			w=0;
			break;
		case 3:
			w=1;
			break;
		default:
			System.out.println("Invalid");
		}
		return w;
	}

	public  int chooseNum()
	{
		//checks for NumberFormatException
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


}