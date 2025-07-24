package Arrays;

import java.util.Scanner;

public class SortArray012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of array: ");
        size = input.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("The Array after sorted as 0s , 1s and 2s: " + sort012(arr));

        input.close();
    }

    public static int[] sort012(int[] arr) {
        
        int count_0 = 0 , count_1  = 0 , i;
        
        for (i = 0 ; i < arr.length ; i++){
            if (arr[i] == 0){
                count_0++;
            }
            else if(arr[i] == 1){
                count_1++;
            }
        }
        
        i = 0;
        while (i < count_0){
            arr[i] = 0;
            i++;
        }
        int j = i;
        while (i < j+count_1){
            arr[i] = 1;
            i++;
        }
        while (i < arr.length){
            arr[i] = 2;
            i++;
        }

        return arr;
    }


    //using dutch national flag algorithm
    // public void sort012(int[] arr) {
    //     int low = 0, mid = 0, high = arr.length - 1;
    
    //     while (mid <= high) {
    //         switch (arr[mid]) {
    //             case 0:
    //                 // swap arr[low] and arr[mid]
    //                 int temp0 = arr[low];
    //                 arr[low++] = arr[mid];
    //                 arr[mid++] = temp0;
    //                 break;
    
    //             case 1:
    //                 mid++;
    //                 break;
    
    //             case 2:
    //                 // swap arr[mid] and arr[high]
    //                 int temp2 = arr[mid];
    //                 arr[mid] = arr[high];
    //                 arr[high--] = temp2;
    //                 break;
    //         }
    //     }
    // }

    //low for tracking the end of 0s , mid for pointing the current element to be checked and high for tracking the start of 2s.
}

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?
// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 2

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

//url : https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?page=1