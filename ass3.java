Title : You have a business with several offices; you want to lease phone lines to connect them
 up with each other; and the phone company charges different amounts of money to connect
 different pairs of cities. You want a set of lines that connects all your offices with a minimum
 total cost. Solve the problem by Floyd-Warshall algorithm.
 Program :

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

Output:
Enter the number of vertices: 4
Enter -1 for infinite distances:
Enter the distances from vertex 1: 0 3 -1 7
Enter the distances from vertex 2: 8 0 2 -1
Enter the distances from vertex 3: 5 -1 0 1
Enter the distances from vertex 4: 2 -1 -1 0
The input matrix is:
0 3 INF 7
8 0 2 INF
5 INF 0 1
2 INF INF 0
The matrix after applying Floyd Warshall Algorithm:
0 3 5 6
5 0 2 3
3 6 0 1
2 5 7 0
