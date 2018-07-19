import java.sql.Date;

import edu.princeton.cs.algs4.*;

public class Rational {

  private final long numerator;
  private final long denominator;

  public Rational(long numerator, long denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }
  private static long gcd(long a, long b) {
    while (b != 0) {
      long tmp = b;
      b = a % b;
      a = tmp;
    }
    return a;
  }

  private static Rational simplify(Rational r) {
    long GCD = gcd(r.numerator, r.denominator);
    return new Rational(r.numerator/GCD, r.denominator/GCD);
  }

  public Rational plus(Rational b) {
    long common = denominator * b.denominator;
    return simplify(new Rational(numerator * (common / denominator) + b.numerator * (common / b.denominator), common));
  }

  public Rational minus(Rational b) {
    long common = denominator * b.denominator;
    return simplify(new Rational(numerator * (common / denominator) - b.numerator * (common / b.denominator), common));
  }

  public Rational times(Rational b) {
    return simplify(new Rational(numerator*b.numerator, denominator*b.denominator));
  }

  public Rational divides(Rational b) {
    return simplify(new Rational(numerator*b.denominator, denominator*b.numerator));
  }

  public boolean equals(Rational that) {
    return (numerator == that.numerator) && (denominator == that.denominator);
  }

  public String toString() {
    return numerator + "/" + denominator;
  }

  public static void main(String[] args) {
    Rational a = new Rational(3, 4);
    Rational b = new Rational(4, 5);
    StdOut.println(a.times(b));
    StdOut.println(a.divides(b));
    StdOut.println(a.plus(b));
    StdOut.println(a.minus(b));
    StdOut.println(b.minus(a));
    StdOut.println(a.equals(b));

    a = new Rational(3, 4);
    b = new Rational(4, 6);
    StdOut.println(a.times(b));  // 1/2
    StdOut.println(a.divides(b));  // 9/8
    StdOut.println(a.plus(b));  // 17/12
    StdOut.println(a.minus(b));  // 1/12
    StdOut.println(b.minus(a));  // -1/12
    StdOut.println(a.equals(b));  // false
  }
}
