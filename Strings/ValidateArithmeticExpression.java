package Strings;

import java.util.Scanner;
import java.util.Stack;

public class ValidateArithmeticExpression {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Expression: ");
        String exp = input.next();

        if(isValid(exp)){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
        input.close();
    }

    public static boolean isValid(String exp){

        Stack<Character> stack = new Stack<>();
        char prevChar = ' ';

        for (int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);
            if (ch == ')'){
                if (stack.empty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if (ch == '('){
                stack.add(ch);
            }

            else if(ch == '+' || ch == '-' || ch=='*' || ch == '/'){
                if (prevChar== ' ' || prevChar == '(' || prevChar == ')' || prevChar == '+' || prevChar=='-' || prevChar=='/' || prevChar=='*'){
                    return false;
                }
                if (i != exp.length()-1){
                    char nextChar = exp.charAt(i+1);
                    if (nextChar == '(' || nextChar == ')' || nextChar=='+' || nextChar=='-' || nextChar == '*' || nextChar == '/'){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }

            prevChar = ch;
        }
        return prevChar != '(' && stack.empty();
    }
}