package Nuchange_Problems;
import java.util.Arrays;
import java.util.Scanner;

public class Program3 {
 
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = input.nextInt();

        int arr[] = new int[n];

        System.out.println("ENter the array elements: ");
        for (int i = 0 ; i < n ; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter the number of rotations: ");
        int rotations = input.nextInt();

        System.out.println("The array after left rotating the given no of times: " + Arrays.toString(leftRotateArray(arr , rotations)));

        input.close();
    }

    public static int[] leftRotateArray(int arr[] ,int rotations){

        arr = rotateArray(0, rotations-1, arr);
        arr= rotateArray(rotations, arr.length-1, arr);
        arr = rotateArray(0, arr.length-1, arr);

        return arr;
        
    }

    public static int[] rotateArray(int start , int end , int arr[]){

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }
}
