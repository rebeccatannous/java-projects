import java.util.Stack;
import java.util.Vector;
/*Rebecca Tannous
 * ID:201905551*/



public class Assembly {
	Vector registers=new Vector();


	public static boolean isNumber(String s){
		try{
			int temp = Integer.parseInt(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public  void condition(String S) {
		String sign="";
		boolean eq=false;
		boolean ellse=false;
		String str="Exit";
		String branch="";

		int index=0;

		//split string according to two delimeters
		String[] cond=S.split("\\{|\\;");
		int length=cond.length-1;

		for(int i=0;i<cond.length;i++) {
			if(cond[i].contains("else")) {
				ellse=true;
				length=i;
			}

		}

		if(ellse) {
			str="Else";
			branch=" B Exit";
		}

		if(cond[0].contains("==")) {

			int i=cond[0].indexOf('=');
			char second=cond[0].charAt(i+3);
			String x=getRegister(cond[0].charAt(i-2)+"");
			if(isNumber(second+"")) {
				int end=cond[0].indexOf(')');
				String im=cond[0].substring(i+3,end);
				if(second=='0') {
					System.out.println("       CMP "+x+", XZR");
				}else {
					System.out.println("       SUBIS "+x +", "+x+", #"+im);//a=a-0
				}

				System.out.println("       B.NE "+str);
				for(int j=1;j<length;j++) {
					System.out.print("       ");
					RIType(cond[j]);
				}

			}else {
				String y=getRegister(second+"");
				System.out.println("       CMP "+x+", "+y);
				System.out.println("       B.NE "+str);
				for(int s=1;s<length;s++) {
					System.out.print("       ");
					RIType(cond[s]);
				}
			}
			if(ellse) {
				System.out.print("      ");
				System.out.println(branch);	
			}
			System.out.print(str+":");

		}else if(cond[0].contains("<")) {
			int j=cond[0].indexOf('<');

			sign="B.G";
			if(cond[0].contains("=")) {
				sign+="T";

				eq=true;
			}else {
				sign+="E";
			}
			char first=cond[0].charAt(j-2);
			if(eq)
				j=cond[0].indexOf('=');

			String second=cond[0].charAt(j+2)+"";
			String x=getRegister(first);
			if(isNumber(second+"")) {
				if(second.contains("0")){
					System.out.println("       SUBS  X26"+", "+x+", XZR");//a=a-0
				}else{
					int end=cond[0].indexOf(')');
					String im=cond[0].substring(j+1,end);
					System.out.println("       SUBIS  X26"+", "+x+", #"+im);//a=a-0
				}
				System.out.println("       "+sign+" "+str); 
				for(int s=1;s<length;s++) {
					System.out.print("       ");
					RIType(cond[s]);
				}
				if(ellse) {
					System.out.print("      ");
					System.out.println(branch);	
				}
				System.out.print(str+":");
			}else {
				String y=getRegister(second);

				System.out.println("       SUBS X26"+", "+x+", "+y);//a=a-0
				System.out.println("       "+sign+" "+str); 
				for(int s=1;s<length;s++) {
					System.out.print("       ");
					RIType(cond[s]);
				}
				if(ellse) {
					System.out.print("      ");
					System.out.println(branch);	
				}
				System.out.print(str+":");

			}
		}else if(cond[0].contains("!=")) {
			int i=cond[0].indexOf('!');  
			char second=cond[0].charAt(i+3);
			String x=getRegister(cond[0].charAt(i-2)+"");
			if(isNumber(second+"")) {
				int end=cond[0].indexOf(')');
				String im=cond[0].substring(i+3,end);
				if(second=='0') {
					System.out.println("       CMP "+x+", XZR");
				}else {
					System.out.println("       SUBIS "+x +", "+x+", #"+im);//a=a-0
				}
				System.out.println("       B.EQ "+str);
				for(int j=1;j<length;j++) {
					System.out.print("       ");
					RIType(cond[j]); 
				}
			}else {
				String y=getRegister(second+"");
				System.out.println("       CMP "+x+", "+y);
				System.out.println("       B.EQ "+str);
				for(int s=1;s<length;s++) {
					System.out.print("       ");
					RIType(cond[s]);
				}
			}
			if(ellse) {
				System.out.print("      ");
				System.out.println(branch);	
			}
			System.out.print(str+":");

		}else if(cond[0].contains(">")){
			sign="B.L";
			if(cond[0].contains("=")) {
				sign+="T";
				eq=true;
			}	else
				sign+="E";

			int j=cond[0].indexOf('>');
			char first=cond[0].charAt(j-2);
			if(eq)
				j=cond[0].indexOf('=');


			char second=cond[0].charAt(j+2);
			String x=getRegister(first);
			if(isNumber(second+"")) {
				if(second=='0'){
					System.out.println("       SUBIS "+x +", "+x+", XZR");//a=a-0

				}
				else{
				
				int end=cond[0].indexOf(')');
				String im=cond[0].substring(j+2,end);
				System.out.println("       SUBIS "+x +", "+x+", #"+im);//a=a-0
			}				
				System.out.println("       "+sign+" "+str);

			for(int s=1;s<length;s++) {
				System.out.print("       ");
				RIType(cond[s]);
			}
			if(ellse) {
				System.out.print("      ");
				System.out.println(branch);	
			}
			System.out.print(str+":");
		}else {
			String y=getRegister(second);

			System.out.println("       SUBS "+x +", "+x+", "+y);//a=a-0
			System.out.println("       "+sign+" "+str); 
			for(int s=1;s<length;s++) {
				System.out.print("       ");
				RIType(cond[s]);
			}
			if(ellse) {
				System.out.print("      ");
				System.out.println(branch);	
			}
			System.out.print(str+":");

		}}
		if(ellse) {
			System.out.print("  ");
			RIType(cond[length+1]);
			if(length+2!=cond.length-1) {
				for(int i=length+2;i<cond.length-1;i++) {
					System.out.print("       ");
					RIType(cond[i]);
				}

			}
		}
		if(ellse)
		System.out.println("Exit:");
		System.out.println();
	
	}



	//int a = b + a;
	public void RIType(String S) {
		
		int count=0;
		int a=0;
		int equ=S.indexOf('=');
			String inst="";
		if(S.contains("+"))
			inst="ADD";
		else if(S.contains("-"))
			inst="SUB";
		else if(S.contains("*"))
			inst="MUL";
		int index=0;
		if(S.contains("++")){
			for(int i=0;i<S.length();i++) {
				if(Character.isLetter(S.charAt(i)))
					a=i;
			}

			String reg=getRegister(S.charAt(a));
			System.out.println("ADDI  "+ reg + ", "+reg+ ", #1");

		}else if(S.contains("--")) {
			for(int i=0;i<S.length();i++) {
				if(Character.isLetter(S.charAt(i)))
					a=i;
			}

			String reg=getRegister(S.charAt(a));
			System.out.println("SUBI  "+ reg + ", "+reg+ ", #1 ");
		}else {
			int index3=0;
			boolean shorthand=false;
			String[] line=S.split("\\s");
			
	
			while(line[index].contains("=")==false)
				index++;
			String x1="";
			String x2="";
			//shorthand operator (+= etc.)
			if(line[index].contains("-")||line[index].contains("+")||line[index].contains("*")) {
				x1=getRegister(line[index-1]);
				x2=x1;
				shorthand=true;
			}else {
				x1=getRegister(line[index-1]);
				x2=getRegister(line[index+1]);
			}
			//x += a
			if(shorthand) {
				index3=index +1;
			}else
				index3=index +3;
			if(isNumber(line[index3].charAt(0)+"")) {
				inst+="I";
				System.out.println(inst +"  "+ x1 + ", "+x2+ ", #" +line[index3] + " ");
			}else {
				String x3=getRegister(line[index3].charAt(0)+"");
				System.out.println(inst+"   " + x1 + ", "+x2+ ", " +x3  + " ");
			}
		}

	}

	public void forLoop(String S) {
		String[] loop=S.split("\\{|\\;");
		
	
		int length=loop.length-1;
		int j=0;
		for(int i=0;i<loop.length;i++) {
			if(loop[i].contains("for")) {
				j=i;
			}

		}
		boolean equ=false;
		int a=loop[j].indexOf('=');
		String r=getRegister(S.charAt(a-2)+"");
		System.out.print("      ");
		System.out.println("ADD "+ r+", XZR, XZR");
		System.out.println("for: ");
		int b=loop[j+1].indexOf('<');
		if(loop[j+1].indexOf('=')!=-1)
			equ=true;

		char big=loop[j+1].charAt(b+2);
		if(Character.isDigit(big)) {
			String immediate=loop[j+1].substring(b+2);

			System.out.println("      ADDIS  X27, XZR, #"+immediate);
			System.out.println("      CMP    "+r+", X27");

		}else {
			String t=getRegister(big+"");
			System.out.println("      CMP    "+r+", "+t);
		}
		System.out.println("      B.EQ   Exit");
		j=j+3;

		while(loop[j].contains("}")==false || j!=length) {
			System.out.print("      ");
			RIType(loop[j]);
			j++;
		}
		System.out.print("      ");

		System.out.println("ADDI   "+r+", "+r+ ", #1");
		System.out.print("      ");

		System.out.println("B      for");
		System.out.println("Exit: ");
		System.out.println();


	}

	public void While(String S) {
		String first="";
		String second="";
		String[] loop=S.split("\\{|\\;");
		int length=loop.length-1;
		int j=0;
		for(int i=0;i<loop.length;i++) {
			if(loop[i].contains("while")) {
				j=i;
			}
		}
		for(int i=0;i<loop.length;i++) {
			if(loop[i].contains("/*") || loop[i].contains("//")) {
				loop[i-1]+=loop[i];;
				loop[i]="";			

			}
		}

		int ref=0;	
		System.out.println("while:");
		boolean increment=true;

		
		if(loop[j].contains("<") ||loop[j].contains("<=") ) {
			ref=loop[j].indexOf('<');
			first=getRegister(loop[0].charAt(ref-2)+"");
			if(loop[j].contains("="))
				ref++;
			second=getRegister(loop[0].charAt(ref+2)+"");
			if(isNumber(loop[0].charAt(ref+2)+"")) {
				int end=loop[0].indexOf(')');
				String im=loop[0].substring(ref+2,end);
				if(loop[0].charAt(ref+2)=='0') {
					System.out.println("      SUBS  X27,"+first+", XZR");
				}else {
					System.out.println("      SUBIS  X27, " +first+", #"+im);//a=a-0

				}
			}else {
				System.out.println("      SUBS  X27, "+second+", "+first );
			}
			if(loop[j].contains("=") ) {
				System.out.println("      B.GT  Exit");
			}else {
				System.out.println("      B.GE  Exit");
			}



		}else if(loop[j].contains(">") || (loop[j].contains(">="))) {

			
			ref=loop[j].indexOf('>');	

			first=getRegister(loop[0].charAt(ref-2)+"");

			if(loop[j].contains("="))
				ref++;
			second=getRegister(loop[0].charAt(ref+2)+"");	
			if(isNumber(loop[0].charAt(ref+2)+"")) {
				int end=loop[0].indexOf(')');
				String im=loop[0].substring(ref+2,end);
				if(loop[0].charAt(ref+2)=='0') {
					System.out.println("      SUBS  X27,"+first+", XZR");
				}else {
					System.out.println("      SUBIS  X27, " +first+", #"+im);//a=a-0

				}
			}else {
				System.out.println("      SUBS  X27, "+second+", "+first );

			}
			if(loop[j].contains("=") ) {
				System.out.println("      B.LT  Exit");
			}else {
				System.out.println("      B.LE  Exit");
			}
			


		}else if(loop[j].contains("!=")) { 
			ref=loop[j].indexOf('!');	
			first=getRegister(loop[0].charAt(ref-2)+"");
			second=getRegister(loop[0].charAt(ref+3)+"");
			if(isNumber(loop[0].charAt(ref+3)+"")) {
				int end=loop[0].indexOf(')');
				String im=loop[0].substring(ref+3,end);
				if(loop[0].charAt(ref+3)=='0') {
					System.out.println("      CMP "+first+", XZR");
				}else {
					System.out.println("      SUBI  X27, XZR,"+"#"+im);//a=a-0
					System.out.println("      CMP "+first+", X27");

				}
			}
			System.out.println("      B.EQ  Exit");
		
		}else if(loop[j].contains("==")) { 
			ref=loop[j].indexOf('=');	
			first=getRegister(loop[0].charAt(ref-2)+"");
			second=getRegister(loop[0].charAt(ref+3)+"");
			if(isNumber(loop[0].charAt(ref+3)+"")) {
				int end=loop[0].indexOf(')');
				String im=loop[0].substring(ref+3,end);
				if(loop[0].charAt(ref+3)=='0') {
					System.out.println("      CMP "+first+", XZR");
				}else {
					System.out.println("      SUBI X27, XZR, "+" #"+im);//a=a-0
					System.out.println("      CMP "+first+", X27");

				}
			}
			System.out.println("      B.NE  Exit");
		}

		for(int i=1;i<loop.length-1;i++	) {
			System.out.print("      ");
			RIType(loop[i]);
		}
		System.out.println("      B     while");
		
		System.out.println("Exit:");
	}






	public int type(String S) {
		int a=0;
		for(int i=0;i<S.length();i++) {
			if(Character.isLetter(S.charAt(i))) {
				a=i;
				break;
			}
		}
		int b=a+2;
		int c=a+3;
		int d=a+4;

		if(S.contains("if"))
			return 2;
		else if(S.contains("while")) 
			return 3;
		else if(S.contains("for")) 
			return 4;	
		else 
			return 1;
	}

	public String getRegister(String letter) {
		for (char i = 'a'; i <= 'z'; i++) {
			registers.add(i+"");
		}
		int s=registers.indexOf(letter);
		String STR="X"+s;
		registers.clear();

		return STR;

	}
	public String getRegister(char letter) {
		registers.clear();
		for (char i = 'a'; i <= 'z'; i++) {
			registers.add(i);
		}
		int s=registers.indexOf(letter);
		String STR="X"+s;
		registers.clear();
		return STR;
	}



}
