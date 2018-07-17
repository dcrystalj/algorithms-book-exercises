
import edu.princeton.cs.algs4.*;

public class SmartDate {
  private static int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
  
  private final int day;
  private final int month;
  private final int year;


  public SmartDate(int day, int month, int year) {
    if (!isValid(day, month, year))
      throw new NumberFormatException("Invalid date");
    this.day = day;
    this.month = month;
    this.year = year;
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

  public String dayOfTheWeek() {
    // 1.1.2000 == saturday ==> index 5
    int totalDays = 5;

    // days of each year
    for (int i = 2000; i < this.year; i++) {
      if (isLeapYear(i)) {
        totalDays += 366;
      } else {
        totalDays += 365;
      }
    }

    // days of each month
    for (int i = this.month - 2; i >= 0; i--) {
      totalDays += daysInMonth[i];
      if (!isLeapYear(this.year) && i == 1)
        totalDays -= 1;
    }

    totalDays += this.day - 1;

    return days[totalDays % 7];
  }

  public static void main(String[] args) {
    StdOut.println(new SmartDate(17, 7, 2018).dayOfTheWeek());
  }
}
