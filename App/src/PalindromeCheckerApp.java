import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // UC1: Welcome
        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker App");
        System.out.println(" Version: 1.0");
        System.out.println("=================================");

        // UC2
        String word = "madam";
        if (word.equals("madam")) {
            System.out.println(word + " is a Palindrome (UC2)");
        }

        // UC3 Reverse String
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        System.out.println(word.equals(reverse) ? "Palindrome (UC3)" : "Not Palindrome (UC3)");

        // UC4 Two Pointer
        int left = 0;
        int right = word.length() - 1;
        boolean result4 = true;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                result4 = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(result4 ? "Palindrome (UC4)" : "Not Palindrome (UC4)");

        // UC5 Stack
        System.out.print("Enter word (UC5): ");
        String input5 = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : input5.toCharArray()) stack.push(c);

        String reversed = "";

        while (!stack.isEmpty()) reversed += stack.pop();

        System.out.println(input5.equals(reversed) ? "Palindrome (UC5)" : "Not Palindrome (UC5)");

        // UC6 Queue + Stack
        System.out.print("Enter word (UC6): ");
        String input6 = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack6 = new Stack<>();

        for (char c : input6.toCharArray()) {
            queue.add(c);
            stack6.push(c);
        }

        boolean result6 = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack6.pop()) {
                result6 = false;
                break;
            }
        }

        System.out.println(result6 ? "Palindrome (UC6)" : "Not Palindrome (UC6)");

        // UC7 Deque
        System.out.print("Enter word (UC7): ");
        String input7 = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input7.toCharArray()) deque.addLast(c);

        boolean result7 = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                result7 = false;
                break;
            }
        }

        System.out.println(result7 ? "Palindrome (UC7)" : "Not Palindrome (UC7)");

        // UC8 Linked List
        System.out.print("Enter word (UC8): ");
        String input8 = scanner.nextLine();

        Node head = null;
        Node tail = null;

        for (char c : input8.toCharArray()) {
            Node node = new Node(c);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
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

        boolean result8 = true;

        while (second != null) {
            if (first.data != second.data) {
                result8 = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        System.out.println(result8 ? "Palindrome (UC8)" : "Not Palindrome (UC8)");

        // UC9 Recursion
        System.out.print("Enter word (UC9): ");
        String input9 = scanner.nextLine();

        boolean result9 = isPalindromeRecursive(input9,0,input9.length()-1);

        System.out.println(result9 ? "Palindrome (UC9)" : "Not Palindrome (UC9)");

        // UC10 Ignore Case & Spaces
        System.out.print("Enter sentence (UC10): ");
        String input10 = scanner.nextLine();

        String normalized = input10.replaceAll("\\s+","").toLowerCase();

        boolean result10 = isPalindromeRecursive(normalized,0,normalized.length()-1);

        System.out.println(result10 ? "Palindrome (UC10)" : "Not Palindrome (UC10)");

        // UC11 OOP Service
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter word (UC11): ");
        String input11 = scanner.nextLine();

        System.out.println(checker.checkPalindrome(input11)
                ? "Palindrome (UC11)"
                : "Not Palindrome (UC11)");

        // UC12 Strategy Pattern
        System.out.print("Enter word (UC12): ");
        String input12 = scanner.nextLine();

        System.out.println("Choose Strategy 1.Stack 2.Deque");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if(choice==1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        System.out.println(strategy.isPalindrome(input12)
                ? "Palindrome (UC12)"
                : "Not Palindrome (UC12)");

        // UC13 Performance Comparison
        System.out.print("Enter word for performance test (UC13): ");
        scanner.nextLine();
        String input13 = scanner.nextLine();

        long start1 = System.nanoTime();
        boolean r1 = isPalindromeRecursive(input13,0,input13.length()-1);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = checker.checkPalindrome(input13);
        long end2 = System.nanoTime();

        System.out.println("Recursive Result: "+r1);
        System.out.println("Recursive Time: "+(end1-start1)+" ns");

        System.out.println("Two Pointer Result: "+r2);
        System.out.println("Two Pointer Time: "+(end2-start2)+" ns");

        scanner.close();
    }

    static boolean isPalindromeRecursive(String str,int left,int right){

        if(left>=right) return true;

        if(str.charAt(left)!=str.charAt(right)) return false;

        return isPalindromeRecursive(str,left+1,right-1);
    }

    static class Node{
        char data;
        Node next;

        Node(char data){
            this.data=data;
        }
    }
}

class PalindromeChecker{

    public boolean checkPalindrome(String input){

        int left=0;
        int right=input.length()-1;

        while(left<right){

            if(input.charAt(left)!=input.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}

interface PalindromeStrategy{
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy{

    public boolean isPalindrome(String input){

        Stack<Character> stack=new Stack<>();

        for(char c:input.toCharArray())
            stack.push(c);

        for(char c:input.toCharArray())
            if(c!=stack.pop())
                return false;

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy{

    public boolean isPalindrome(String input){

        Deque<Character> deque=new ArrayDeque<>();

        for(char c:input.toCharArray())
            deque.addLast(c);

        while(deque.size()>1)
            if(deque.removeFirst()!=deque.removeLast())
                return false;

        return true;
    }
}