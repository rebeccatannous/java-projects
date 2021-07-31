package q1;

public class Node {

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	private Account data;
	private Node next;
	
	public Node(Account data)
	{
		this.data = data;
		this.next = null;
	}
	
	public Node(Account data, Node next)
	 	{
	      this.data = data;
	      this.next = next;
	   }
	
	//Getters and Setters:
	public Account getData() {
		return data;
	}
	public void setData(Account data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}