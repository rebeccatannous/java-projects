package q2;


public class DNode {

	private Object info;
	private DNode next;
	private DNode prev;

	public DNode(Object i) {
		info=i;
		prev=null;
		next=null;
	}
	
	//getters and setters
	public Object getInfo() {
		return info;
	}

	public void setInfo(Object i) {
		info = i;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode n) {
		next = n;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode n) {
		prev = n;
	}





}
