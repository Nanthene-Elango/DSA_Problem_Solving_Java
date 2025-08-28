package TwoD_Array;

public class SubstringSearch2D {
    public static void main(String[] args) {
        String str = "WELCOMETOZOHOCORPORATION";
        String pattern = "TOO";

        int rows = (int) Math.ceil((double) str.length() / 5);
        int cols = 5;  // fixed column size (as per given example)

        // Fill 2D array
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < str.length()) {
                    matrix[i][j] = str.charAt(index++);
                } else {
                    matrix[i][j] = ' '; // padding if needed
                }
            }
        }

        // Print matrix for verification
        System.out.println("2D Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Search horizontally
        for (int i = 0; i < rows; i++) {
            String rowString = new String(matrix[i]);
            int pos = rowString.indexOf(pattern);
            if (pos != -1) {
                System.out.println("\nFound horizontally:");
                System.out.println("Start index: <" + (i+1) + "," + (pos+1) + ">");
                System.out.println("End index  : <" + (i+1) + "," + (pos+pattern.length()) + ">");
                return;
            }
        }

        // Search vertically
        for (int j = 0; j < cols; j++) {
            StringBuilder colString = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                colString.append(matrix[i][j]);
            }
            int pos = colString.indexOf(pattern);
            if (pos != -1) {
                System.out.println("\nFound vertically:");
                System.out.println("Start index: <" + (pos+1) + "," + (j+1) + ">");
                System.out.println("End index  : <" + (pos+pattern.length()) + "," + (j+1) + ">");
                return;
            }
        }

        System.out.println("\nPattern not found!");
    }
}
