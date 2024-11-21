import java.util.Scanner;

public class Ass_3 {
    // Function to implement Floyd Warshall Algorithm
    public static void warshall(int mat[][]) {
        int n = mat.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update the shortest distance between i and j through k
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }
        // Print the resulting matrix
        printMatrix(mat);
    }

    // Function to print a matrix
    public static void printMatrix(int mat[][]) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        int mat[][] = new int[n][n];

        System.out.println("Enter -1 for infinite distances:");

        // Initialize the matrix
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the distances from vertex " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if (input >= 0) {
                    mat[i][j] = input;
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Represent infinity
                }
            }
        }

        // Create an instance and apply the Floyd Warshall algorithm
        Ass_3 f = new Ass_3();

        System.out.println("The input matrix is:");
        printMatrix(mat);

        System.out.println("The matrix after applying Floyd Warshall Algorithm:");
        warshall(mat);

        sc.close();
    }
}
