import java.util.*;

class Solution {
    
    // Function to arrange numbers to form the largest possible number
    public String largestNumber(int[] nums) {
        // Step 1: Convert each number in the array to a string
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort the array with custom comparator
        // If concatenating b + a is larger than a + b, we place b first
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: If the largest number is "0", then all numbers are zeroes
        if (array[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the largest number by appending sorted strings
        StringBuilder largest = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            largest.append(array[i]);
        }

        // Return the result as a string
        return largest.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        // Step 5: Take the size of the array as input from the user
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Step 6: Take the list of numbers as input from the user
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Step 7: Call the largestNumber function and display the result
        String result = solution.largestNumber(nums);
        System.out.println("Largest number formed: " + result);
    }
}
