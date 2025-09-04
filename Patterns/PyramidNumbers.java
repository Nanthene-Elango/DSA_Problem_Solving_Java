import java.util.Scanner;

public class PyramidNumbers {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int i = 1 ; i <= n ; i++){
            
            for (int s = 1 ; s <= n-i ; s++){
                System.out.print(" ");
            }

            for (int j = i ; j >= 1 ; j--){
                System.out.print(j);
            }

            for (int k = 2 ; k <= i ; k++){
                System.out.print(k);
            }

            System.out.println();
        }
        input.close();
    }
}
