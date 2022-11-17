import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL; 
import java.net.URLConnection;

/**
 * Gets and displays the message of the day.
 * @author Jeff Guo
 * @version 1.0
 */
public class Message {
    private final static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
			'S','T','U','V','W','X','Y','Z'};
    private final static String puzzle = "http://cswebcat.swansea.ac.uk/puzzle";
    private final static String URL = "http://cswebcat.swansea.ac.uk/message?solution=";
	/**
 	* Gets the message of the day.
 	* @return Message of the day.
 	*/
	public static String getMessage() {
		return capture(getURL(decode(capture(puzzle))));
	}
	/**
 	* Merges the correct result with part of the URL.
 	* @param code The result.
 	* @return The correct URL.
 	*/
	private static String getURL (String code) {
		String solution = "CS-230" + code;
		solution = solution + solution.length();
		return URL + solution;
	}
	
	/**
 	* Gets the code from the web page.
 	* @param URL The URL where stored the code.
 	* @return The captured string.
 	*/
	private static String capture (String URL) {
		String code = null;
		try {
	        URL puzzle = new URL(URL);
	        URLConnection connection = puzzle.openConnection();
	        BufferedReader in = new BufferedReader(new
	        InputStreamReader(connection.getInputStream()));
	        String line;
	        if((line = in.readLine()) != null) {
	        	code = line;
	        }
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return code;
	}
	/**
 	* Decode the given puzzle.
 	* @param code The given puzzle.
 	* @return The solution.
 	*/
	private static String decode (String code) {
		String result = "";
		int counter = 0;
		while (counter < code.length()) {
			if ((counter + 1) % 2 != 0) {
				result += shiftBack(code.charAt(counter), counter + 1);
				counter++;
			} else {
				result += shiftForward(code.charAt(counter), counter + 1);
				counter++;
			}
		}
		return result;
	}
	
	/**
 	* Shifts forward the character and make sure it will not be wrong.
 	* @param character Each character in the given code.
 	* @param times How many times need to shift.
 	* @return The character needed.
 	*/
	private static char shiftForward (char character, int times) {
		int ini = match(character);
		while (times != 0) {
			if (alphabet[ini] == 'Z') {
				ini = 0;
				times--;
			} else {
				ini++;
				times--;
			}
		}
		return alphabet[ini];
	}
	
	/**
 	* Shift back the character and make sure it will not wrong.
 	* @param character Each character in the given code.
 	* @param times How many times need to shift.
 	* @return The character needed.
 	*/
	private static char shiftBack (char character, int times) {
		int ini = match(character);
		while (times != 0) {
			if (alphabet[ini] == 'A') {
				ini = 25;
				times--;
			} else {
				ini--;
				times--;
			}
		}
		return alphabet[ini];
	}
	/**
 	* To locate the position of character in the alphabet.
 	* @param character Given character.
 	* @return The matched indexNum.
 	*/
	private static int match (char character) {
		int i = 0;
		while (character != alphabet[i]) {
			i++;
		}
		return i;
	}
}