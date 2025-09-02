package Array;

import java.util.Scanner;

public class SecondLargestElement {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();

        System.out.println("Enter the array elements: ");
        int arr[] = new int[n];

        for (int i = 0 ; i < n ; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("The second largest element is: " + findSecondLargest(arr));
        input.close();
    }

    public static int findSecondLargest(int arr[]){
        
        if (arr.length == 1 || arr.length == 0){
            return -1;
        }

        int largest = arr[0];
        int secondLargest = -1;

        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLargest && arr[i] < largest){
                secondLargest = arr[i];
            }
        }
        if (secondLargest == -1){
            return largest;
        }
        else{
            return secondLargest;
        }
    }
}

//There are three conditions:
//1) if the array has 1 or 0 elements return -1
//2) if all the elements in the array are same return that element
//3) if the array contains duplicate largest element and the other elements return only the second least element 
//example: arr[3] = {5,5,4} return 4