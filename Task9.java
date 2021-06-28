public class Task9 {

  public static void main(String[] args) {
    var curves = new Integer[][]
        {
            {1, 3},
            {0},
            {3},
            {1, 2}
        };
    var graph = new Graph(curves);
    System.out.println(graph);
  }

}
