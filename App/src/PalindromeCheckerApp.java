import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        // UC5: Stack-Based Palindrome Checker
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a word to check palindrome (UC5): ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversedInput = "";

        while (!stack.isEmpty()) {
            reversedInput = reversedInput + stack.pop();
        }

        if (input.equals(reversedInput)) {
            System.out.println(input + " is a Palindrome (UC5)");
        } else {
            System.out.println(input + " is NOT a Palindrome (UC5)");
        }

        // UC6: Queue + Stack Based Palindrome Check
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        System.out.print("Enter a word to check palindrome (UC6): ");
        String input6 = scanner.nextLine();

        for (int i = 0; i < input6.length(); i++) {
            char ch = input6.charAt(i);
            queue.add(ch);
            stackUC6.push(ch);
        }

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

        for (int i = 0; i < input7.length(); i++) {
            deque.addLast(input7.charAt(i));
        }

        boolean isPalindromeUC7 = true;

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

        // UC8: Linked List Based Palindrome Checker
        System.out.print("Enter a word to check palindrome (UC8): ");
        String input8 = scanner.nextLine();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < input8.length(); i++) {
            Node newNode = new Node(input8.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node first = head;
        Node second = prev;

        boolean isPalindromeUC8 = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindromeUC8 = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        if (isPalindromeUC8) {
            System.out.println(input8 + " is a Palindrome (UC8)");
        } else {
            System.out.println(input8 + " is NOT a Palindrome (UC8)");
        }

        // UC9: Recursive Palindrome Checker
        System.out.print("Enter a word to check palindrome (UC9): ");
        String input9 = scanner.nextLine();

        boolean resultUC9 = isPalindromeRecursive(input9, 0, input9.length() - 1);

        if (resultUC9) {
            System.out.println(input9 + " is a Palindrome (UC9)");
        } else {
            System.out.println(input9 + " is NOT a Palindrome (UC9)");
        }

        // UC10: Case-Insensitive & Space-Ignored Palindrome
        System.out.print("Enter a sentence to check palindrome (UC10): ");
        String input10 = scanner.nextLine();

        String normalized = input10.replaceAll("\\s+", "").toLowerCase();

        int left10 = 0;
        int right10 = normalized.length() - 1;
        boolean isPalindromeUC10 = true;

        while (left10 < right10) {
            if (normalized.charAt(left10) != normalized.charAt(right10)) {
                isPalindromeUC10 = false;
                break;
            }
            left10++;
            right10--;
        }

        if (isPalindromeUC10) {
            System.out.println(input10 + " is a Palindrome (UC10)");
        } else {
            System.out.println(input10 + " is NOT a Palindrome (UC10)");
        }

        scanner.close();
    }

    // Node class for UC8
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC9 Recursive Method
    static boolean isPalindromeRecursive(String str, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}