package Oops_Console_Projects.Tic_Tac_Toe_Game;

import java.util.Scanner;

public class TicTacToeMode1 {
    
    public char[][] board = new char[3][3];
    public int currentPlayer = 1;

    public TicTacToeMode1(){
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void play(){
        Scanner input = new Scanner(System.in);
        int i, j;
        if (currentPlayer == 1){
            
            while(true){
                System.out.println("<<Player Turn>>");
                System.out.print("Enter the index value of board eg:(i,j): ");
                String index = input.next();
    
                i = Integer.valueOf(index.charAt(0));
                j = Integer.valueOf(index.charAt(2));

                if(index.length() > 3 || index.length() < 3){
                    System.out.println("Invalid index value! try again");
                }
                else if ((i < 0 || i > 2) || (j< 0 || j >2) || index.charAt(1) != ','){
                    System.out.println("Invalid index value! try again");
                }
                else if(board[i][j] != ' '){
                    System.out.println("The entered cell is already filled! try again");
                }
                else{
                    board[i][j] = 'X';
                    printBoard();
                    break;
                }
            }
            input.close();
            if(won('X')){
                return;
            }
            else{
                currentPlayer = 2;
                play();
            }
        }
        else{
            
        }
    }

    public boolean won(char ch){
        
        for (int i = 0 ; i < 3 ; i++){
            if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch){
                return true;
            }
        }

        for (int i = 0 ; i < 3 ; i++){
            if (board[0][i] == ch && board[1][i]==ch && board[2][i] == ch){
                return true;
            }
        }

        if (board[0][0] == ch && board[1][1]==ch && board[2][2] == ch){
            return true;
        }
        
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch){
            return true;
        }

        return false;
    }

    public void printBoard(){

        for (int i = 0 ; i < 3 ; i++){
            System.out.print("|");
            for (int j = 0 ; j < 3 ; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
