package ass6;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class BNode {
	private Definition info;
	private BNode left;
	private BNode right;

	public BNode(Definition info) {
		this.info = info;
		left = null;
		right = null;
	}

	public Definition getInfo() {
		return info;
	}

	public void setInfo(Definition info) {
		this.info = info;
	}

	public BNode getLeft() {
		return left;
	}

	public void setLeft(BNode left) {
		this.left = left;
	}

	public BNode getRight() {
		return right;
	}

	public void setRight(BNode right) {
		this.right = right;
	}

	public void print() {
		System.out.println(info);
		if(getLeft()!=null)
			left.print();
		if(getRight()!=null)
			right.print();


	}

	public boolean Child() {
		if (getLeft()==null && getRight()!=null)
			return true;
		if (getLeft()!=null && getRight()==null)
			return true;
		return false;

	}

	public boolean hasChild() {
		if (getLeft()==null && getRight()!=null)
			return true;
		if (getLeft()!=null && getRight()==null)
			return true;
		if (getLeft()!=null && getRight()!=null)
			return true;
		return false;

	}

	public boolean rightChild() {
		if (getLeft()==null && getRight()!=null)
			return true;
		return false;
	}

	public boolean leftChild() {
		if (getLeft()!=null && getRight()==null)
			return true;
		return false;
	}

	public boolean Children() {
		if (getLeft()!=null && getRight()!=null)
			return true;

		return false;

	}

	public boolean leaf() {
		if(left==null && right==null)
			return true;
		return false;
	}



	public String toString() {
		return "BNode [info=" + info + "]";
	}


	



}
