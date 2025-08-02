package BitManipulation;

import java.util.Scanner;

public class HammingDistance {
    
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of x: ");
        int x = input.nextInt();

        System.out.println("Enter the value of y: ");
        int y = input.nextInt();

        int distance = 0;
        int z = x ^ y;  //set the bits that are different , clearing the bits that are same

        while (z != 0){
            distance += z & 1;
            z >>= 1;
        }

        //distance = Integer.bitCount(z);

        System.out.println("The number of bits that are different in x and y are: " + distance);

        input.close();
    }
}

// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Given two integers x and y, return the Hamming distance between them.

 

// Example 1:

// Input: x = 1, y = 4
// Output: 2
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑
// The above arrows point to positions where the corresponding bits are different.
// Example 2:

// Input: x = 3, y = 1
// Output: 1

// Constraints:
// 0 <= x, y <= 231 - 1

//url: https://leetcode.com/problems/hamming-distance/