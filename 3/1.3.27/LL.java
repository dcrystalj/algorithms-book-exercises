import edu.princeton.cs.algs4.*;

class Node {
  Node next;
  int key;

  public Node(int s) {
    key = s;
  }
}

public class LL {
  Node first;

  public void append(int s) {
    Node tmp = new Node(s);
    tmp.next = first;
    first = tmp;
  }
  
  public void printAll() {
    Node tmp = first;
    while (tmp.next != null) {
      StdOut.println(tmp.key);
      tmp = tmp.next;
    }
    StdOut.println(tmp.key);
  }

  public int max (Node n) {
    int max_val = n.key;
    while(n.next != null) {
      max_val = Math.max(max_val, n.key);
      n = n.next;
    }
    return max_val;
  }

  public static void main(String[] args) {
    LL ll = new LL();

    ll.append(1);
    ll.append(2);
    ll.append(3);
    ll.append(6);
    ll.append(4);
    ll.append(5);
    ll.printAll();
    StdOut.println();
    StdOut.println(ll.max(ll.first));

  }
}