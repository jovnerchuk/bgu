import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

  private static final Scanner scan = new Scanner(System.in);
  private static final Random random = new Random();

  public static void main(String[] args) {
    final var matrixSize = readMatrixSize();
    final var matrix = randomMatrix(matrixSize);
    printMatrix(matrix);
    final var result = multiplyMatrixElements(matrix);
    System.out.println("Result => " + result);
  }

  private static void printMatrix(final Long[][] matrix) {
    for (var row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  private static Integer readMatrixSize() {
    System.out.print("Enter matrix size => ");
    return scan.nextInt();
  }

  public static Long[][] randomMatrix(final Integer matrixSize) {
    var matrix = new Long[matrixSize][];

    for (int i = 0; i < matrixSize; i++) {
      matrix[i] = readMatrixRow(matrixSize);
    }

    return matrix;
  }

  private static Long[] readMatrixRow(final Integer rowSize) {
    final var matrixRow = new Long[rowSize];
    for (int i = 0; i < rowSize; i++) {
      matrixRow[i] = Math.abs(random.nextLong()) % (10000L - 5L) + 5L;
    }
    return matrixRow;
  }

  public static BigInteger multiplyMatrixElements(final Long[][] matrix) {
    var result = BigInteger.valueOf(1L);
    for (var row : matrix) {
      result = result.multiply(multiplyRowElements(row));
    }
    return result;
  }

  private static BigInteger multiplyRowElements(final Long[] matrixRow) {
    var result = BigInteger.valueOf(1L);
    for (var element : matrixRow) {
      result = result.multiply(BigInteger.valueOf(element));
    }
    return result;
  }

}
