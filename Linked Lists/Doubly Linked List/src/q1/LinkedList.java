package q1;

import java.util.Scanner;

public class LinkedList {

	private Node header;

	public LinkedList() {
		header=null;
	}
	//getter 
	public Node getHeader() {
		return header;
	}
	//setter
	public void setHeader(Node header) {
		this.header = header;
	}


	public void add(Object S) 
	{
		//adds element at the end of the list
		Node n=new Node(S);
		Node current=header;
		if (header==null)
			header=n;
		else {
			while(current.getNext()!=null)
				current=current.getNext();
			current.setNext(n);
		}
	}
	public void addReverse(Object S) 
	{
		//adds element to the beginning of the list
		Node n=new Node(S);
		if (header==null)
			header=n;
		else {
			n.setNext(header);
			header=n;
		}
	}


	public int size() {
		//returns the number of nodes in the list
		if (header==null)
			return 0;
		else {
			int count=1;
			Node current=header;
			while (current.getNext()!=null)
			{
				count++;
				current=current.getNext();
			}

			return count;
		}

	}

	
	public void display() {
		//displays the info of the nodes in the list
		Node current = header;  
		if(header==null) {  
			//empty list
			System.out.println();
			System.out.println("List is empty");  
			System.out.println();
		}  
		else {
			System.out.println("List:");  
			System.out.print(current.getInfo());  
			while(current.getNext() != null) {  			
				current = current.getNext();  
				System.out.print(" -> " + current.getInfo() );  
			}  
			System.out.println();
		}

	}


	public Node reverse() {
		/*returns a pointer to a new_list with  all
		the elements of initial_list reversed*/
		Node current=header;
		LinkedList new_list =new LinkedList();
		for (int j=0;j<size();j++) {
			new_list.addReverse(current.getInfo());
			current=current.getNext();
		}
		new_list.display();
		return new_list.getHeader();
	}


	public LinkedList odd() {
		//returns a new  list with elements  in initial_list at odd indices
		Node current=header;
		LinkedList odd_list =new LinkedList();
		for (int j=0;j<size();j++) {
			if (j%2==1)
				odd_list.add(current.getInfo());
			current=current.getNext();
		}
		odd_list.display();
		return odd_list;
	}

	public DoublyLinkedList DLL() {
		//returns a doubly linked list containing the same values as initial_list.
		Node current=header;
		DoublyLinkedList dll =new DoublyLinkedList();
		for (int j=0;j<size();j++) {
			dll.addDLL(current.getInfo());
			current=current.getNext();
		}
		dll.display();
		return dll;

	}

	public  int chooseNum()
	{
		//function to handle NumberFormatException
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

	public LinkedList makeList() {
		//prompts the user for the size and elements of a new list
		Scanner scan=new Scanner(System.in);
		LinkedList l=new LinkedList();
		System.out.println("Enter the size of your list");
		int size=chooseNum();
		//size cannot be 0 or negative to avoid exceptions
		while(size<1) {
			System.out.println("Choose a positive integer different than 0");
			size=chooseNum();
		}
		for (int i=0;i<size;i++) {
			System.out.println("Enter element " + i + " of your list");
			String s=scan.next();
			l.add(s);
		}
		return l;	
	}

	public boolean included(LinkedList l)
	{
		//checks if the list is included in initial_list
		//pointer to search the initial list
		Node current=header;
		//pointer to search the other list
		Node temp=l.getHeader();
		int equ=0;
		while(temp!=null) {
			while(current!=null)
			{
				//checks if the info of the two lists are equal, if yes it increments equal
				if (temp.getInfo().equals(current.getInfo())) {
					equ++;
					break;
				}

				current=current.getNext();

			}
			//checks for the next element of the second list
			temp=temp.getNext();
			//resets the pointer to go through the initial list again
			current=header;

		}
		if(equ==l.size()) {
			//if equ is equal to the second list's size then all its elements are included in the initial list
			System.out.println("Included");
			return true;
		}
		else {
			System.out.println("Not included");

			return false;
		}
	}

	public LinkedList removeDuplicate(LinkedList l1)
	{
		//returns and outputs a new list with duplicates in l1 removed
		//the new list
		LinkedList l2=new LinkedList();
		Node current=l1.getHeader();
		Node temp=current;
		int count=0;
		if (header==null) {
			System.out.println("Empty list");
			return null;
		}
		else {
			if(l1.size()==1) {
				//a list of 1 element has no duplicates, this element is added to the new list
				l2.add(l1.getHeader().getInfo());
				l2.display();
				return l2;
			}
			else {
				//outer loop to handle what element we're comparing
				while(temp!=null) {	
					//inner loop to go through the list
					while(current.getNext()!=null)
					{
						current=current.getNext();
						if (temp.getInfo().equals(current.getInfo())) {
							count++;
						}

					}
					//elements  with no duplicates after them are added
					if (count==0)
						l2.add(temp.getInfo());
					//resets count 
					count=0;
					//moves to next element to compare it
					temp=temp.getNext();
					//resets current to go through the elements after temp again
					current=temp;

				}
				//displays and returns the new list with duplicates removed 
				l2.display();
				return l2;
			}
		}
	}	
}












