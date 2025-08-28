import java.util.Scanner;

public class SquareNumbers {
    
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        int size = 2*n-1;

        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++){

                //method 1
                // int top = i;
                // int bottom = j;
                // int left = size-1-i;
                // int right = size-1-j;

                // int mindist = Math.min(Math.min(right, bottom), Math.min(top, left));
                // System.out.print(n-mindist);

                //method 2
                int c = n-1;
                int mindist = 1+Math.max(Math.abs(i-c), Math.abs(j-c));
                System.out.print(mindist);
            }
            System.out.println();
        }

        input.close();
    }
}

// Write a program to print the below series.

// Input: 4

// 4444444
// 4333334
// 4322234
// 4321234
// 4322234
// 4333334
// 4444444