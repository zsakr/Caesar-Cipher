/**
 * This class uses to create
 * a simple encryption/decryption program
 *
 * @author Ziad Sakr
 * @version 1.0 4/15/18
 */

public class Cipher {
                
    // create a string constant for the alphabet variable
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

     /**
     * This method check the length and get the position for character and
     * and make the calculation for encryption
     *@param plaintext
     *@param shiftKey
     *@return encodeAsCipherText(cipherText)
     */
    public static String encrypt(String plaintext, int shiftKey) {
        // declare a variable
         String ciphertext = "";
         // call the encode as plaintext and pass plaintext as parameter
         plaintext = encodeAsPlaintext(plaintext);
        // use for loops to check the length 
    	for(int i = 0; i < plaintext.length(); i++){

             // decalre a variable called posOfCharacter to get the index of the alphapet text
    		int posOfCharacter = ALPHABET.indexOf(plaintext.charAt(i));
            // calculation for the encryption
            int calculation =  (shiftKey + posOfCharacter) % 26;

            // declare a char variable to replace the letter of Alphabet.charAt calculation 
            char replace = ALPHABET.charAt(calculation);
            ciphertext += replace;

    		} 
            // return the String encode As ciphertext 
             return encodeAsCiphertext(ciphertext);
	}
     
     /**
     * This method check the length and get the position for character and
     * and make the calculation for decryption
     *@param ciphertext
     *@param shiftKey
     *@return plaintext
     */
	public static String decrypt(String ciphertext, int shiftKey){
       // call the encode as plain text and pass cipher text as a prameter
       ciphertext = encodeAsPlaintext(ciphertext);
       // create  a string plaintext
       String plaintext = "";
      
        // for loops to make it check the length of the word
        for(int i = 0; i < ciphertext.length(); i++){
            // decalre a variable to get the index of the alphapet text
            
            int posOfCharacter = ALPHABET.indexOf(ciphertext.charAt(i));

            // the caluclation for the decryption
            int calculation = (posOfCharacter - shiftKey) % 26;
                    
        // if the calculation is in negative add 26 to it.
            if (calculation < 0 ){
                calculation = ((posOfCharacter - shiftKey) + 26) % 26;
            } 

            

        // declare the replace variable to get the alphabet.charAt calculation 
        char replace = ALPHABET.charAt(calculation);
        plaintext += replace;
              	
        }
        
         // return the plaintext 
            return plaintext;
    }	

     /**
     * This method convert the message to lower case letters 
     * remove all the spaces 
     * convert the message to all lower Case
     *@param message
     *@return message
     */
    private static String encodeAsPlaintext(String message) {
        
             // convert message to lower Case letters 
             message = message.toLowerCase();
             // use the replace all method to remove all the spaces 
             message = message.replaceAll("\\s", "");
             
             return message;
    }
     /**
     *this method convert it to all upper case letters 
     * checke the lenght and add space every 4 letters
     *@param message
     *@return finalText
     */
    private static String encodeAsCiphertext(String message) {
        // create a new variable called final text 
        // to add the space every 4 char using this variable
        String finalText = " ";
        // convert it to upper case letters 
        message = message.toUpperCase();
        // use for loops to check the lenght of the word 
        for(int i = 0; i < message.length(); i ++){

             // use if statement to make sure if it is divisible by 4 and equal to zero 
            // make a space every 4 characters.
            if(i % 4 ==0 ){
                finalText = finalText + " ";
            }  
                finalText = finalText + message.charAt(i);
        }
             return finalText;
    }

}