package ass6;
/* Name: Rebecca Tannous
Date last modified: 5/6/2020

Other files: BNode.java , Definition.java , BST.java , a.txt */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class BST {
	private BNode root;
	String STR=" ";
	String ST="";
	public BST() {
		setRoot(null);
	}

	public  void setSTR() {
		STR=" ";
	}

	public BNode getRoot() {
		return root;
	}


	public void setRoot(BNode r) {
		root = r;
	}


	public void inOrderPrint(BNode r) {
		if (r!=null) {
			if(r.getLeft()!=null)
				inOrderPrint(r.getLeft());
			System.out.println(r.getInfo() + "\n");
			if(r.getRight()!=null)
				inOrderPrint(r.getRight());
		}
	}
	public void inOrderPrint() {
		inOrderPrint(root);
	}

	


	public BNode add(Definition d,BNode r) {
		BNode n=new BNode(d);
		if (r==null) {
			//empty tree
			root=new BNode(d);
			return n;
		}
		else if (r.getInfo().getWord().equalsIgnoreCase(d.getWord())) {
			if (r.getInfo().getDescription().equalsIgnoreCase(d.getDescription()))
				return null;
			else {
				if(r.getLeft()==null) {
					r.setLeft(n);
					return n;
				}
				else
					return add(d,r.getLeft());

			}
		}
		else if(r.getInfo().getWord().toLowerCase().compareTo(d.getWord().toLowerCase())<0) {
			if(r.getRight()==null) {
				r.setRight(n);
				return n;
			}
			else
				return add(d,r.getRight());
		}
		else { 
			if(r.getLeft()==null) {
				r.setLeft(n);
				return n;
			}
			else
				return add(d,r.getLeft());
		}
	}

	public void add(Definition n) {
		add(n,root);
	}


	//tried to put STR in the parameters but it did not work
	//STR is declared as public
	public String WriteFile(BNode r) {
		//returns a string to update the text file with elements of the tree
		if (r!=null) {


			WriteFile(r.getLeft());

			STR+=r.getInfo().toString() + "\n";

			WriteFile(r.getRight());
		}
		return STR;
	}

	public String WriteFile() {
		return WriteFile(root);

	}

	public BNode getLeftMostData(BNode n) {
		//minimum
		if(n.getLeft()==null)
			return n;
		else {
			BNode temp=n.getLeft();
			while(temp.getLeft()!=null)
				temp=temp.getLeft();
			return temp;
		}
	}

	public void delete(BNode n) {
		if(n!=null) {
			if(n.leaf()) {

				if(n==root) {
					//node to delete is the root
					n=null;
					root=null;
				}
				else {
					if(getParent(n).getRight() == n) {
						//leaf is a right child
						getParent(n).setRight(null);
						n=null;
					}
					else {
						//leaf is a left child
						getParent(n).setLeft(null);
						n=null;
					}
				}
			}
			else if(n.Child()) {
				if(n==root) {
					//deleting the root with one child
					if (n.rightChild())
					{
						root=root.getRight();
						n.setRight(null);
					}
					else
					{
						root=root.getLeft();
						n.setLeft(null);
					}
				}
				else
				{
					if (n.rightChild())
					{
						//make the parent of n point to its child
						if(getParent(n).getRight()==n){
							(getParent(n)).setRight(n.getRight());
							n.setRight(null);
						}
						else {
							(getParent(n)).setLeft(n.getRight());
							n.setRight(null);	
						}
					}
					else if((n.leftChild()))
					{
						if(getParent(n).getRight()==n){

							(getParent(n)).setRight(n.getLeft());
							n.setLeft(null);
						}else {
							(getParent(n)).setLeft(n.getLeft());
							n.setLeft(null);
						}
					}
				}
			}
			else if(n.Children()) {
				//node has two children
				//replace it with its inorder successor (left most data to the right of the node
				n.setInfo(getLeftMostData(n.getRight()).getInfo());
				delete(getLeftMostData(n.getRight()));

			}
		}
	}


	public void search(String S,BNode r, int i) {
		//displays the word and all its homonyms 
		if(r==null) {
			if(i==0)
				System.out.println("Word was not found in the Dictionary");
			return;
		}

		if(r.getInfo().getWord().equalsIgnoreCase(S)) {
			i++;
			System.out.println(i+ "- "+ r.getInfo());
		}

		if(r.getInfo().getWord().toLowerCase().compareTo(S.toLowerCase())<0)
			search(S,r.getRight(),i);
		else 
			search(S,r.getLeft(),i); 

	}

	public void deleteAll(String S) {
		while(find(S)!=null) {
			delete(find(S));
		}

	}
	public int getSize(BNode root) {
		if(root==null)
			return 0;
		else
			return getSize(root.getLeft()) + getSize(root.getRight());
	}


	public int homonyms (String S,BNode r, int i) {
		//returns how many homonyms are present in the tree
		//will be used in the menu for deleting
		if(r==null) {
			if(i==0)
				return 0;
			else
				return i;

		}

		if(r.getInfo().getWord().equalsIgnoreCase(S)) {
			i++;
		}

		if(r.getInfo().getWord().toLowerCase().compareTo(S.toLowerCase())<0)
			return	homonyms(S,r.getRight(),i);
		else 
			return homonyms(S,r.getLeft(),i); 
	}

	public int homonyms (String S) {
		return 	 homonyms (S,root,0);
	}

	public void search(String S) {
		search(S,root,0);
	}


	public BNode getParent(BNode target, BNode parent,BNode current) 
	{ 
		//takes as argument three pointers, the first is used as a reference
		//if the second pointer is equal to the first than the third that precedes it must be the parent
		if(current==null) {
			//end of the tree, node not found
			return null;
		}
		if (current.getInfo().same(target.getInfo())  )  
			return parent;

		//target and current are homonyms
		if(target.getInfo().getWord().toLowerCase().compareTo(current.getInfo().getWord().toLowerCase())==0 && current.getInfo().same(target.getInfo())==false)
			//all nodes with equal definitions are to the left of the original
			return getParent( target, current,current.getLeft()); 

		else if(target.getInfo().getWord().toLowerCase().compareTo(current.getInfo().getWord().toLowerCase())<0)
			//current is lexicographically bigger than target, then it must be to its right
			return getParent( target, current,current.getLeft()); 
		else
			//to the left
			return	getParent(target, current,current.getRight()); 


	} 

	public BNode getParent(BNode D) {
		return getParent(D,root,root);
	}



	public BNode find(String S,BNode r, int i) {
		//end of the tree
		if(r==null) {
			//word is not found
			if(i==0)
				return null;
		}
		if(r.getInfo().getWord().equalsIgnoreCase(S)) {
			i++;
			return r;
		}

		if(r.getInfo().getWord().toLowerCase().compareTo(S.toLowerCase())<0)
			return find(S,r.getRight(),i);
		else {
			return find(S,r.getLeft(),i);
		}
	}

	public BNode find(String S) {
		return find(S,root,0) ;
	}




}
