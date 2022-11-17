import javax.crypto.SecretKey;
import java.util.Scanner;

public class MainDES {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DES des = new DES();

        System.out.print("Please enter a message: ");
        String msg = scanner.nextLine();

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();

        SecretKey ranKey = des.generateRandomKey();
        SecretKey passKey = des.generateKeyFromPassword(password);

        String encMsg = des.encrypt(msg, ranKey);
        String encPassMsg = des.encrypt(msg, passKey);

        String decMsg = des.decrypt(encMsg, ranKey);
        String decPassMsg = des.decrypt(encPassMsg, passKey);

        System.out.println("Your plaintext message: " + msg);
        System.out.println("Encrypted message with random key: " + encMsg);
        System.out.println("Encrypted message with key generated from password: " + encPassMsg);
        System.out.println("Decrypted message with random key: " + decMsg);
        System.out.println("Decrypted message with key generated from password: " + decPassMsg);


    }
}
