import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Application Entry & Welcome Message
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

        // UC5: Stack-Based Palindrome Checker (User Input)
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a word to check palindrome (UC5): ");
        String input = scanner.nextLine();

        // Push characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Pop characters and build reversed string
        String reversedInput = "";
        while (!stack.isEmpty()) {
            reversedInput = reversedInput + stack.pop();
        }

        if (input.equals(reversedInput)) {
            System.out.println(input + " is a Palindrome (UC5)");
        } else {
            System.out.println(input + " is NOT a Palindrome (UC5)");
        }

        scanner.close();
        // UC6: Queue + Stack Based Palindrome Check
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        System.out.print("Enter a word to check palindrome (UC6): ");
        String input6 = scanner.nextLine();

        // Add characters to queue and stack
        for (int i = 0; i < input6.length(); i++) {
            char ch = input6.charAt(i);
            queue.add(ch);
            stackUC6.push(ch);
        }

        // Compare queue (FIFO) with stack (LIFO)
        boolean isPalindromeUC6 = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stackUC6.pop()) {
                isPalindromeUC6 = false;
                break;
            }
        }

        if (isPalindromeUC6) {
            System.out.println(input6 + " is a Palindrome (UC6)");
        } else {
            System.out.println(input6 + " is NOT a Palindrome (UC6)");
        }
        // UC7: Deque-Based Palindrome Checker
        Deque<Character> deque = new ArrayDeque<>();

        System.out.print("Enter a word to check palindrome (UC7): ");
        String input7 = scanner.nextLine();

// Insert characters into deque
        for (int i = 0; i < input7.length(); i++) {
            deque.addLast(input7.charAt(i));
        }

        boolean isPalindromeUC7 = true;

// Compare front and rear characters
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindromeUC7 = false;
                break;
            }
        }

        if (isPalindromeUC7) {
            System.out.println(input7 + " is a Palindrome (UC7)");
        } else {
            System.out.println(input7 + " is NOT a Palindrome (UC7)");
        }
    }
}