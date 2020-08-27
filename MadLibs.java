import java.util.*;
import java.io.*;

public class MadLibs {

	public static void main(String[] args) {
		//0. Give variable names for each of the arraylists below and create Madlibs stories.
		ArrayList<String> nouns =  new ArrayList<String>();
		ArrayList<String> verbs =  new ArrayList<String>();
		ArrayList<String> adjs =  new ArrayList<String>();
		ArrayList<String> advs =  new ArrayList<String>();

		//1. Read a nouns.txt file and store its list of nouns into an arraylist.

		//2. Read a verbs.txt file and store its list of verbs into an arraylist.
		BufferedReader br2 = new BufferedReader (new FileReader (verbs.txt)); 
		String verb = br2.readLine();
		while (verb!=null);
		{
			verbs.add(verb);
			verb = br2.readLine();
		}
		br2.close();

		//3. Read an adjectives.txt file and store its list of adjectives into an arraylist.

		File file3 = new File("adjectives.txt");
		BufferedReader br3 = new BufferedReader(new FileReader(file3));

		String st3;
		while ((st3 = br3.readLine()) != null) {
			adjs.add(st3);
		}
		br3.close()
		
		//4. Read an adverbs.txt file and store its list of adverbs into an arraylist.

		//5. Prompt user for the name of a file containing a MadLibs story.
		// Read the story from that file and write it to System.out, but replacing each instance of
		// <<NOUN>>, <<VERB>>, etc. with a randomly chosen word from the corresponding list.
		System.out.println("Please give name of the file containing a MadLibs story: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.nextLine();
		BufferedReader storyReader = new BufferedReader(new FileReader(fileName));

		String story = "";
		int inputCharNum = storyReader.read();
		while(inputCharNum != -1) {
			story += (char)inputCharNum;
			inputCharNum = reader.read();
		}
		storyReader.close();

		int nounRandom = (int)(Math.random()*nouns.size());
		int verbRandom = (int)(Math.random()*verbs.size());
		int adjRandom = (int)(Math.random()*adjs.size());
		int advRandom = (int)(Math.random()*advs.size());

		String randomNoun = nouns.get(nounRandom);
		String randomVerb = nouns.get(verbRandom);
		String randomAdj = nouns.get(adjRandom);
		String randomAdv = nouns.get(advRandom);

		int nounLoc = story.indexOf("<<NOUN>>");
		story = story.substring(0, nounLoc) + randomNoun + story.substring(nounLoc + 8);
		int verbLoc = story.indexOf("<<VERB>>");
		story = story.substring(0, verbLoc) + randomVerb + story.substring(verbLoc + 8);
		int adjLoc = story.indexOf("<<ADJECTIVE>>");
		story = story.substring(0, adjLoc) + randomAdj + story.substring(adjLoc + 13);
		int advLoc = story.indexOf("<<ADVERB>>");
		story = story.substring(0, advLoc) + randomAdv + story.substring(advLoc + 10);

		System.out.println(story);
	}

}
