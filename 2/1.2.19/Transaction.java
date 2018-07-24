
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

  public Transaction(String t) {
    String[] fields = t.split("\\s+");
    who = fields[0];
    when = new Date(fields[1]);
    amount = Double.parseDouble(fields[2]);
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
    StdOut.println(new Transaction("Turing 5/22/1939 11.99"));
  }
}
