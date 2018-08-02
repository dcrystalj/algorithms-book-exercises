import edu.princeton.cs.algs4.*;

class Node {
  Node next;
  String key;

  public Node(String s) {
    key = s;
  }
}

public class LL {
  Node first;


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
    if (n == null || n.next == null) {
      return;
    }

    n.next = n.next.next;
  }

  public void insertAfter(Node n, Node toInsert) {
    if (n == null || toInsert == null) return;
    toInsert.next = n.next;
    n.next = toInsert;
  }

  public void remove(LL l, String key) {
    while (l.first != null && l.first.key.equals(key)) {
      l.first = l.first.next;
    }
    Node tmp = l.first;
    while (tmp != null && tmp.next != null && tmp.next.next != null) {
      if (tmp.next.key.equals(key)) {
        tmp.next = tmp.next.next;
      } else {
        tmp = tmp.next;
      }
    }
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

    // test remove after
    StdOut.println("remove after");
    StdOut.println(ll.first.next.key);
    StdOut.println("printall");
    ll.removeAfter(ll.first.next);
    ll.printAll();

    // test insert after
    StdOut.println();
    ll.insertAfter(ll.first.next, new Node("c"));
    ll.insertAfter(ll.first.next, new Node("d"));
    ll.printAll();

    //test remove
    StdOut.println();
    ll.insertAfter(ll.first, new Node("f"));
    ll.insertAfter(ll.first, new Node("f"));
    ll.insertAfter(ll.first.next.next.next, new Node("c"));
    ll.remove(ll, "f");
    ll.remove(ll, "c");
    ll.printAll();
  }
}