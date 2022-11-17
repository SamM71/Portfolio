import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    /**
     * Reads profiles from disk and populates the tree
     * @param filename
     * @return
     */
    public static BST readProfileSet(String filename) {
        BST tree = new BST();
        File f = new File(filename);
        Scanner in = makeScanner(f);

        while (in.hasNextLine()) {
            String curLine = in.nextLine();
            Scanner line = new Scanner(curLine);
            //line.useDelimiter(",");
            //System.out.println(line.next());
            Profile profile = makeProfile(line);
            tree.insertProfile(profile);
        }

        return null;
    }

    /**
     *
     * @param f - file to be read from
     * @return Scanner object
     */
    private static Scanner makeScanner(File f) {
        Scanner in = null;
        try {
            in = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        return in;
    }

    /**
     *
     * @param line
     * @return
     */
    private static Profile makeProfile(Scanner line) {
        line.useDelimiter(","); //use commas as delimiter
        String surname = line.next();
        String forename = line.next();
        int day = line.nextInt();
        int month = line.nextInt();
        int year = line.nextInt();
        String email = line.next();
        Scanner section = new Scanner(line.next());
        String[] interests = readInterestsAndActivities(section);
        section = new Scanner(line.next());
        String[] activities = readInterestsAndActivities(section);
        Profile profile = new Profile(forename, surname, day, month, year, email, interests, activities);
        return profile;
    }

    /**
     *
     * @param section
     * @return
     */
    private static String[] readInterestsAndActivities(Scanner section) {
        section.useDelimiter(";");
        ArrayList<String> arrayList = new ArrayList<String>();
        while (section.hasNext()) {
            String data = section.next();
            arrayList.add(data);
        }
        String[] array = arrayList.toArray(new String[0]);
        return array;
    }

}
