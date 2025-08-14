package Nuchange_Problems;
import java.util.Arrays;
import java.util.Scanner;

public class Program1 {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = input.nextInt();

        int arr[] = new int[n];

        System.out.println("ENter the array elements: ");
        for (int i = 0 ; i < n ; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter the value of target element: ");
        int target = input.nextInt();

        Arrays.sort(arr);

        System.out.println("The index of numbers: " + Arrays.toString(findIndex(arr , target)));
        
        input.close();
    }

    public static int[] findIndex(int arr[] , int target){

        int i = 0;
        int j = arr.length-1;

        int sum = 0;

        int result[] = new int[2];

        while(i < j){

            sum = arr[i] + arr[j];
            if (sum == target){
                result[0] = i;
                result[1] = j;
                break;
            }
            else if (sum > target){
                j--;
            }
            else if (sum < target){
                i++;
            }
        }

        return result;
    }
}
