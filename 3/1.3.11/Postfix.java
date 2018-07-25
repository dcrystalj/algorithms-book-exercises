import edu.princeton.cs.algs4.*;

public class Postfix {

  public static void main(String[] args) {
    String infix = StdIn.readLine();
    String[] in = infix.split("\\s+");
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < in.length; i++) {
      if (in[i].equals("*") || in[i].equals("+") || in[i].equals("-") || in[i].equals("/")) {
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());

        if (in[i].equals("*")) {
          stack.push(String.valueOf(a * b));
        } else if (in[i].equals("+")) {
          stack.push(String.valueOf(a + b));
        } else if (in[i].equals("/")) {
          stack.push(String.valueOf(a / b));
        } else if (in[i].equals("-")) {
          stack.push(String.valueOf(a - b));
        }
      } else {
        stack.push(in[i]);
      }
    }

    StdOut.println(stack.pop());
  }
}
