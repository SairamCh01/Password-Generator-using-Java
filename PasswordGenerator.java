import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator{

    // Define Charactor sets for the password
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTVUWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstvuwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTORS = "@#$%^&*(_+{}}'/?><,.')";

    // SecureRandom is more secure than Radom
    private static final SecureRandom random = new SecureRandom();

    /**
     * @param length
     * @param useUpper
     * @param useLower
     * @param useNumbers
     * @param useSpecial
     * @return
     */

    // Method to generate a password
    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useNumbers, boolean useSpecial){
        
        StringBuilder password = new StringBuilder(length);
        String characterPool ="";

        // Add character sets to the pool based on user preferences

        if(useUpper){
            characterPool = characterPool + UPPERCASE_LETTERS;
        }
        if(useLower){
            characterPool = characterPool + LOWERCASE_LETTERS;
        }
        if(useNumbers){
            characterPool = characterPool + NUMBERS;
        }
        if(useSpecial){
            characterPool = characterPool + SPECIAL_CHARACTORS;
        }
        if(characterPool.isEmpty()){
            throw new IllegalArgumentException("At least one character set must be selected.");
        }
        
        // Generate the password by randomly selecting characters from the pool

        for(int i=0;i<length;i++){
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }
    
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Get password length form
        System.out.println("Enter the desired password length");
        int length = sc.nextInt();

        // Ask the user what types of characters they want to include
        System.out.println("Include uppercase letters ? (true/false):");
        boolean useUpper = sc.nextBoolean();

        System.out.println("Include lowercase letters ? (true/false):");
        boolean useLower = sc.nextBoolean();

        System.out.println("Include numbers ? (true/false):");
        boolean useNumbers = sc.nextBoolean();

        System.out.println("Include special charactors ? (true/false):");
        boolean useSpecial = sc.nextBoolean();

        // Generate and Display the password
        try{
            String password = generatePassword(length, useUpper, useLower, useNumbers, useSpecial);
            System.out.println("Generated Password : " + password);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    
    sc.close();
    }
}