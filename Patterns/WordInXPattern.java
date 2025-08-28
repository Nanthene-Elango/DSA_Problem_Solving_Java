import java.util.Scanner;

public class WordInXPattern {
    
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the word with odd letters: ");
        String str = input.next();

        printPattern(str);

        input.close();
    }

    public static void printPattern(String str){

        int start = 0;
        int end = str.length()-1;

        for (int j = 0 ; j < str.length(); j++){
            for (int i = 0 ; i < str.length() ; i++){
                if(i == start){
                    System.out.print(str.charAt(start));
                }
                else if(i == end){
                    System.out.print(str.charAt(end));
                }
                else{
                    System.out.print(" ");
                }
            }
            System.err.println();
            start++;
            end--;
        }
    }
}
