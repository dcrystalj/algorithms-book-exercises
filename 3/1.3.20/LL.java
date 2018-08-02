import edu.princeton.cs.algs4.*;

public class LL {
  Node first;

  private class Node {
    Node next;
    String key;

    public Node(String s) {
      key = s;
    }
  }

  public void append(String s) {
    Node tmp = new Node(s);
    tmp.next = first;
    first = tmp;
  }

  public void delete(int k) {
    Node tmp = first;
    while (tmp.next != null) {
      if (k == 1) {
        break;
      }
      k--;
      tmp = tmp.next;
    }
    if (tmp.next != null)
      tmp.next = tmp.next.next;
  }

  public void printAll() {
    Node tmp = first;
    while (tmp.next != null) {
      StdOut.println(tmp.key);
      tmp = tmp.next;
    }
    StdOut.println(tmp.key);
  }

  public static void main(String[] args) {
    LL ll = new LL();

    ll.append("a");
    ll.append("b");
    ll.append("c");
    ll.append("d");
    ll.append("e");
    ll.append("f");
    ll.printAll();

    StdOut.println();

    ll.delete(2);
    ll.printAll();

  }
}