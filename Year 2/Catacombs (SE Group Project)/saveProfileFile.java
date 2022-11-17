import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class represents how profiles are saved and updated.
 * @author Connor Humphries
 * @version 1.0
 */
public class saveProfileFile {

	/**
	 * Updates the profiles involved in the game.
	 */
	public static void updateProfiles() {
		
		ArrayList<Profile> profiles = FileReader.getArrayOfProfiles();
		System.out.println(profiles.size());
		
		try {
			
			File profileFile = new File("src/File.txt");
			PrintWriter clearFile = new PrintWriter(profileFile);
			clearFile.close();

			FileWriter addToFile = new FileWriter(profileFile, true);

			for (int i = 0; i < profiles.size(); i++) {
				System.out.println(profiles.get(i).toString());
				if (i == 0) {
					addToFile.write("--Profile--" + "\n" + profiles.get(i).getUsername() + "\n"
							+ profiles.get(i).getGamesPlayed() + "\n" + profiles.get(i).getAmtOfWins() + "\n"
							+ profiles.get(i).getAmtOfLosses());
				} else {
					addToFile.write("\n--Profile--" + "\n" + profiles.get(i).getUsername() + "\n"
							+ profiles.get(i).getGamesPlayed() + "\n" + profiles.get(i).getAmtOfWins() + "\n"
							+ profiles.get(i).getAmtOfLosses());
				}
			}
			addToFile.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
