import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Draw;

public class VisualCounter {
  private int n;
  private int max;
  private int cnt;
  private int ops;
  private Draw d;

  public VisualCounter(int n, int max) {
    this.n = n;
    this.max = max;
    this.d = new Draw("visual counter");
    d.setPenRadius(0.02);
    d.setPenColor(Draw.BLUE);
  }

  public int tally() {
    return this.cnt;
  }

  private void draw() {
    double x = (1.0 / this.n) * ops;
    double y = 0.5 + (1.0 / (this.max * 2)) * this.cnt;
    this.d.point(x, y);
  }

  public void increment() {
    if (this.cnt < this.max && this.ops < this.n) {
      this.cnt += 1;
      this.ops += 1;
      this.draw();
    }
  }

  public void decrement() {
    if (-1 * this.max < this.cnt && this.ops < this.n) {
      this.cnt -= 1;
      this.ops += 1;
      this.draw();
    }
  }

  public static void main(String[] args) {
    VisualCounter vc = new VisualCounter(20, 6);
    vc.increment();
    vc.increment();
    vc.increment();
    vc.decrement();
    vc.decrement();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.increment();
    vc.decrement();
    vc.decrement();
    vc.decrement();
  }
}
