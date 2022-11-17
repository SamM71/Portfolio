import javax.crypto.SecretKey;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        AES aes = new AES();

        System.out.print("Please enter a message: ");
        String msg = scanner.nextLine();

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();

        SecretKey ranKey = aes.generateRandomKey();
        SecretKey passKey = aes.generateKeyFromPassword(password);

        String encMsg = aes.encrypt(msg, ranKey);
        String encPassMsg = aes.encrypt(msg, passKey);

        String decMsg = aes.decrypt(encMsg, ranKey);
        String decPassMsg = aes.decrypt(encPassMsg, passKey);

        System.out.println("Your plaintext message: " + msg);
        System.out.println("Encrypted message with random key: " + encMsg);
        System.out.println("Encrypted message with key generated from password: " + encPassMsg);
        System.out.println("Decrypted message with random key: " + decMsg);
        System.out.println("Decrypted message with key generated from password: " + decPassMsg);


    }

}
