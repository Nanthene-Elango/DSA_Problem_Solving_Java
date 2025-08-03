package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubsetOrNot {
 
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array a: ");
        int size1 = input.nextInt();

        System.out.println("Enter the value of array a: ");
        int a[] = new int[size1];

        for (int i = 0 ; i < size1 ; i++){
            a[i] = input.nextInt();
        }

        System.out.println("Enter the size of array b: ");
        int size2 = input.nextInt();

        System.out.println("Enter the value of array b: ");
        int b[] = new int[size1];

        for (int i = 0 ; i < size2 ; i++){
            b[i] = input.nextInt();
        }

        System.out.println("array B is a subset of array A: " + isSubset(a , b));
        input.close();
    }


    public static boolean isSubset(int[] a , int[] b){
        
        Map<Integer, Integer> freqA = new HashMap<>();
        
        for (int num : a) {
            freqA.put(num, freqA.getOrDefault(num, 0) + 1);
        }
  
        for (int num : b) {
            if (!freqA.containsKey(num) || freqA.get(num) == 0) {
                return false;
            }
            freqA.put(num, freqA.get(num) - 1);
        }
        
        return true;
    }


    //Another approach using 2 pointers
    // public static boolean isSubset(int[] a , int[] b){
        
    //     Arrays.sort(a);
    //     Arrays.sort(b);
        
    //     int i = 0, j = 0;
        
    //     while (i < a.length && j < b.length) {
    //         if (a[i] == b[j]) {
    //             i++; j++;
    //         } else if (a[i] < b[j]) {
    //             i++;
    //         } else {
    //             return false; // b[j] not found in a
    //         }
    //     }
        
    //     return j == b.length;
    // }


}
