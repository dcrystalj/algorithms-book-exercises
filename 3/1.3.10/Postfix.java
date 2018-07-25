import edu.princeton.cs.algs4.*;

public class Postfix {

  public static void main(String[] args) {
    String infix = StdIn.readLine();
    String[] in = infix.split("\\s+");
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < in.length; i++) {
      if (!in[i].equals(")")) {
        stack.push(in[i]);
      } else {
        String second = stack.pop();
        String operator = stack.pop();
        String first = stack.pop();
        stack.pop();
        stack.push(first + " " + second + " " + operator);
      }
    }

    StdOut.println(stack.pop());
  }
}
