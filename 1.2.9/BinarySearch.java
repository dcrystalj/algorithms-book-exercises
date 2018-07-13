import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class BinarySearch {
  private static int rank(int key, int[] array, Counter cnt) {
    int lo = 0;
    int hi = array.length - 1;
    while (lo <= hi) {
      cnt.increment();
      int mid = lo + (hi - lo) / 2;
      if (key < array[mid])
        hi = mid - 1;
      else if (key > array[mid])
        lo = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6 };
    Counter cnt = new Counter("total keys");
    rank(4, array, cnt);
    StdOut.println(cnt);
  }
}
