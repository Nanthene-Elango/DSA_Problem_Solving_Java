package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindDuplicates {
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

        System.out.print("The Duplicate Elements in the Array are: " + findDuplicates(arr));

        input.close();
    }

    // bruteforce approach
    // public static ArrayList<Integer> findDuplicates(int[] arr) {
    // // code here
    // ArrayList<Integer> duplicates = new ArrayList<>();

    // for (int i = 0 ; i < arr.length ; i++){
    // if (!duplicates.contains(arr[i])){
    // for (int j = i+1 ; j < arr.length ; j++){
    // if (arr[i] == arr[j]){
    // duplicates.add(arr[i]);
    // break;
    // }
    // }
    // }
    // }

    // return duplicates;
    // }

    // optimized using hashset
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }
}

// Input: arr[] = [2, 3, 1, 2, 3]
// Output: [2, 3] 
// Explanation: 2 and 3 occur more than once in the given array.
// Input: arr[] = [3, 1, 2] 
// Output: []
// Explanation: There is no repeating element in the array, so the output is empty.
//url : https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/1