package Strings;

import java.util.Scanner;

public class LongestCommonPrefix {
    
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        String arr[] = new String[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.next();
        }

        System.out.println("The Longest Prefix present in the array: " + findLongestPrefix(arr));

        input.close();
    }

    public static String findLongestPrefix(String arr[]){

        String first = arr[0];

        for (int i = 0 ; i < first.length() ; i++){
            for (int j = 1 ; j < arr.length ; j++){
                if (arr[j].length() <= i || arr[j].charAt(i) != first.charAt(i)){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}

// Given an array of strings arr[]. Return the longest common prefix among each and every strings present in the array. If there's no prefix common in all the strings, return "".

// Examples :
// Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
// Output: "gee"
// Explanation: "gee" is the longest common prefix in all the given strings.

// Input: arr[] = ["hello", "world"]
// Output: ""
// Explanation: There's no common prefix in the given strings.

// Constraints:
// 1 ≤ |arr| ≤ 103
// 1 ≤ |arr[i]| ≤ 103

// Expected Complexities
// Time Complexity: O(n*min(|arri|))
// Auxiliary Space: O(min(|arri|))

// To solve the Longest Common Prefix (LCP) problem efficiently, we’ll:

// Approach (Vertical Scanning):
// Start by taking the first string in the array as a reference.
// Check each character one by one column-wise across all strings.
// As soon as a mismatch is found (or a string ends), return the prefix found so far.

// Time Complexity:
// O(n * m) where:
// n = number of strings
// m = length of the shortest string (since that’s the max possible prefix length)

// Space Complexity:
// O(m) for the prefix result (if stored), but technically O(1) auxiliary space if returned directly as a substring.