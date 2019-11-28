/**
 * This class uses the Cipher class to create
 * a simple encryption/decryption command-line program
 * @author Ziad Sakr
 * @author Ewa Syta
 * @version 1.0 3/12/18
 */

import java.io.*;                       // Java input/output classes
import java.util.Scanner;               // Java Scanner class


public class CipherDemo {

    /**
     * This methods gets the message from a specified file
     * and returns it as a String
     *
     * @param fileName the file to be opened and read
     * @return file contents as a String
     */
    private static String getMessageFromFile(String fileName) {
        String message = null;
        try {
            File messageFile = new File(fileName);
            message = new Scanner(messageFile).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " has not been found.");
        }
        return message;
    }

    /**
     * This methods writes the message to a specified file
     *
     * @param fileName the file to be created
     * @param message  the message to be written to a file
     */
    private static void writeMessageToFile(String fileName, String message) {
        try {
            PrintWriter outputFile = new PrintWriter(fileName);
            outputFile.println(message);
            outputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " has not been found.");
        }
    }

    /**
     * Runs the encryption/decryption program
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int numOfArguments = args.length; // Stores the number of command-line arguments
        String messageFromFile = ""; // Used to store the file contents
        String encryptedMessage = ""; // Used to store the entire encrypted message
        String decryptedMessage = ""; // Used to store the entire decrypted message

        // Checks if 3 arguments were provided and displays the proper usage if not

        if (numOfArguments != 3) {
            System.out.println("usage: mode file_name key_value");
        } else {
            String mode = args[0]; // Stores the first argument: the mode of operation
            String file_name = args[1]; // Stores the second argument: the file name
            int key_value = Integer.parseInt(args[2]); // Stores the third argument: the key value converted to int

            // Checks if correct arguments were provided

            if ( key_value < 0 || key_value > 26 ) {
                System.out.println("The shift must be in the range 0 - 25. ");
            } else {

                // Steps to perform if the encryption mode was selected

                if (mode.equals("e")) {
                    // Read the file into a String message
                    messageFromFile = getMessageFromFile(file_name + ".txt");

                    if (messageFromFile != null) {
                        // Encrypt the message using the key value provided
                        encryptedMessage = Cipher.encrypt(messageFromFile, key_value);
                        // Save the encryptedMessage to a file with an .enc extension
                        writeMessageToFile(file_name + ".enc", encryptedMessage);
                    }
                }

                // Steps to perform if the decryption mode was selected

                else if (mode.equals("d")) {
                    // Read the file into a String message
                    messageFromFile = getMessageFromFile(file_name + ".enc");

                    if (messageFromFile != null) {
                        // Decrypt the message using the key value provided
                        decryptedMessage = Cipher.decrypt(messageFromFile, key_value);

                        // Save the decryptedMessage to a file with an .dec extension
                        writeMessageToFile(file_name + ".dec", decryptedMessage);
                    }
                }

                // If unknown mode of was entered

                else {
                    System.out.println("No such mode of operation!");
                }
            }
        }
    }
}
