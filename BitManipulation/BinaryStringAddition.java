package BitManipulation;

import java.util.Scanner;

public class BinaryStringAddition {
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the String a: ");
        String a = input.next();

        System.out.println("Enter the String b: ");
        String b = input.next();


        System.out.println("The Result of adding the binary strings: " + addString(a, b));
        input.close();

    }

    public static String addString(String a , String b){

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i>=0)? a.charAt(i) - '0' : 0;
            int bitB = (j >=0)? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + carry;

            result.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        
        }

        return String.valueOf(result.reverse());
    }
}


// Given two binary strings a and b, return their sum as a binary string. 

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"
 

// Constraints:

// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.

//url: https://leetcode.com/problems/add-binary/