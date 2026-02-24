public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker App");
        System.out.println(" Version: 1.0");
        System.out.println("=================================");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";

        if (word.equals("madam")) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}