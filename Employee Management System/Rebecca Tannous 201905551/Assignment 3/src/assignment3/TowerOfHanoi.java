package assignment3;

import java.util.Scanner;

public class TowerOfHanoi {

	
	/********************Question 1**********************************/	
   /*a) Iteratively*************************************************/
  /****************************************************************/	

	//number of moves
	public static int numberOfMoves(int n) {
		int moves=(int) ((Math.pow(2, n))-1);
		return moves;
	}

	public static void move(int n, int s,int m , int e) {
		if(n%2==0) {
			//swap end peg and middle peg  if the number of disks is even
			int x=m;
			m=e;
			e=x;
		}

		//calculates the number of moves		
		int moves=numberOfMoves(n);

		//keeps in moving disks until number of moves is 0
		while(moves!=0) {
			if(moves!=0) {
				//method from the recursive version 
				moveOneDisk(s,e);
				moves--;
			}
			if(moves!=0) {
				moveOneDisk(s,m);
				moves--;
			}
			if(moves!=0) {
				moveOneDisk(e,m);
				moves--;
			}
		} 
		//tried implementing the method but it does not output the right answer
	}  

	
	
	/********************************************************************/	
   /*b) Recursively*****************************************************/
  /********************************************************************/		

	static void moveOneDisk(int i,int j) {
		System.out.println("Move one disk from "+i+" to "+j);
	}

	static void moveTower(int n, int s,int m , int e) {
		//n=3, 2ms
		//n=5, 3ms	
		//n=10, 114ms
		//for 100 disks and more the operation will take more than 7,200,000 ms since the number of moves is calculated by 2^n - 1
		// n being the number of disks in other words more than 1023 moves for 100 disks and above
		// Such number of moves will take a huge amount of time

		if(n==1)
			moveOneDisk(s,e);
		else {
			moveTower(n-1,s,e,m);
			moveOneDisk(s,e);
			moveTower(n-1,m,s,e);
		}

	}



	public static void main(String[] Args) {
		Scanner scan = new Scanner (System.in);
		long start = System.currentTimeMillis();
		moveTower(2,1,2,3);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
		System.out.println("How many disks?");
		int disks=scan.nextInt();
		move(disks, 1,2,3);
	}
}


