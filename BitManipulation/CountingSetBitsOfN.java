package BitManipulation;

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

    //Using brute force approach
    // public static int[] countSetBits(int n){
    //     int count[] = new int[n+1];
    //     for (int i = 0 ; i <= n ; i++){
    //         int sum = 0;
    //         int j = i;
    //         while (j != 0){
    //             sum += j & 1;
    //             j >>= 1;
    //         }
    //         count[i] = sum;
    //     }
    //     return count;
    // }
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