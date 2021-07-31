package q1;


public class LinkedList{
	private Node header;

	public LinkedList()
	{
		header = null;
	}

	public Node getHeader() {
		return header;
	}
	public void setHeader(Node header) {
		this.header = header;
	}

	public String displayFile() {
		//displays the info of the nodes in the list
		String STR="";
		Node current = header;  
		if(header==null) {  
			STR="\n";
		}  
		else {
			STR=current.getData().displayFile();
			while(current.getNext() != null) {  			
				current = current.getNext();  
				STR+=" , " + current.getData().displayFile();  
			}  
		}
		return STR;

	}
	public Node get(int index)
	{	
		Node current = header;
		for (int i=0; i<index; i++)
		{
			current=current.getNext();
		}
		return current;
	}

	public int size()
	{	// Returns the size of the list:
		Node current = header;
		int size =0;
		if(header==null)
		{
			return 0;
		}
		else
		{
			size=1;
			while(current.getNext() != null)
			{
				size++;
				current=current.getNext();
			}
			return size;
		}
	}

		public void add (Account A)
	{//adds an element to the end of the List

		Node node = new Node (A);

		if (header == null)
			header = node;
		else {
			Node last_node = get(size()-1);
			last_node.setNext(node);
		}

	}
	
	public String display() {
		//displays the info of the nodes in the list
		Node current = header;
		String STR="";
		if(header==null) {  
			//empty list
			STR="List is empty";  

		}  
		else {  
			while(current!= null) {  			

				STR+=current.getData() +"\n"; 
				current = current.getNext();  
			}  
			System.out.println();
		}
		return STR;
}
}