
public class Problem3 {

	private	int[][] femalesP = {
			{0, 2, 1}, 
			{1,2,0}, 
			{0, 1, 2}, 
	};

	private	int[][] malesP = {
			{2, 1, 0}, 
			{2, 1, 0}, 
			{1, 2, 0}, 
	};

	private	int[] females=new int[3];
	private	int[] males=new int[3];

	public void GaleShapley() {
		//initializes all men and women to single
		for(int i=0;i<females.length;i++) {
			females[i]=-1;
			males[i]=-1;
		}

		gale(0);
	}

	public int single() {
		//returns index of first single man and -1 if all men are married
		for(int i=0;i<males.length;i++) {
			if(males[i]==-1) {
				return i;

			}}
		return -1;
	}

	public boolean divorce(int female,int husband,int man) {
		int husbandrank=-1;
		int manrank=-1;

		for (int i=0;i<3;i++) {

			if(femalesP[female][i]==husband)
				husbandrank=i;
			if(femalesP[female][i]==man)
				manrank=i;

		}

		if(manrank<husbandrank) {
			return true;
		}else {
			return false;
		}
	} 


	public void gale(int rank) {
		int m=single(); //index of first single man

		if(m==-1)
			return;

		int f=malesP[m][rank]; //index of potential wife

		if(females[f]==-1) {
			females[f]=m;
			males[m]=f;
			gale(0);
		} else {
			
			int husband=females[f]; //index of competitor
			
			if(divorce(f,husband,m))
			{
				females[f]=m;
				males[m]=f;
				males[husband]=-1;
				gale(0);
			}
			else {
				if(rank==3)
					rank=0;
				else
					rank++;

				gale(rank);
			}
		}

	}

	public void couples() {
		for(int i=0;i<3;i++) {
			System.out.print("Man "+i + " Woman " +males[i]);	
			System.out.println();
		}

	}


	public static void main(String[] Args) {
		Problem3 p=new Problem3();
		p.GaleShapley();
		p.couples();

	}
}