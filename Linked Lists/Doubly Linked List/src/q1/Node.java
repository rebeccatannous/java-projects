package q1;

public class Node {


		private Object info;
		private Node next;

		public Node(Object i) {
			info=i;
			next=null;
		}
		
		public Object getInfo() {
			return info;
		}

		public void setInfo(Object i) {
			info = i;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node n) {
			next = n;
		}
	}