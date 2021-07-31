import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	Assembly a=new Assembly();



	public  void read() {
		try {
			FileReader fr = new FileReader(new File("C:\\Users\\CLP\\Desktop\\Assembly\\src\\input.txt"));
			BufferedReader br = new BufferedReader(fr);

			String line="";
			String lastline="";
			String str="";
			while((line=br.readLine())!=null) {
				if(str!="")
					line+=str;
				str="";
				try {

					int x=a.type(line);
					if(x==1) {
						System.out.println();
						a.RIType(line);
						System.out.println();
					}
					else if(x==2) {
						line+="\n";

						while(line.contains("}")==false) {
							line+=br.readLine()+"\n";
						}
						if(line.contains("else")) {
							while(lastline.contains("}")==false) {
								lastline=br.readLine()+"\n";
								line+=lastline;
							}
						}else {
							lastline=br.readLine();
							if(lastline.contains("else")) {
								line+=lastline+"\n";
								while(lastline.contains("}")==false) {
									lastline=br.readLine()+"\n";
									line+=lastline;
								}
							}else {
								str=lastline;
							}
						}
						a.condition(line);
					}else if(x==3) {
						line+="\n";

						while(line.contains("}")==false) {
							line+=br.readLine()+"\n";
						}
						a.While(line);
					}else if(x==4) {
						line+="\n";

						while(line.contains("}")==false) {
							line+=br.readLine()+"\n";
						}
						a.forLoop(line);					
					}
				}catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}

			}
			br.close();

		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("input.txt not found");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] Args) {
		Main m=new Main();
		m.read();

	}
}
