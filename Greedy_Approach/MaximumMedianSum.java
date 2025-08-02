package Greedy_Approach;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumMedianSum {
    
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("The Maximum Median: " + findMaxMedian(arr));
        input.close();
    }

    public static long findMaxMedian(int nums[]){

        Arrays.sort(nums);
        long median = 0;
        int n = nums.length;
        for (int i = n - 2, count = 0; count < n / 3; i -= 2, count++) {
            median += nums[i];
        }
        return median;
    }
}


// You are given an integer array nums with a length divisible by 3.

// You want to make the array empty in steps. In each step, you can select any three elements from the array, compute their median, and remove the selected elements from the array.

// The median of an odd-length sequence is defined as the middle element of the sequence when it is sorted in non-decreasing order.

// Return the maximum possible sum of the medians computed from the selected elements.

// Example 1:

// Input: nums = [2,1,3,2,1,3]

// Output: 5

// Explanation:

// In the first step, select elements at indices 2, 4, and 5, which have a median 3. After removing these elements, nums becomes [2, 1, 2].
// In the second step, select elements at indices 0, 1, and 2, which have a median 2. After removing these elements, nums becomes empty.
// Hence, the sum of the medians is 3 + 2 = 5.

// Example 2:

// Input: nums = [1,1,10,10,10,10]

// Output: 20

// Explanation:

// In the first step, select elements at indices 0, 2, and 3, which have a median 10. After removing these elements, nums becomes [1, 10, 10].
// In the second step, select elements at indices 0, 1, and 2, which have a median 10. After removing these elements, nums becomes empty.
// Hence, the sum of the medians is 10 + 10 = 20.

// Constraints:

// 1 <= nums.length <= 5 * 105
// nums.length % 3 == 0
// 1 <= nums[i] <= 109

//Approach
// In each step, we:

// Pick 3 numbers from the array.

// Sort the triplet.

// Remove them.

// Add the median (middle value) to our total sum.

// To maximize the sum of medians, we want to:
// maximize each median picked.

// Greedy Strategy:
// If we sort the array in non-decreasing order, the most optimal approach is:

// From the sorted array, always choose the largest possible medians.

// Here’s how:

// For an array of length n, we will make n / 3 triplets.

// If we sort the array, the median of each optimal triplet (from a sum-maximization perspective) should be from the second third of the sorted array.

// Why?
// Think of it like this:

// We need to form n/3 triplets.

// We can model the triplets as:

// (smallest, middle, largest) → median is the middle.

// To maximize the total, we should try to place largest elements as medians (not as smallest or largest of a triplet).

// The best we can do is use the top n/3 values as medians.

// Hence, we pick the second element from each triplet when going right to left from the sorted array.
// Time and Space Complexity:
// Time: O(n log n) due to sorting

// Space: O(1) (ignoring sort space)

//url: https://leetcode.com/contest/weekly-contest-460/problems/maximum-median-sum-of-subsequences-of-size-3/