public class Main {
    public static void main(String[] args) {

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] result = bruteforceMultiply(A, B);

        System.out.println("Resultant Matrix:");
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }


    private static int[][] bruteforceMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] C = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
}