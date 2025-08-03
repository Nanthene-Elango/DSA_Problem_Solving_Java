package Array;

import java.util.Arrays;
import java.util.Scanner;

public class SortOddInDesEvenInAsc {

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

        arr = sortInSpecificOrder(arr);

        System.out.println("Array after sorting: " + Arrays.toString(arr));

        input.close();
    }

    private static int[] sortInSpecificOrder(int[] arr) {
        
        Arrays.sort(arr);
        int odd = 0 , i , j;
        int temp;
        for (i = 0 ; i < arr.length ; i++){
            if (arr[i] % 2 == 1){
                j = i-1;
                temp = arr[i];
                while (j >= 0 && arr[j] % 2 == 0){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = temp; 
                odd++;
            }
        }
        
        i = 0 ; j = odd-1;
        while (i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        

        return arr;
    }
}

/*
 * Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
 * Output: [7, 5, 3, 1, 2, 4, 10]
 * Explanation: 7 5 3 1 are odds in descending order and 2 4 10 are evens in
 * ascending order.
 * 
 * Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
 * Output: [7, 5, 3, 1, 0, 2, 4]
 * Explanation: 7 5 3 1 are odds in descending order and 0 2 4 are evens in
 * ascending order.Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
 * 
 * url : http://geeksforgeeks.org/problems/sort-in-specific-order2422/1
 */