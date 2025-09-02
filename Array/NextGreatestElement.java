package Array;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreatestElement {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements: ");
        for (int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }

        rearrangeWithNextGreatestNumber(arr);
        System.out.println("Array after rearranging with next greatest number: " + Arrays.toString(arr));
        input.close();
    }


    //Time Complexity: O(n)
    public static void rearrangeWithNextGreatestNumber(int arr[]){

        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for (int i = arr.length-2 ; i>=0 ; i--){
            arr[i] = max;
            if (arr[i] > max){
                max = arr[i];
            }
        }
    }

    //Time Complexity: O(n^2)
    // public static void rearrangeWithNextGreatestNumber(int[] arr){

    //     for (int i = 0 ; i < arr.length-1 ; i++){
    //         int max = arr[i+1];
    //         for (int j = i+2 ; j < arr.length ; j++){
    //             if (arr[j] > max){
    //                 max = arr[j];
    //             }
    //         }
    //         arr[i] = max;
    //     }
    //     arr[arr.length-1] = -1;
    // }
}


//Example:

//I/P: 5  3  8  2  10 1

//O/P: 10 10 10 10 1 -1