import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
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

  public static Stack<String> copy(Stack<String> in) {
    Stack<String> reversed = new Stack<String>();
    Stack<String> s = new Stack<String>();
    for (String i : in) {
      reversed.push(i);
    }
    for (String i: reversed) {
      s.push(i);
    }
    return s;
  }

  public Item peek() {
    return first.item;
  }

  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();
    s.push("it");
    s.push("was");
    s.push("the");
    s.push("best");

    Stack<String> copy = Stack.copy(s);
    assert copy.pop().equals("best");
    assert copy.pop().equals("the");
    assert copy.pop().equals("was");
    assert copy.pop().equals("it");
  }
}
