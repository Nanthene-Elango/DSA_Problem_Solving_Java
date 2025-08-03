package Array;

import java.util.Scanner;

public class EquilibiriumPoint {
 
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        System.out.println("Enter the value of array: ");
        int a[] = new int[size];

        for (int i = 0 ; i < size ; i++){
            a[i] = input.nextInt();
        }

        System.out.println("The Equilibirium point is: " + findEquilibiriumPoint(a));
        input.close();
    }

    public static int findEquilibiriumPoint(int arr[]){
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}

// Given an array of integers arr[], the task is to find the first equilibrium point in the array.

// The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 

// Examples:

// Input: arr[] = [1, 2, 0, 3]
// Output: 2 
// Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.
// Input: arr[] = [1, 1, 1, 1]
// Output: -1
// Explanation: There is no equilibrium index in the array.
// Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
// Output: 3
// Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.
// Constraints:
// 3 <= arr.size() <= 105
// -104 <= arr[i] <= 104

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

//url: https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1

//Algorithm Approach
// 1)Compute the total sum of the array.
// 2)Traverse the array while maintaining a leftSum.
// 3)At each index i, subtract arr[i] from the total sum to get the right sum.
// 4)If leftSum == rightSum, return the current index.
// 5)Otherwise, add arr[i] to leftSum and continue.
// 6)If no such index is found, return -1.