public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker App");
        System.out.println(" Version: 1.0");
        System.out.println("=================================");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";
        if (word.equals("madam")) {
            System.out.println(word + " is a Palindrome (UC2)");
        } else {
            System.out.println(word + " is NOT a Palindrome (UC2)");
        }

        // UC3: Palindrome using String Reverse
        String word3 = "madam";
        String reverse = "";

        for (int i = word3.length() - 1; i >= 0; i--) {
            reverse = reverse + word3.charAt(i);
        }

        if (word3.equals(reverse)) {
            System.out.println(word3 + " is a Palindrome (UC3)");
        } else {
            System.out.println(word3 + " is NOT a Palindrome (UC3)");
        }

        // UC4: Palindrome using Character Array and Two Pointers
        String word4 = "madam";
        char[] chars = word4.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(word4 + " is a Palindrome (UC4)");
        } else {
            System.out.println(word4 + " is NOT a Palindrome (UC4)");
        }
    }
}