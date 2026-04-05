import java.util.Scanner;

public class VowelDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Searching for vowels (displaying with 3s delay)...");

        // Convert string to lowercase to handle both 'A' and 'a'
        String lowerInput = input.toLowerCase();

        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);

            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                try {
                    // Pause the execution for 3000 milliseconds (3 seconds)
                    Thread.sleep(3000);
                    
                    // Display the original character from the input string
                    System.out.println("Found Vowel: " + input.charAt(i));
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted!");
                }
            }
        }
        
        System.out.println("Finished processing string.");
        sc.close();
    }
}