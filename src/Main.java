import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 2;

        int[][]A = generateRandomMatrix(size,size);
        int[][]B = generateRandomMatrix(size,size);

//        int[][] result = DivideAndConquerMultiply.DivideAndConquer(A,B);
//        int[][] result = BruteForceMutliply.bruteforceMultiply(A,B);
        int[][] result = StrassensMultiply.strassenMultiply(A,B);

        System.out.println("Matrix A:");
        for (int[] ints : A) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("***********");

        System.out.println("Matrix B:");
        for (int[] ints : B) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("***********");

        System.out.println("Resultant Matrix:");
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] generateRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(99);
            }
        }

        return matrix;
    }
}