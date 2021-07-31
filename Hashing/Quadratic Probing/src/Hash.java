
public class Hash {
	private static int[] key;
	private static int  N;

	public Hash(int a) {
		//initialize array to empty
		N=a;
		key = new int[N];
		for(int i=0;i<N;i++) {
			key[i]=-1;
		}
	}

	public  int h(int x) {
		return  x % N;

	}

	public  void insert(int k) {
		int value=h(k);
		if(key[value]==-1) {
			key[value]=k;
		}else {
			for(int i=0;i<N;i++) {
				value=(value+i*i) % N;
				if(key[value]==-1) {
					key[value]=k;
					return;
					
				}
			}

		}
	}

	public  void print() {
		for (int i=0;i<key.length;i++)
			System.out.print(key[i] + " ");
	}
	
	public  boolean search(int k) {
		int value=h(k);
		if(key[value]==k)
			return true;
		
		else if(key[value]==-1)
			return false;
		else {
			for(int i=0;i<N;i++) {
				value=(value+i*i) % N;
				if(key[value]==k) {
					return true;				}
			}
			return false;
		}
	}

	public static void main(String[]Args) {
		
		Hash h=new Hash(11);
		h.insert(352);	
		h.insert(22);
		h.insert(44);
		h.insert(132);

		System.out.println(h.search(132));
		System.out.println(h.search(5));
		System.out.println(h.search(50));
		System.out.println(h.search(85));
		System.out.println(h.search(575));
		h.print();
	}
}
