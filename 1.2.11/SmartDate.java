
import edu.princeton.cs.algs4.*;

public class SmartDate {

  private static int[] daysInMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  public SmartDate(int day, int month, int year) {
    if (!isValid(day, month, year))
      throw new NumberFormatException("Invalid date");
  }
  
  private static boolean isValid(int day, int month, int year) {
    if (month < 1 || month > 12) return false;
    if (day < 1 || day > daysInMonth[month-1]) return false;
    if (year < 1 || day == 29 && month == 2 && !isLeapYear(year)) return false;
    return true;
  }

  private static boolean isLeapYear(int year) {
    if (year % 400 == 0) return true;
    if (year % 100 == 0) return false;
    return year % 4 == 0;
  }

  public static void main(String[] args) {
    new SmartDate(99, 4, 2011);
  }
}
