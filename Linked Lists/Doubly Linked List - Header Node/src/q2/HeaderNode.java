package q2;

public class HeaderNode {
	private int count;
	private DNode first;
	private DNode last;


	public HeaderNode() {
		setCount(0);
		setFirst(null);
		setLast(null);

	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public DNode getFirst() {
		return first;
	}


	public void setFirst(DNode first) {
		this.first = first;
	}


	public DNode getLast() {
		return last;
	}


	public void setLast(DNode last) {
		this.last = last;
	}
}
