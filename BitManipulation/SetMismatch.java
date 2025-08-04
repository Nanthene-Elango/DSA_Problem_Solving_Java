package BitManipulation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMismatch {
 
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of array: ");
        size = input.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("The Duplicate Element and missing element in the Array are: " + findDuplicateAndMissing(arr));

        input.close();

    }


    //using Bitwise XOR operator
    public static int[] findDuplicateAndMissing(int nums[]){
        int xor = 0;
        int n = nums.length;

        // Step 1: XOR all numbers in nums and 1 to n
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // xor = duplicate ^ missing
        // Step 2: Get rightmost set bit (to differentiate the two numbers)
        int diffBit = xor & -xor;

        int xor1 = 0, xor2 = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0)
                xor1 ^= num;
            else
                xor2 ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & diffBit) != 0)
                xor1 ^= i;
            else
                xor2 ^= i;
        }

        // Step 3: Determine which is duplicate and which is missing
        for (int num : nums) {
            if (num == xor1) {
                return new int[]{xor1, xor2}; // xor1 = duplicate, xor2 = missing
            }
        }
        return new int[]{xor2, xor1}; 
    }

    //using hashset
    // public static int[] findDuplicateAndMissing(int nums[]){
    //     int n = nums.length;
    //     int sum = 0, actualSum = n * (n + 1) / 2;
    //     Set<Integer> set = new HashSet<>();
    //     int duplicate = 0;

    //     for (int num : nums) {
    //         if (!set.add(num)) {
    //             duplicate = num;
    //         }
    //         sum += num;
    //     }

    //     int missing = actualSum - (sum - duplicate);
    //     return new int[]{duplicate, missing};
    // }
}

// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

// Example 1:

// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1]
// Output: [1,2]
 

// Constraints:

// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104

//url : https://leetcode.com/problems/set-mismatch/