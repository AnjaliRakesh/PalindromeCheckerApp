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
    // UC3: Palindrome using String Reverse
    String word = "madam";
    String reverse = "";

for (int i = word.length() - 1; i >= 0; i--) {
        reverse = reverse + word.charAt(i);
    }

if (word.equals(reverse)) {
        System.out.println(word + " is a Palindrome (UC3)");
    } else {
        System.out.println(word + " is NOT a Palindrome (UC3)");
    }
}