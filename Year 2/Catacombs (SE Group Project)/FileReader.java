import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the file reader for profile.txt.
 * @author Connor Humphries
 * @version 1.0
 */
public class FileReader {

	private static ArrayList<Profile> listOfProfiles = new ArrayList<Profile>();

	/**
	 * Creates an ArrayList of profiles.
	 * @return List of profiles.
	 */
	public static ArrayList<Profile> fileReader() {
		Scanner in = null;
		try {
			File f = new File("src/File.txt");
			in = new Scanner(f);
			return fileScanner(in);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		return listOfProfiles;
	}

	/**
	 * Uses a scanner to get information from the file.
	 * @param f Scanner.
	 * @return A list of profiles.
	 */
	private static ArrayList<Profile> fileScanner(Scanner f) {
		while (f.hasNextLine()) {
			String currentLine = f.nextLine();
			if (currentLine.equals("--Profile--")) {
				String username = f.next();
				int gamesPlayed = f.nextInt();
				int amtOfWins = f.nextInt();
				int amtOfLosses = f.nextInt();

				Profile profile = new Profile(username, gamesPlayed, amtOfWins, amtOfLosses);

				listOfProfiles.add(profile);
			}
		}
		return listOfProfiles;
	}

	/**
	 * Adds a profile to the list.
	 * @param username Name of user.
	 */
	public static void addProfile(String username) {
		try {
			File profileFile = new File("src/File.txt");
			FileWriter addToFile = new FileWriter(profileFile, true);

			addToFile.write("\n--Profile--" + "\n" + username + "\n0" + "\n0" + "\n0");
			addToFile.close();
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	public static ArrayList<Profile> getArrayOfProfiles() {
		return listOfProfiles;
	}
}
