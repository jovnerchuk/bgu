import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    var number = readNumber();
    var base = readBase();
    System.out.println("Result => " + parse(convertNumberWithBase(number, base)));
  }

  private static Integer readBase() {
    System.out.print("Enter base => ");
    return scan.nextInt();
  }

  private static Long readNumber() {
    System.out.print("Enter number => ");
    return scan.nextLong();
  }

  public static List<Long> convertNumberWithBase(final Long number, final Integer base) {
    var tempNumber = number;
    var digits = new ArrayList<Long>();
    while (tempNumber > 0) {
      digits.add(0, tempNumber % base);
      tempNumber = tempNumber / base;
    }
    return digits;
  }

  public static String parse(final List<Long> digits) {
    var result = new StringBuilder();
    for (var digit : digits) {
      if (digit < 10) {
        result.append(digit);
      } else {
        result.append((char) ('A' + digit - 10));
      }
    }
    return result.toString();
  }

}
