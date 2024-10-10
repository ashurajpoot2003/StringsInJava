import java.util.Scanner;
import java.util.Stack;

public class Solution {

    // Function to find the length of the longest valid parentheses substring
    public int longestValidParentheses(String s) {
        // Stack to keep track of indices of '(' characters
        Stack<Integer> stack = new Stack<Integer>();
        
        // Variable to store the maximum length of valid parentheses
        int max = 0;
        
        // Left index initialized to -1 to handle the case when a ')' has no matching '('
        int left = -1;
        
        // Traverse the string character by character
        for (int j = 0; j < s.length(); j++) {
            // If the current character is '(', push its index to the stack
            if (s.charAt(j) == '(') {
                stack.push(j);
            } 
            // If the current character is ')'
            else {
                // If the stack is empty, set the left pointer to the current index
                if (stack.isEmpty()) {
                    left = j;
                } 
                // If the stack is not empty, pop the top of the stack
                else {
                    stack.pop();
                    
                    // If the stack becomes empty, calculate the valid parentheses length
                    // from the left pointer to the current index
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } 
                    // If the stack is not empty, calculate the valid parentheses length
                    // from the top of the stack to the current index
                    else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        
        // Return the maximum length of valid parentheses found
        return max;
    }

    public static void main(String[] args) {
        // Create an instance of the solution class
        Solution solution = new Solution();
        
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a string containing parentheses
        System.out.print("Enter a string containing only '(' and ')': ");
        String input = scanner.nextLine();
        
        // Call the longestValidParentheses function and store the result
        int result = solution.longestValidParentheses(input);
        
        // Output the result
        System.out.println("The length of the longest valid parentheses substring is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}
