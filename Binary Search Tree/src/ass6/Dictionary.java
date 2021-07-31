package ass6;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Dictionary {
	private BST t;

	public Dictionary() {
		t = new BST();
	}

	public BST getT() {
		return t;
	}

	public void setT(BST t) {
		this.t = t;
	}



	public void updateFile(String a) {
		try {
			// writes in file
			t.setSTR();
			FileWriter fw = new FileWriter(a);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(t.WriteFile());

			bw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println();
		}
	}

	public void deleteWord() {
		//deletes specific definitions
		System.out.println("Which word would you like to delete");
		String word = InputStream();

		if (t.find(word) == null) {
			System.out.println("Word not found");
		} else {
			BNode n = t.find(word);
			int i = t.homonyms(word);

			if (i == 1) {
				t.search(word);
				t.delete(n);
				System.out.println("Word deleted");
			}

			else {
				t.search(word);
				System.out.println(i + 1 + "- All");
				System.out.println("Which defintion of " + word + " would you like to delete");

				int num = chooseInt();
				while (num > (i + 1)) {
					System.out.println("Invalid, Enter again");
					num = chooseInt();

				}
				if (num == 1) {
					t.delete(n);
					System.out.println("Word deleted");

				} else if (num == i + 1) {
					t.delete(n);
					while (i > 0) {
						BNode s = t.find(word);
						t.delete(s);
						i--;
					}
					t.delete(t.find(word));
					System.out.println("All definitions deleted");
				} else {
					BNode temp = n;

					while (num > 1) {
						n = n.getLeft();
						num--;
					}
					t.delete(n);
					System.out.println("Word deleted");

				}
			}

		}
	}

	public String directory() {
		//prompts the user for the file directory/name
		//3 attempts are allowed
		int count = 1;
		System.out.println("Enter file directory");
		String direct = InputStream();
		boolean a = readFile(direct);

		while (a == false && count < 3) {
			direct = InputStream();
			a = readFile(direct);
			count++;
		}

		if (a)
			return direct;
		else
			return null;

	}

	public boolean readFile(String S) {
		//reads file and adds specific objects
		try {

			FileReader fr = new FileReader(new File(S));
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				try {
					String[] a = line.split(": ");
					Definition d = new Definition(a[0], a[1]);
					t.add(d);
					
				} catch (NumberFormatException e) {
					continue;
				} catch (NullPointerException e) {
					continue;

				} catch (IndexOutOfBoundsException e) {
					continue;
				}
			}
			br.close();

		} catch (FileNotFoundException e) {

			System.out.println("File not found");

			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	// method to handle Number Format Exceptions
	public static int chooseInt() {
		Scanner scan = new Scanner(System.in);
		String a;
		try {
			a = scan.next();
			int i = Integer.parseInt(a);
			while (i <= 0) {
				System.out.println("Enter again");

				a = scan.next();
				i = Integer.parseInt(a);
			}
			return i;
		} catch (NumberFormatException e) {
			System.out.println("Enter again");
			return chooseInt();
		}
	}

	//Scanner class did not scan strings with more than one word so I used Input Stream throughout the program
	public static String InputStream() {
		InputStreamReader st = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(st);
		String w;
		try {
			w = br.readLine();

			return w;

		} catch (IOException e) {
			System.out.println("Enter again");
			return InputStream();
		}
	}

	public void addDef() {
		System.out.println();
		System.out.println("Enter word");
		String Word = InputStream();
		System.out.println("Enter word description");
		String Des = InputStream();
		Definition d = new Definition(Word, Des);
		if (t.add(d, t.getRoot()) == null) {
			System.out.println();
			System.out.println("Word already added");
		}
	}

	public void menu() {

		int exit = 0;
		String a = null;

		while (exit == 0) {

			System.out.println("");
			System.out.println("1.	Create the dictionary");
			System.out.println("2.	Add a definition");
			System.out.println("3.	Remove a definition");
			System.out.println("4.	Search for a definition");
			System.out.println("5.	Print dictionary");
			System.out.println("6.	Display tree");
			System.out.println("7.	Exit");
			System.out.println("--------------------");
			System.out.println("Enter choice");

			int choice = chooseInt();

			switch (choice) {
			case 1:
				System.out.println();
				a = directory();
				if (a != null)
					System.out.println("Definitions extracted");
				else
					System.out.println("Could not extract definitions");

				break;

			case 2:
				addDef();
				break;

			case 3:
				deleteWord();
				break;

			case 4:
				System.out.println();
				System.out.println("Enter word");
				String w = InputStream();
				t.search(w);
				break;

			case 5:
				System.out.println();
				System.out.println("---Dictionary---");
				t.inOrderPrint();
				break;
			case 6:
				//did not have time to do it but technically this is a tree :)
				System.out.println("\\ "+ "     /  ");
				System.out.println(" \\"+ "    /  ");
				System.out.println("  \\"+ "  /  ");
				System.out.println("   ||  ");
				System.out.println("   ||  ");
				System.out.println("   ||  ");
				break;
			case 7:
				if(a!=null) {
					updateFile(a);
				t.setSTR();
				}
				else {
					System.out.println("No file was found to save your definitions");
				}
					
				System.out.println();
				System.out.println("Exiting the menu...");
				exit = 1;
				break;

			default:
				System.out.println("Invalid choice");
			}
			}
		}


	public static void main(String[] Args) {
		Dictionary a = new Dictionary();
		a.menu();
	}

}