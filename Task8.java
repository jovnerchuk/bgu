import java.util.Arrays;
import java.util.Random;

public class Task8 {

  private static final Random random = new Random();

  public static void main(String[] args) {
    final var randomArray = randomArray(20);
    System.out.println(Arrays.toString(randomArray));
    final var tree = new Tree(randomArray);
    System.out.println(tree.isExists(10L));
  }

  private static Long[] randomArray(final Integer amountOfNumbers) {
    var array = new Long[amountOfNumbers];

    for (var i = 0; i < amountOfNumbers; i++) {
      array[i] = Math.abs(random.nextLong()) % 100L;
    }

    return array;
  }

}
