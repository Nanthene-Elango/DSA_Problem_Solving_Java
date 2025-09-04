package NumberSystem;

import java.util.Scanner;

public class ConvertToBase {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = input.nextInt();

        System.out.println("Enter the base number: ");
        int base = input.nextInt();

        System.out.println(n + " after converted to the base " + base + " : " + convertToBase(n , base));
        input.close();
    }

    public static String convertToBase(int n , int base){
        
        StringBuilder result = new StringBuilder();

        while (n > 0){
            result.append(n % base);
            n /= base;
        }

        return result.reverse().toString();
    }
}
