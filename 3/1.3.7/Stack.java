import edu.princeton.cs.algs4.*;

public class Stack<Item> {
  private Node first; // top of stack (most recently added node)
  private int N; // number of items

  private class Node { // nested class to define nodes
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  } // Or: N == 0.

  public int size() {
    return N;
  }

  public void push(Item item) { // Add item to top of stack.
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public Item pop() { // Remove item from top of stack.
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }
  // See page 155 for iterator() implementation.
  // See page 147 for test client main().

  public Item peek() {
    return first.item;
  }
  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();
    s.push("it");
    s.push("was");
    StdOut.println(s.peek());
    s.pop();
    s.push("the");
    s.push("best");
    s.pop();
    s.push("of");
    s.push("times");
    s.pop();
    s.pop();
    s.pop();
    s.push("it");
    s.push("was");
    s.pop();
    s.push("the");
    s.pop();
    s.pop();
    
    while(!s.isEmpty()) StdOut.print(s.pop() + " ");
  }
}
