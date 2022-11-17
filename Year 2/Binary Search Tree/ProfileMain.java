public class ProfileMain {

    public static void main(String[] args) {
        Profile profile = new Profile("Sam", "Mocock", 24, 3, 2000,
                "978082@swans.ac.uk", new String[]{"Football", "Programming"},
                new String[]{"5-a-side", "Gaming"});
        Profile profile1 = new Profile("Bob", "Dylan", 24, 5, 1941,
                "111000@swans.ac.uk", new String[]{"Music", "Guitar"},
                new String[]{"Performing", "Singing"});
        System.out.println(profile.toString());
        profile.addFriend(profile1);
        System.out.println(profile.toString());
    }
}
