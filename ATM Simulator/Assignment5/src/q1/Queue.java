package q1;

public class Queue {
	private int num_elements;
	private int rear,front;
	private Object[] store;
	
	
	public int getNum_elements() {
		return num_elements;
	}

	public void setNum_elements(int num_elements) {
		this.num_elements = num_elements;
	}

	public Queue(int ini_capacity ) {
		num_elements=0;
		front=0;
		rear=-1;
		store=new Object[ini_capacity];
	}

	public void ensureCapacity() {
		Object[] temp=new Object[store.length+1];
		for(int i=0;i<num_elements;i++) 
			temp[i]=store[i];

		store=temp;

	}

	public void enqueue(Object O) {	
		if(num_elements>1) 
			if(front>0 && rear==front-1) {
				copy();
			}
		if((rear==store.length-1) && (front==0))
			ensureCapacity();


		if (rear==store.length-1 && front!=0) {
			rear=-1;
		}	
		rear++;
		store[rear]=O;
		num_elements++;
	}


	public Object dequeue() {
		int deq;
		if (num_elements==0) {
			return null;
		}
		else {
			if(num_elements>1) {
				if(front>0 && rear==front-1) {
					copy();
				}
			}
			if(front==store.length-1) {
				if(rear==front)
					rear=-1;
				deq=front;
				store[front]=null;
				front=0;
				num_elements--;
				
			}else if(num_elements==1) {
				deq=front;
				store[front]=null;
				front++;
				num_elements--;

			}else {
				deq=front;
				store[front]=null;
				front++;
				num_elements--;
			}
			return store[deq];
		}
	}



	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public Object[] getStore() {
		return store;
	}

	public void setStore(Object[] store) {
		this.store = store;
	}

	public void display() {
		if(empty())
			System.out.println();
		else if(num_elements==1) {
			System.out.println(store[front]);
		}
		else if(rear>front) {
			for(int i=0;i<=store.length-1;i++) {
				if(store[i]!=null)
					System.out.print(store[i] + "\n");
			}
		}
		else if (rear<front) {
			for(int i=front;i<store.length;i++) {
				if(store[i]!=null)
					System.out.print(store[i] + "\n");
			}
			for(int i=0;i<=rear;i++) {
				if(store[i]!=null)
					System.out.print(store[i] + "\n");
			}
		}
	}

	public Object get(int i) {
		return store[i];
	}



	public void copy() {
		Object[] temp= new Object[num_elements];
		int index=front;
		int j=0;
		while(index!=store.length) {
			temp[j]=store[index];
			j++;
			index++;
		}

		for(int i=0;i<=rear;i++) {
			temp[j]=store[i];
			j++;
		}
		store=temp;
		front=0;
		rear=store.length-1;
	}


	public boolean empty() {
		if (num_elements==0)
			return true; 
		return false;
	}

	public Object peek() {
		return store[front];
	}




}
