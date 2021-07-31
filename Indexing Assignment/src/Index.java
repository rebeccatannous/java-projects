import java.util.*;
import java.io.*;

public class Index {


	//1.
	public static void read(String dir) {

		try {
			File file1= new File (".\\output.txt");
			FileWriter fw1;
			file1.createNewFile();
			fw1 = new FileWriter(file1);
			BufferedWriter bw=new BufferedWriter(fw1);
			FileReader fr = new FileReader(dir);
			BufferedReader br = new BufferedReader(fr);
		

			String line="";
			while((line=br.readLine())!=null) {
				try {

					String[] str=line.split(" ");	
					str[0]=str[0].replaceAll("[-+.^:,]", "");
					for(int i=1;i<str.length;i++) {
						if(str[i].equals("\\s")) {
						}else {
							str[i]=str[i].replaceAll("[-+.^:,]", "");
							bw.write(str[i] + " " +str[0]+"\n");
						}
					}
				}
				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}
			br.close();
			bw.close();

		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("file not found");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//2.
	public static void clean(String s) {
		ArrayList<String> list = new ArrayList<String>(); 
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			/*File file = new File("bfile.dat");
		      file.createNewFile();
			FileWriter fw = new FileWriter("bfile.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			 */

			File file1= new File (".\\bfile.dat.txt");
			FileWriter fw1;

			file1.createNewFile();
			fw1 = new FileWriter(file1);
			BufferedWriter bw1=new BufferedWriter(fw1);

			String line="";
			while((line=br.readLine())!=null) {
				try {
					list.add(line);
				}
				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}

			Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
		

			for(int i=0;i<list.size();i++) {
				for(int j=i+1; j<list.size();j++) {
					if(list.get(i).equalsIgnoreCase(list.get(j)))
						list.remove(i);
				}
			}

			for(int i=0;i<list.size();i++) {
				if(list.get(i).toLowerCase().contains("the") || list.get(i).toLowerCase().contains("or") || list.get(i).toLowerCase().contains("and") || list.get(i).toLowerCase().contains("that") || list.get(i).toLowerCase().contains("not") || list.get(i).toLowerCase().contains("to") || list.get(i).toLowerCase().contains("is") || list.get(i).toLowerCase().contains("are") || list.get(i).toLowerCase().contains("were") || list.get(i).toLowerCase().contains("then") || list.get(i).toLowerCase().contains("thus") || list.get(i).toLowerCase().contains("therefore")) {
					list.remove(i);
					i--;
				}
			}	

			for(int i=0;i<list.size();i++) {
				bw1.write(list.get(i)+"\n");
			}

			br.close();
			bw1.close();

			int occ=1;
			for(int i=0;i<list.size();i++) {
				occ=1;
				String str=list.get(i).substring(0,list.get(i).indexOf(' '));
				for(int j=i+1;j<list.size();j++) {
					if(str.equalsIgnoreCase(list.get(j).substring(0,list.get(j).indexOf(' ')))) {
						occ++;
						list.remove(j);
						j--;
					}
				}
				System.out.println(str +" "+ occ);
			}
		}	

		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("file not found");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	//3. Bonus ex
	public static void indexing(String s) {
		ArrayList<String> list = new ArrayList<String>(); 
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);


			File file1= new File (".\\bfile.inv.txt");
			FileWriter fw1;

			file1.createNewFile();
			fw1 = new FileWriter(file1);
			BufferedWriter bw1=new BufferedWriter(fw1);

			String line="";
			while((line=br.readLine())!=null) {
				try {
					list.add(line);
				}
				catch (NumberFormatException e) {
					continue;
				}
				catch(NullPointerException e) {
					continue;

				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}

			for(int i=0;i<list.size();i++) {
				String str=list.get(i).substring(0,list.get(i).indexOf(' '));
				String f1=list.get(i).substring(list.get(i).indexOf(' '));
				bw1.write(str +f1);
				for(int j=i+1;j<list.size();j++) {
					if(str.equalsIgnoreCase(list.get(j).substring(0,list.get(j).indexOf(' ')))) {
						bw1.write(list.get(j).substring(list.get(j).indexOf(' '))+ " ");
						list.remove(j);
						j--;
					}
				}
				bw1.write("\n");
			}

			br.close();
			bw1.close();


		}	

		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("file not found");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] Args) {
		read(".\\file.txt");
		clean(".\\output.txt");
		indexing(".\\bfile.dat.txt");
	}
}
