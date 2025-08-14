package Nuchange_Problems;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Program2 {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = input.next();

        System.out.println("The first non-repeating character in the string is: " + findNonrepeatingCharacter(s));

        input.close();
    }

    public static Character findNonrepeatingCharacter(String s){

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        for (Character c : map.keySet()){
            if (map.get(c) == 1){
                return c;
            }
        }

        return null;
    }
}
