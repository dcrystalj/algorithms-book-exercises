import edu.princeton.cs.algs4.*;

public class Rational {

  private final long numerator;
  private final long denominator;

  public Rational(long numerator, long denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Rational(int numerator, int denominator) {
    assert denominator != 0;

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
    assert common <= Integer.MAX_VALUE;
    return simplify(new Rational(numerator * (common / denominator) + b.numerator * (common / b.denominator), common));
  }

  public Rational minus(Rational b) {
    long common = denominator * b.denominator;
    assert common <= Integer.MAX_VALUE;
    return simplify(new Rational(numerator * (common / denominator) - b.numerator * (common / b.denominator), common));
  }

  public Rational times(Rational b) {
    assert numerator * b.numerator <= Integer.MAX_VALUE;
    assert denominator * b.denominator <= Integer.MAX_VALUE;
    return simplify(new Rational(numerator*b.numerator, denominator*b.denominator));
  }

  public Rational divides(Rational b) {
    assert numerator * b.denominator <= Integer.MAX_VALUE;
    assert denominator * b.numerator <= Integer.MAX_VALUE;
    return simplify(new Rational(numerator*b.denominator, denominator*b.numerator));
  }

  public boolean equals(Object that) {
    if (this == that) {
      return true;
    } else if (that == null || this.getClass() != that.getClass()) {
      return false;
    }
    Rational r = (Rational) that;
    return (numerator == r.numerator) && (denominator == r.denominator);
  }
  
  public int hashCode() {
    return this.toString().hashCode();
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
