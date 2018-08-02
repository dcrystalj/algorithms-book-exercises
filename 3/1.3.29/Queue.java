import edu.princeton.cs.algs4.*;

class Node {
  Node next;
  int key;

  public Node(int s) {
    key = s;
  }
}

public class Queue {
  Node last;

  public void enqueue(int s) {
    Node tmp = new Node(s);
    if (last == null) {
      last = tmp;
      tmp.next = last;
    } else {
      Node first = last.next;
      last.next = tmp;
      tmp.next = first;
    }
  }
  
  public Node dequeue() {
    if (last == last.next) {
      Node tmp = last;
      last = null;
      return tmp;
    }
    Node first = last.next;
    Node tmp = first;
    while(tmp.next != last) {
      tmp = tmp.next;
    }
    Node removed = last;
    tmp.next = first;
    last = tmp;
    return removed;
  }

  // public void printAll() {
  //   Node tmp = last;
  //   while (tmp.next != null) {
  //     StdOut.println(tmp.key);
  //     tmp = tmp.next;
  //   }
  //   StdOut.println(tmp.key);
  // }

  public static void main(String[] args) {
    Queue q = new Queue();

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    StdOut.println(q.dequeue().key);
    q.enqueue(4);
    q.enqueue(5);
    StdOut.println(q.dequeue().key);
    q.enqueue(6);
    StdOut.println(q.dequeue().key);
    StdOut.println(q.dequeue().key);
    StdOut.println(q.dequeue().key);
    StdOut.println(q.dequeue().key);
    StdOut.println(q.dequeue()); // must throw null pointer
  }
}