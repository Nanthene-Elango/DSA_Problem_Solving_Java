package BitManipulation;

import java.util.Scanner;

public class AlternateBits {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = input.nextInt();

        System.out.println("Is the number has alternate bits: " + isBitsAlternate(n));
        input.close();
    }

    public static boolean isBitsAlternate(int n){
        int x = n ^ (n >> 1);     
        return (x & (x + 1)) == 0;
    }
}

//if the bit is alternative, shifting one bit to the right and xor with n will make all bits 1
// n       = 101 (5)
// n >> 1  = 010 (4)
// n ^ (n >> 1) = 111 (7)  ← All bits become 1!

//to check that all bits are 1, doing AND between x and x+1 will make all bits 0
//x+1 = 111 + 1 = 1000(8)
//x & x+1 = 0111 & 1000 = 0000

// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

// Example 1:

// Input: n = 5
// Output: true
// Explanation: The binary representation of 5 is: 101
// Example 2:

// Input: n = 7
// Output: false
// Explanation: The binary representation of 7 is: 111.
// Example 3:

// Input: n = 11
// Output: false
// Explanation: The binary representation of 11 is: 1011.
 
// Constraints:
// 1 <= n <= 231 - 1