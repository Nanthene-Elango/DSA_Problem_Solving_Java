package BitManipulation;

import java.util.Scanner;

public class FlipBits {
    
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of x: ");
        int x = input.nextInt();

        int mask = (1 << Integer.toBinaryString(x).length()) - 1;
        x = x^mask;
        
        System.out.println("The number after fliping the bits: " + x);
        input.close();
    }
}
