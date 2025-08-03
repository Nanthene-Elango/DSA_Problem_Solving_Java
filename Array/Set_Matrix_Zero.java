package Array;

import java.util.*;

public class Set_Matrix_Zero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows(x) and columns(y) of the matrix: ");
        int x = input.nextInt();
        int y = input.nextInt();

        int[][] matrix = new int[x][y];
        System.out.println("Enter the matrix: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        setZeroes(matrix);

        System.out.println("Final Matrix: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowFlag = new boolean[rows];
        boolean[] colFlag = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowFlag[i] || colFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*
 * 
Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.
Therfore the 2nd column and 2nd row wil be set to 0.
 
Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0

url:https://takeuforward.org/data-structure/set-matrix-zero/
 */