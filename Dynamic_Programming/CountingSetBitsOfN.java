package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSetBitsOfN {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = input.nextInt();
    
        System.out.println("The number of set bits of n elements are: "+ Arrays.toString(countSetBits(n)));
    
        input.close();
    }
    
    //Using dynamic programming (Bottom-Up approach)
    public static int[] countSetBits(int n){

        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);

        int sum = 1;
        for (int i = 1 ; i <= n ; i++){
            if (sum * 2 == i){
                sum = i;
            }
            dp[i] = dp[i - sum] + 1;
        }

        return dp;
    }

}


// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
// ans[i] is the number of 1's in the binary representation of i.

// Example 1:
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// Example 2:

// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
 
// Constraints:
// 0 <= n <= 105

//url : https://leetcode.com/problems/counting-bits


// 💡 Core Idea:
// We use the fact that:

// Copy
// Edit
// dp[i] = dp[i - highest power of 2 ≤ i] + 1
// The intuition is:

// If you remove the most significant bit (MSB) from i, you're left with a smaller number whose set bits count we already know.

// So, we add 1 (for the MSB) to that previously solved subproblem.

// 🔁 Walkthrough of Code:

// int dp[] = new int[n+1];
// Arrays.fill(dp, 0);
// Create an array dp to store the number of set bits for numbers 0 to n.

// Initialize all values to 0.

// int sum = 1;
// sum will store the current power of 2, like 1, 2, 4, 8, etc.

// for (int i = 1 ; i <= n ; i++){
//     if (sum * 2 == i){
//         sum = i;
//     }
//     dp[i] = dp[i - sum] + 1;
// }

// Let's break this down:
// if (sum * 2 == i):
// This checks if i is a new power of 2. If yes, update sum to this new power.

// E.g., when i = 4, sum = 2 → sum*2 == 4 → update sum = 4

// dp[i] = dp[i - sum] + 1:

// i - sum removes the MSB.

// So we add 1 (for that MSB) to the bit count of i - sum.

// 🧠 Example: Trace countSetBits(10)
// i	Binary	sum	    i - sum	    dp[i - sum]	dp[i]
// 0	0000    -	    -	        -	        0
// 1	0001    1	    0	        0	        1
// 2	0010    2	    0	        0	        1
// 3	0011    2	    1	        1	        2
// 4	0100    4	    0	        0	        1
// 5	0101    4	    1	        1	        2
// 6	0110    4	    2	        1	        2
// 7	0111    4	    3	        2	        3
// 8	1000	8	    0	        0	        1
// 9	1001	8	    1	        1	        2
// 10	1010	8	    2	        1	        2

// 🔍 Time & Space Complexity:
// Time: O(n)

// Space: O(n) (for storing dp array)

// 🧠 Intuition Recap:
// Binary numbers have regular patterns due to powers of 2.
// For each number i, we reduce the problem to i - highest_power_of_2 ≤ i.
// This way, we reuse already computed results — the essence of Dynamic Programming.