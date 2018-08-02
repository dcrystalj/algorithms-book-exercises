import edu.princeton.cs.algs4.*;

public class Q {

  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();

    int k = Integer.parseInt(args[0]);

    while (!StdIn.isEmpty())
      s.push(StdIn.readString());

    while (--k > 0)
      s.pop();

    StdOut.println(s.pop());
  }
}
