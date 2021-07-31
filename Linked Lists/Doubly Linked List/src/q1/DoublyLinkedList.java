package q1;

public class DoublyLinkedList {
	
	private DNode header;
		
	//getter and setter
	public DoublyLinkedList() {
		header= null;
	}

	public DNode getHeader() {
		return header;
	}

	
	public void addDLL(Object O) {
		//adds elements to the end of the doubly linked list
		DNode n=new DNode(O);
		if (header==null)
			header=n;
		else {
			DNode current=header;
			while(current.getNext()!=null)
				current=current.getNext();
			current.setNext(n);
			n.setPrev(current);
		}
	}
	
	public void display() {
		//displays elements of the list seperated by <=>
		DNode current = header;  
		if(header==null) { 
			//list is empty
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

}
