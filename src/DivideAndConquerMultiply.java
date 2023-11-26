public class DivideAndConquerMultiply {
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] C = new int[m][p];

        if (m == 1 && n == 1 && p == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = subMatrix(A, 0, 0, m / 2, n / 2);
            int[][] A12 = subMatrix(A, 0, n / 2, m / 2, n);
            int[][] A21 = subMatrix(A, m / 2, 0, m, n / 2);
            int[][] A22 = subMatrix(A, m / 2, n / 2, m, n);

            int[][] B11 = subMatrix(B, 0, 0, n / 2, p / 2);
            int[][] B12 = subMatrix(B, 0, p / 2, n / 2, p);
            int[][] B21 = subMatrix(B, n / 2, 0, n, p / 2);
            int[][] B22 = subMatrix(B, n / 2, p / 2, n, p);

            int[][] C11 = add(multiply(A11, B11), multiply(A12, B21));
            int[][] C12 = add(multiply(A11, B12), multiply(A12, B22));
            int[][] C21 = add(multiply(A21, B11), multiply(A22, B21));
            int[][] C22 = add(multiply(A21, B12), multiply(A22, B22));

            combineSubmatrices(C, C11, C12, C21, C22);
        }

        return C;
    }

    private static int[][] subMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int rows = endRow - startRow;
        int cols = endCol - startCol;
        int[][] submatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                submatrix[i][j] = matrix[startRow + i][startCol + j];
            }
        }

        return submatrix;
    }

    private static int[][] add(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    private static void combineSubmatrices(int[][] result, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int rows = result.length;
        int cols = result[0].length;

        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                result[i][j] = C11[i][j];
                result[i][j + cols / 2] = C12[i][j];
                result[i + rows / 2][j] = C21[i][j];
                result[i + rows / 2][j + cols / 2] = C22[i][j];
            }
        }
    }

    public static int[][] DivideAndConquer(int[][]A, int[][]B) {
        return multiply(A, B);
    }
}
