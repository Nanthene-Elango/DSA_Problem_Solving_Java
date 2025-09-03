package LinkedList_LL;

import java.util.Scanner;

public class HappyNumber {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = input.nextInt();

        if (isHappy(n)){
            System.out.println(n + " is a happy number.");
        }
        else{
            System.out.println(n + " is not a happy number.");
        }

        input.close();
    }

    public static boolean isHappy(int n){

        int slow = n;
        int fast = n;

        do{
            slow = square(slow);
            fast = square(square(fast));

            
        }while(slow != fast);

        return slow == 1;
    }

    public static int square(int n){

        int sq = 0;
        while (n > 0){
            int rem =n%10;
            sq += (rem) * (rem);
            n /= 10;
        }
        return sq;
    }
}

//similar to LL cycle detection