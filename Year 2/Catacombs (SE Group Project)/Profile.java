import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the player profiles.
 * @author Connor Humphries
 * @version 1.0
 */
public class Profile {
	
	private static int amtOfProfiles = 0;
	private int profileID;
	private String username;
	private int amtOfWins;
	private int gamesPlayed;
	private int amtOfLosses;
	private double percentageOfWins;
	private double percentageOfLosses;

	
	public Profile() {
	}

	/**
	 * Creates a profile with a username and their stats.
	 * @param username Player name.
	 * @param gamesPlayed How many games they've played.
	 * @param amtOfWins The amount of wins they have.
	 * @param amtOfLosses The amount of losses they have.
	 */
	public Profile(String username, int gamesPlayed, int amtOfWins, int amtOfLosses) {
		amtOfProfiles++;
		profileID = amtOfProfiles;
		setFirstname(username);
		setGamesPlayed(gamesPlayed);
		setAmtOfWins(amtOfWins);
		setAmtOfLosses(amtOfLosses);
		setPercentageOfWins();
		setPercentageOfLosses();
		
	}
	public int getProfileID() {
		return profileID;
	}
	private void setFirstname(String firstname) {
		this.username = firstname;
	}
	public String getUsername() {
		return username;
	}
	private void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	private void setAmtOfWins(int amtOfWins) {
		this.amtOfWins = amtOfWins;
	}
	public int getAmtOfWins() {
		return amtOfWins;
	}
	private void setAmtOfLosses(int amtOfLosses) {
	this.amtOfLosses = amtOfLosses;
	}
	public int getAmtOfLosses() {
		return amtOfLosses;
	}
	public void setPercentageOfWins() {
		if (gamesPlayed == 0) {
			this.percentageOfWins = 0;
		} else if(amtOfWins == 0) {
			this.percentageOfWins = 0;
		} else {
			double winPerc = Math.round((double)amtOfWins/(double)gamesPlayed * 100);
			this.percentageOfWins = winPerc;
		}
	}
	public double getPercentageOfWins() {
		return percentageOfWins;
	}
	public void setPercentageOfLosses() {
		if (gamesPlayed == 0) {
			this.percentageOfWins = 0;
		} else if(amtOfLosses == 0) {
			this.percentageOfWins = 0;
		} else {
		 this.percentageOfLosses = Math.round((double)amtOfLosses/(double)gamesPlayed * 100);
		}
	}
	public double getPercentageOfLosses() {
		return percentageOfLosses;
	}
	public void addGame() {
		gamesPlayed++;
	}
	public void addWin() {
		amtOfWins++;
	}
	public void addLoss() {
		amtOfLosses++;
	}
 	public String toString() {
		return profileID + " " + username + " " + gamesPlayed;
	}
	
	
}
