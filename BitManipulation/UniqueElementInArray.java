package BitManipulation;

import java.util.Scanner;

public class UniqueElementInArray {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("the unique element is: " + findUnique(arr));
        input.close();
    }

    // public static int findUnique(int arr[]){

        
    //     int sum = 0 , result=0;

    //     for (int i = 0 ; i < 32 ; i++){
    //         sum = 0;
            
    //         for (int num : arr){
    //             if (((num>>i) & 1) == 1){
    //                 sum++;
    //             }
    //         }

    //         if (sum% 3 != 0){
    //             result |= 1<<i;
    //         }
    //     }

    //     if ((result & (1<<31)) != 0){
    //         result -= (1L<<32);
    //     }

    //     return result;
    // }

    //using bit masking
    public static int findUnique(int arr[]){
        int ones = 0, twos = 0;

        for (int num : arr) {
            // First appearance:
            //   add num to ones if it's not there in twos
            // Second appearance:
            //   remove from ones and add to twos
            // Third appearance:
            //   remove from both ones and twos

            twos |= ones & num;     // add to 'twos' the bits already in 'ones' and 'num'
            ones ^= num;            // toggle bits in 'ones' using XOR
            int common = ones & twos;  // bits that occurred three times
            ones &= ~common;        // remove common bits from both
            twos &= ~common;
        }
        return ones;
    }
}
