import java.util.*;
import java.util.regex.PatternSyntaxException;

public class LIS {

	static int max(int[] arr)
	{
		int max = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > arr[max])
				max = i;
		return max;
	}

	static void fill(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i]=1;
	}
	
	static void initialize(Object[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i]=new ArrayList<Integer>(arr.length);
	}

	static void getLIS(int[] arr) {
		int[] key=new int[arr.length];
		List<Integer>[] lsl=new List[arr.length];
		int val;
		fill(key);
		initialize(lsl);
		
		for (int i = 0; i < arr.length; i++)
			lsl[i].add(arr[i]);

		for (int i = 1; i < arr.length; i++) {
			for(int j=0;j<i;j++) {
				val=key[j]+1;
				if(arr[i]>arr[j] && key[i]<val) {
					key[i]=(val);
					Collections.copy(lsl[i],lsl[j]);
					lsl[i].add(arr[i]);
				}
			}
		}

		System.out.println("LIS = " + key[max(key)]);
		System.out.println("LSL is "+lsl[max(key)]);

	}

	static void run() {
		int[] arr;
		do {
			arr=input();

		}while(arr==null);

		getLIS(arr);
	}
	
	static int[] input() {
		Scanner scan=new Scanner(System.in);
		String input;

		try {
			
			input=scan.nextLine();
			String[] splitt=input.split(" ");

			int[] arr=new int[splitt.length];
			for(int i=0;i<splitt.length;i++)
				arr[i]=Integer.parseInt(splitt[i]);
			return arr;
			
		}catch(NumberFormatException E) {
			System.out.println("Wrong input format");
			return null;
		}catch(PatternSyntaxException E) {
			System.out.println("Wrong input format");
			return null;
		}catch(ArrayIndexOutOfBoundsException E) {
			System.out.println("Wrong input format");
			return null;
		}
	}

	public static void main(String[] args) {
		//10 22 9 33 21 50 41 60
		//10 22 9 33 21 50 41 60 80
		//		getLIS(arr);
		run();
	}
}