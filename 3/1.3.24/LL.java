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

  public boolean find(String key) {
    Node tmp = first;
    while (tmp.next != null) {
      if (tmp.key.equals(key)) {
        break;
      }
      tmp = tmp.next;
    }
    if (tmp.key.equals(key)) {
      return true;
    }
    return false;
  }

  public void removeAfter(Node n) {
    Node tmp = first;
    while (tmp != n) {
      tmp = tmp.next;
    }
    if (n == null || tmp.next == null) {
      return;
    }

    tmp.next = tmp.next.next;
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

    assert ll.find("d");

    ll.delete(2);

    ll.printAll();

    assert !ll.find("d");


    StdOut.println("remove after");
    StdOut.println(ll.first.next.key);
    StdOut.println("printall");
    ll.removeAfter(ll.first.next);
    ll.printAll();

  }
}