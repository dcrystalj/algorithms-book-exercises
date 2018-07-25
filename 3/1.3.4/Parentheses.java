import edu.princeton.cs.algs4.*;

public class Parentheses {

  public static boolean isValid(String string) {
    Stack<Character> s = new Stack<Character>();

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      if (c == '[' || c == '{' || c == '(') {
        s.push(c);
      } else {
        char p = s.pop();
        if (c == ']' && p != '[' || c == '}' && p != '{' || c == ')' && p != '(') {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String input = StdIn.readString();
    StdOut.println(isValid(input));
  }
}
