# PalindromeCheckerApp
Palindrome Checker App

Objective:
To build a console-based Java application to check palindromes.

Use Case 1 (UC1): Application Entry & Welcome Message
- Displays application name and version
## Use Case 2 (UC2): Hardcoded Palindrome Check
- Checks a hardcoded string
- Prints whether it is a palindrome using conditional statements
## Use Case 3 (UC3): Palindrome using String Reverse
- Reverse string using for loop
- Compare original and reversed string
## Use Case 4 (UC4): Palindrome using Character Array

- Converts string to character array
- Uses two-pointer technique
- Compares characters from start and end
## Use Case 5 (UC5): Stack-Based Palindrome Checker

- Accepts input from the user
- Pushes each character into a stack (LIFO)
- Pops characters to form the reversed string
- Compares original and reversed strings
- Displays whether the input is a palindrome
## Use Case 6 (UC6): Queue + Stack Based Palindrome Check

- Inserts characters into both a Queue (FIFO) and a Stack (LIFO)
- Dequeues from queue and pops from stack
- Compares both outputs to determine palindrome
## Use Case 7 (UC7): Deque-Based Palindrome Checker

- Uses a Deque (Double Ended Queue)
- Inserts characters into the deque
- Removes characters from front and rear
- Compares them to check if the word is a palindrome
## Use Case 8 (UC8): Linked List Based Palindrome Checker

- Converts the input string into a singly linked list
- Uses fast and slow pointer technique to find the middle
- Reverses the second half of the linked list
- Compares both halves to determine palindrome
## Use Case 9 (UC9): Recursive Palindrome Checker

- Uses recursion to compare characters from start and end
- Base condition stops recursion when indexes cross
- Demonstrates the use of the call stack
## Use Case 10 (UC10): Case-Insensitive & Space-Ignored Palindrome

- Removes spaces using regular expressions
- Converts the string to lowercase
- Compares characters from both ends
- Determines if the sentence is a palindrome