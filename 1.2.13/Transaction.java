
import edu.princeton.cs.algs4.*;

public class Transaction {

  private final String who;
  private final Date when;
  private final double amount;

  public Transaction(String who, Date when, double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public String who() {
    return this.who;
  }

  public Date when() {
    return this.when;
  }

  public double amount() {
    return this.amount;
  }

  public String toString() {
    return this.who() + " " + this.when() + " " + this.amount();
  }

  public static void main(String[] args) {
    StdOut.println(new Transaction("LOL", new Date(1, 1, 2018), 12.3));
  }
}
