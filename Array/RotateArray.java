package Array;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of array: ");
        size = input.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int d;
        System.out.println("Enter the times to rotate the array: ");
        d = input.nextInt();

        System.out.print("The Array after Rotated d times: " + Arrays.toString(rotate(arr , d)));

        input.close();
    }

    public static int[] rotate(int arr[] , int d){
        int n = arr.length;
        
        d = d % n;
        
        reverse(arr , 0 , d-1);
        
        reverse(arr , d , n-1);
        
        reverse(arr , 0 , n-1);

        return arr;
    }
    
    static void reverse(int[] arr , int start , int end){
        
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
}

// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.

// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
// Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.

// Input: arr[] = [7, 3, 9, 1], d = 9
// Output: [3, 9, 1, 7]
// Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.

// Constraints:
// 1 <= arr.size(), d <= 105
// 0 <= arr[i] <= 105

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

//url : https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/rotate-array-by-n-elements-1587115621
