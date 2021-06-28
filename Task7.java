import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task7 {

  private static final Scanner scan = new Scanner(System.in);
  private static final Random random = new Random();

  public static void main(String[] args) {
    var amountOfNumbers = readAmountOfNumbers();
    var arrayA = randomArray(amountOfNumbers);
    var arrayB = randomArray(amountOfNumbers);
    System.out.println("ArrayA => " + Arrays.toString(arrayA));
    System.out.println("ArrayB => " + Arrays.toString(arrayB));
    bubbleSort(arrayA);
    shellSort(arrayB);
    System.out.println("ArrayA bubbleSort => " + Arrays.toString(arrayA));
    System.out.println("ArrayB shellSort => " + Arrays.toString(arrayB));
  }

  private static Integer[] randomArray(final Integer amountOfNumbers) {
    var array = new Integer[amountOfNumbers];
    for (var i = 0; i < amountOfNumbers; i++) {
      array[i] = Math.abs(random.nextInt()) % 100;
    }
    return array;
  }

  private static Integer readAmountOfNumbers() {
    System.out.print("Enter amount of numbers => ");
    return scan.nextInt();
  }

  public static void bubbleSort(final Integer[] array) {
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          isSorted = false;
          swap(i, i + 1, array);
        }
      }
    }
  }

  public static void shellSort(final Integer[] array) {
    var n = array.length;
    for (var gap = n / 2; gap > 0; gap /= 2) {
      for (var i = gap; i < n; i += 1) {
        var temp = array[i];
        int j;
        for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
          array[j] = array[j - gap];
        }
        array[j] = temp;
      }
    }
  }

  private static void swap(final Integer a, final Integer b, final Integer[] array) {
    var tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

}
