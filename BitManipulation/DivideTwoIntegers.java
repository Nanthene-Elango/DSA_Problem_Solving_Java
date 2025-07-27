package BitManipulation;

import java.util.Scanner;

public class DivideTwoIntegers {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of divident: ");
        int divident = input.nextInt();

        System.out.println("Enter the value of divisor: ");
        int divisor = input.nextInt();

        System.out.println(divideNumbers(divident , divisor));
        input.close();
    }

    //Time-Complexity is very high not an optimized solution
    // public static int divideNumbers(int divident , int divisor){
    //     int count = 0;

    //     int i = Math.abs(divident);
    //     int j = Math.abs(divisor);
        
    //     while (i >= j){
            
    //         i -= j;
    //         count++;
    //     }

    //     if ((divident < 0 && divisor < 0) || (divident >0 && divisor > 0)){
    //         return count;
    //     }
    //     else{
    //         return -count;
    //     }
    // }

    //using bit manipulation
    public static int divideNumbers(int divident , int divisor){

        long a = Math.abs((long) divident);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            long temp = b;
            int multiple = 1;

            while (a >= (temp << 1)) {  
                temp <<= 1;   //temp = temp * 2;
                multiple <<= 1;  //multiple = multiple*2;
            }

            a -= temp;
            result += multiple;
        }

        if ((divident < 0) ^ (divisor < 0)) {  //XOR (++ , -- = 0) , (+- , -+ = 1) 
            result = -result;
        }

        return result;
    }
}
