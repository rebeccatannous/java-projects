import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Bucket {

	public static int divide(int x) {
		return x/10;
	}

	static void swap(Vector<Integer> v,int i,int j) {
		int k= v.get(i);
		int y=v.get(j);
		v.set(i, y);
		v.set(j,k);
	}

	static void insertionSort(Vector<Integer> v) {
		/*could be the best sorting algorithm since the chances of
		 *having a nearly sorted array in each bucket are high O(n)
		 *
		 *(using other sorting algorithms is not always suitable:
		 *1. MergeSort is out of place and requires additional memory,
		 *an unnecessary tradeoff when I am already using several vectors in BucketSort.
		 *
		 *2. QuickSort has a worst case of O(n^2), same as insertionSort that is easier 
		 *to implement for vectors)*/
		
		int n = v.size();
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && v.get(j)< v.get(j-1); j--) {
				swap(v, j, j-1);
			
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void bucketSort(int arr[]) {	 
		//from 0 to 9
		Object[] Buckets=new Object[10];

		for(int i=0;i<Buckets.length;i++) {
			//fills the array with vectors
			Vector<Integer> vec =new Vector<Integer>();
			Buckets[i]=vec;
		}

		for(int i=0;i<arr.length;i++) {
			//divides the entries into buckets
			int d=divide(arr[i]);
			((Vector<Integer>) Buckets[d]).add(arr[i]);
		}

		for(int i=0;i<Buckets.length;i++) {
			//skips empty buckets and sorts the others
			if(!((Vector<Integer>) Buckets[i]).isEmpty()) {
				insertionSort((Vector<Integer>) Buckets[i]);
			}
		}

		int j=0;
		//fills the unsorted array with the sorted entries
		for(int i=0;i<Buckets.length;i++) {
			if(Buckets[i]!=null) {
				int size=((Vector<Integer>) Buckets[i]).size();
				for(int k=0;k<size;k++) {
					arr[j]=((Vector<Integer>) Buckets[i]).get(k);
					j++;
				}
			}
		}
	}

	static int enterInt(boolean length) {
		/*this method makes sure that the user enters a valid array
		 *length along with positive integers <100 in the array*/
		Scanner scan = new Scanner(System.in);
		try {
			int i;				
			i=scan.nextInt();	
			if(length) {
				//the user inputs the length
				//note that the length is a positive integer !=0
				while(i<=0) {
					System.out.println("Enter a positive integer different than 0");
					i=scan.nextInt();	
				}
				
			}else {
				//the user enters the elements of the array
				//note that the elements are positive integers <100
				while(i<0 || i>=100) {
					System.out.println("You can only enter positive integers less than 100");
					i=scan.nextInt();	
				}
			}
			return i;

		}catch(InputMismatchException e){
			//the user entered an invalid element
			System.out.println("Enter a positive integer");
			return enterInt(length);
		}
	}

	public static void print(int[] arr) {
		//prints the elements of the array
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void sort() {
		/*prompts the user for the length and elements of the array, sorts them
		 * using bucketSort() then prints the unsorted and sorted array*/

		System.out.println("Enter the length of your array");
		int n=enterInt(true);

		int[] arr=new int[n];

		System.out.println("Enter the elements of your array");

		int a=0;
		while(n!=a) {
			int j=enterInt(false);
			arr[a]=j;
			a++;
		}

		System.out.print("Unsorted array: ");
		print(arr);

		bucketSort(arr);

		System.out.print("Sorted array:   ");
		print(arr);
	}

	public static void main(String[] Args) {
		//		int[] q= {1,44,22,21,23,20,88,80};
		//		bucketSort(q);
		sort();
	}


}
