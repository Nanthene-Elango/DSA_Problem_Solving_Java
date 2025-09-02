package Oops_Console_Projects.Tic_Tac_Toe_Game;

import java.util.Scanner;

public class TicTacToeApp {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        TicTacToeMode1 mode1 = new TicTacToeMode1();
        TicTacToeMode2 mode2 = new TicTacToeMode2();

        System.out.println("-----------");
        System.out.println("TIC TAC TOE");
        System.out.println("------------");

        System.out.println("Choose the Mode of playing");
        System.out.println("Mode 1 : Player vs AI");
        System.out.println("Mode 2 : Player vs Player");

        System.out.print("Enter the mode(1/2): ");
        int mode = input.nextInt();

        if (mode == 1){

        }
        else if (mode == 2){
            mode2.printBoard();
            mode2.play(1);
        }
        else{
            System.err.println("Oops you entered the wrong mode! try again..");
        }

        input.close();
    }
}
