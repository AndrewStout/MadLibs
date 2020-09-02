import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MadLibs {

	public static void main(String[] args) {
		//0. Give variable names for each of the arraylists below and create Madlibs stories.
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> verbs = new ArrayList<String>();
		ArrayList<String> adjectives = new ArrayList<String>();
		ArrayList<String> adverbs = new ArrayList<String>();

		
		//1. Read a nouns.txt file and store its list of nouns into an arraylist.
		nouns = readAndStore("nouns.txt");
		adverbs = readAndStore("nouns.txt");
		adjectives = readAndStore("nouns.txt");
		verbs = readAndStore("nouns.txt");
		
		System.out.println(nouns);
		
		//2. Read a verbs.txt file and store its list of verbs into an arraylist.
		
		//3. Read an adjectives.txt file and store its list of adjectives into an arraylist.
		
		//4. Read an adverbs.txt file and store its list of adverbs into an arraylist.

		//5. Prompt user for the name of a file containing a MadLibs story.
		// Read the story from that file and write it to System.out, but replacing each instance of
		// <<NOUN>>, <<VERB>>, etc. with a randomly chosen word from the corresponding list.
		buildStory(nouns, verbs, adjectives, adverbs);
	}
	
	private static void buildStory(ArrayList<String> nouns,
	 	ArrayList<String> verbs,
		ArrayList<String> adjectives,
		ArrayList<String> adverbs) {
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter mad libs text file> ");
			String filename = sc.nextLine();

			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
				
				String line = "";
				while ((line = br.readLine()) != null) {
					for (String word : line.split(" ")) {

						if (word.contains("<<NOUN>>")) {
							int rn = (int)(Math.random() * nouns.size());
							word = word.replace("<<NOUN>>", nouns.get(rn));
						}

						else if (word.contains("<<VERB>>")) {
							int rn = (int)(Math.random() * verbs.size());
							word = word.replace("<<VERB>>", verbs.get(rn));
						}

						else if (word.contains("<<ADJECTIVE>>")) {
							int rn = (int)(Math.random() * adjectives.size());
							word = word.replace("<<ADJECTIVE>>", adjectives.get(rn));
						}

						else if (word.contains("<<ADVERB>>")) {
							int rn = (int)(Math.random() * adverbs.size());
							word = word.replace("<<ADVERB>>", adverbs.get(rn));
						}

						System.out.print(word);
						System.out.print(" ");
					}

					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	private static ArrayList<String> readAndStore(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		
		File nounsFile = new File(fileName);
		FileReader fr;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(nounsFile);
			br = new BufferedReader(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String noun = "";
		
		try {
			while(br.ready()) {
				char character = (char) br.read();
				
				//to account for /n (LF) and /r (CR)
				//for some reason all new lines in .txt are CR except for last one???
				//*assumed new line after last word in file?
				if((int) character == 10 || (int) character == 13) {
					list.add(noun);
					noun = "";
				}
				else {
					noun += character;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
