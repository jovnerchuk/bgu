import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {

  private static final Scanner scan = new Scanner(System.in);
  private static final Random random = new Random();

  public static void main(String[] args) {
    final var amountOfNumbers = readAmountOfNumbers();
    final var randomArray = randomArray(amountOfNumbers);
    System.out.println(Arrays.toString(randomArray));
    final var tree = new Tree(randomArray);
    final var numberToFind = readNumberToFind();
    System.out.println("Is number exists? => " + tree.isExists(numberToFind));
  }

  private static Integer readAmountOfNumbers() {
    System.out.print("Enter amount of numbers => ");
    return scan.nextInt();
  }

  private static Long readNumberToFind() {
    System.out.print("Enter number to find => ");
    return scan.nextLong();
  }

  private static Long[] randomArray(final Integer amountOfNumbers) {
    var array = new Long[amountOfNumbers];

    for (var i = 0; i < amountOfNumbers; i++) {
      array[i] = Math.abs(random.nextLong()) % 100L;
    }

    return array;
  }

}