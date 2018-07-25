
import edu.princeton.cs.algs4.*;

public class FixedCapacityStackOfStrings {
  private String[] a; // stack entries
  private int n; // size

  public FixedCapacityStackOfStrings(int cap) {
    a = new String[cap];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(String item) {
    a[n++] = item;
  }

  public String pop() {
    return a[--n];
  }

  public boolean isFull() {
    return size() == a.length;
  }

  public static void main(String args[]) {
    FixedCapacityStackOfStrings fcss = new FixedCapacityStackOfStrings(3);
    assert fcss.isFull() == false;
    fcss.push("LOL");
    fcss.push("LOL");
    fcss.push("LOL");
    assert fcss.isFull();
  }
}