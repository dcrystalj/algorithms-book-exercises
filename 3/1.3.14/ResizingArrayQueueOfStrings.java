import edu.princeton.cs.algs4.*;

public class ResizingArrayQueueOfStrings {
  private String[] array;
  private int start;
  private int end;
  
  public ResizingArrayQueueOfStrings(int cap) {
    array = new String[cap];
  }

  public boolean isEmpty() {
    return start == end;
  }

  public int size() {
    return end - start;
  }

  public void enqueue(String s) {
    array[end++] = s;
    int alen = array.length;
    if (alen == end) {
      String[] newArray = new String[alen * 2];
      
      for (int i = 0; i < end-start; i++) {
        newArray[i] = array[start + i];
      }
      array = newArray;
      end = end - start;
      start = 0;
    }
  }

  public String dequeue() {
    String tmp = array[start];
    array[start] = null;
    start++;

    if (start > end) { // reset if queue is empty
      start = 0;
      end = 0;
    }

    int alen = array.length;
    if (alen == end / 4) {  // double array if full and move to beginning
      String[] newArray = new String[alen * 2];
      
      for (int i = 0; i < end-start; i++) {
        newArray[i] = array[start + i];
      }
      array = newArray;
      end = end - start;
      start = 0;
    }
    return tmp;
  }

  public static void main(String[] args) {

    // without resizing
    ResizingArrayQueueOfStrings raq = new ResizingArrayQueueOfStrings(3);
    raq.enqueue("a");
    raq.enqueue("b");
    raq.enqueue("c");
    assert raq.dequeue().equals("a");
    assert raq.dequeue().equals("b");
    assert raq.dequeue().equals("c");

    raq = new ResizingArrayQueueOfStrings(3);
    raq.enqueue("a");
    raq.enqueue("b");
    assert raq.dequeue().equals("a");
    raq.enqueue("c");
    assert raq.dequeue().equals("b");
    assert raq.dequeue().equals("c");

    // resizing
    raq = new ResizingArrayQueueOfStrings(2);
    raq.enqueue("a");
    raq.enqueue("b");
    assert raq.dequeue().equals("a");
    raq.enqueue("c");
    assert raq.dequeue().equals("b");
    raq.enqueue("d");
    assert raq.dequeue().equals("c");
    assert raq.dequeue().equals("d");

  }
}
