import java.util.ArrayList;

public class Profile {
    private String forename;
    private String surname;
    private int day;
    private int month;
    private int year;
    private String email;
    private String[] interests;
    private String[] activities;
    private ArrayList<Profile> friends = new ArrayList<Profile>();

    /**
     * Constructor for Profile
     * @param forename - first name
     * @param surname - last name
     * @param day - day of birth
     * @param month - month of birth
     * @param year - year of birth
     * @param email - email address
     * @param interests - interests of person
     * @param activities - activities and groups they participate in
     */
    public Profile(String forename, String surname, int day, int month, int year, String email, String[] interests, String[] activities) {
        setForename(forename);
        setSurname(surname);
        setDay(day);
        setMonth(month);
        setYear(year);
        setEmail(email);
        setInterests(interests);
        setActivities(activities);
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getForename() {
        return this.forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    /**
     * Makes sure day is valid
     * @param day - of birth
     */
    public void setDay(int day) {
        if (day <= 31 && day >= 1) {
            this.day = day;
        } else {
            System.out.println("Invalid day for " + getForename() + " " + getSurname());
        }
    }

    public int getDay() {
        return this.day;
    }

    /**
     * Makes sure month is valid
     * @param month - of birth
     */
    public void setMonth(int month) {
        if (month <= 12 && month >= 1) {
            this.month = month;
        } else {
            System.out.println("Invalid month for " + getForename() + " " + getSurname());
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public String getDateOfBirth() {
        String dob = getDay() + "/" + getMonth() + "/" + getYear();
        return dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String[] getInterests() {
        return this.interests;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    public String[] getActivities() {
        return this.activities;
    }

    /**
     * Adds a friend to the friends ArrayList
     * @param p - new friend
     */
    public void addFriend(Profile p) {
        this.friends.add(p);
    }

    /**
     *
     * @param i - index in ArrayList
     * @return - friend found at index
     */
    public Profile getFriend(int i) {
        try {
            return this.friends.get(i);
        }
        catch (IndexOutOfBoundsException | NullPointerException f) {
            return null;
        }
    }

    public int numOfFriends() {
        return this.friends.size();
    }

    /**
     *
     * @return a string that represents the profile
     */
    public String toString() {
        String profile = getForename() + " " + getSurname() + ", " + getDateOfBirth() + ", " + getEmail() + "\n";
        for (String i:interests) {
            profile += i + ", ";
        }
        for (String a:activities) {
            profile += a + ", ";
        }
        profile += numOfFriends() + "\n";
        return profile;
    }



}
