//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P01 Calendar Printer
// Files:           CalendarTester.java, CalendarPrinter.java
// Course:          CS300, first term, 2019
//
// Author:          Weihang Guo
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jiaqi Zhang
// Partner percentage:   jzhang2247@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
 * This class provides a calendar printer that can print out the dates in a certain month when the
 * user type in the month and year he or she wants. The calendar also tells the user what day of
 * week is a certain day in the month.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class CalendarPrinter {

  /**
   * Using a Scanner to read the month and year information from the user and print out the dates
   * the users want.
   */
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    String month = getMonth(reader);
    String year = getYear(reader);
    // Store each line from the scanner.
    reader.close();
    printCalendar(month, year);
  }


  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Print out the Calendar array from the generateCalendar method in an ordered way.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   */
  public static void printCalendar(String month, String year) {
    for (int temp = 0; temp < generateCalendar(month, year)[0].length; temp ++) {
      System.out.print(generateCalendar(month, year)[0][temp] + " ");
    }
    //Print out the first line which contains the days in week.
    System.out.println();
    for (int i = 1; i < generateCalendar(month, year).length; i ++) {
      for (int j = 0; j < generateCalendar(month, year)[i].length; j ++) {
        System.out.print(" " + generateCalendar(month, year)[i][j]);
        //Print out the rest lines which contain all the dates and dots in the month.
        for (int temp = 0; temp < 3 - generateCalendar(month, year)[i][j].length(); temp++) {
          System.out.print(" ");
        } // Print out the blank space to bring the dates into alignment.
      }
      System.out.println();
    }
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");
  }

  /**
   * Instruct the users to type in the intended month and record this information using scanner.
   * 
   * @param input is a scanner.
   * @return the month users type in.
   */
  public static String getMonth(Scanner input) {
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    System.out.print("Enter the month to print: ");
    // Print out the instruction lines.
    String month = input.next();
    return month;
  }

  /**
   * Instruct the users to type in the intended year and record this information using scanner.
   * 
   * @param input is a scanner.
   * @return the year users type in.
   */
  public static String getYear(Scanner input) {
    System.out.print("Enter the year to print: ");
    String year = input.next();
    return year;
  }

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    int century = Integer.parseInt(year) / 100;
    return century;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {
    int yearWithinCentury = Integer.parseInt(year) % 100;
    return yearWithinCentury;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    int year = Integer.parseInt(yearString);
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
      // Test if the year is divisible by 4, 100 and 400 respectively.
      return true;
    }
    return false;
  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {
    String monthAbrrev = (month.substring(0, 3)).toUpperCase();
    // Get the first three characters of the string and transfer them into upper case.
    for (int index = 0; index < MONTHS_OF_YEAR.length; index++) {
      if (monthAbrrev.equals(MONTHS_OF_YEAR[index])) {
        return index;
      }
      /*
       * When the abbreviation matches one element in MONTHS_OF_YEAR, return the index of that
       * element.
       */
    }
    return -1;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int monthIndex = getMonthIndex(month);
    if (monthIndex == 1) {
      if (getIsLeapYear(year) == true) {
        return 29;
      }
      // Return 29 when the month is a February in a leap year.
      return 28;
      // Return 28 when the month is a February in a normal year.
    }
    if (monthIndex <= 6 && monthIndex % 2 != 0 || monthIndex > 6 && monthIndex % 2 == 0) {
      return 30;
    }
    // Find all the months that contain 30 days.
    return 31;
    // The rest months would contain 31 days.
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int monthIndex = getMonthIndex(month);
    int yearNumber = Integer.parseInt(year);
    int m; // m is the month (3 = March, 4 = April, 5 = May, ..., 14 = February)
    int h; // h is the day of the week (0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday)
    int K; // K the year of the century (year mod 100).
    int J; // J is the zero-based century (the integer part of year/100).

    if (monthIndex > 1) {
      m = monthIndex + 1;
      K = getYearWithinCentury(year);
      /*
       * When the month is any month after February, m would be monthIndex plus one, and K would be
       * the same as the return value of getYearWithinCentury().
       */
    } else {
      m = monthIndex + 13;
      /*
       * When the month is January or February, it would be considered as the 13th and 14th month of
       * the previous year, so m would be monthIndex plus three.
       */
      if (yearNumber % 100 == 0) {
        K = 99;
      } else {
        K = getYearWithinCentury(year) - 1;
      }
      /*
       * When the month is January or February, it would be considered as the 13th and 14th month of
       * the previous year, so K would equal to the return value of the previous year.
       */
    }

    if (monthIndex <= 1 && yearNumber % 100 == 0) {
      J = getCentury(year) - 1;
    }
    /*
     * When the month is January or February, it would be considered as the 13th and 14th month of
     * the previous year, so J would equal to the return value of the previous year.
     */
    else {
      J = getCentury(year);
    }

    h = (int) ((1 + Math.floor(13 * (m + 1) / 5) + K + Math.floor(K / 4) + Math.floor(J / 4)
        + 5 * J) % 7);
    // Use Zeller's congruence to calculate the first day of week in the month.
    if (h > 1) {
      return h - 2;
    }
    return h + 5;
    /*
     * the order of the days in a week in Zeller's congruence is different from the order in the
     * array DAYS_OF_WEEK, so some adjustment to h would be needed to return the exact index within
     * DAYS_OF_WEEK.
     */
  }

  /**
   * Calculates how many rows would be needed in a certain month when presented in a calendar. There
   * are seven days in a row.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of rows in a month when printed out in a calendar.
   */
  public static int getRowsInMonth(String month, String year) {
    int daysInFirstRow = 7 - getFirstDayOfWeekInMonth(month, year);
    // Calculate how many days would be in the first row that contains dates.
    double restDays = getNumberOfDaysInMonth(month, year) - daysInFirstRow;
    // Calculate how many days would be in the rest rows.
    int restRows = (int) (Math.ceil(restDays / 7));
    // Calculate how many rows are needed to place the rest days.
    return restRows + 2;
    /*
     * The number of rest rows plus the first row that contains dates and the row that contain the
     * days of week would be the total number of rows.
     */
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {
    int row = getRowsInMonth(month, year);
    int day = 1; // Record every day in a month.
    String[][] calendar = new String[row][7];
    // Initialize an array for the calendar.
    for (int index = 0; index < 7; ++index) {
      calendar[0][index] = DAYS_OF_WEEK[index];
    }
    // Assign the days of week to the first row of calendar.
    for (int index2 = 0; index2 < getFirstDayOfWeekInMonth(month, year); index2++) {
      calendar[1][index2] = ".";
    }
    /*
     * Place some dots at the beginning of the second row to fill in the blanks where no date
     * exists.
     */
    for (int index3 = getFirstDayOfWeekInMonth(month, year); index3 < 7; index3++) {
      calendar[1][index3] = String.valueOf(day);
      day++;
    }
    // Assign the first few dates to the second row.
    for (int i = 2; i < row; ++i) {
      for (int j = 0; j < 7; j++) {
        if (day <= getNumberOfDaysInMonth(month, year)) {
          calendar[i][j] = String.valueOf(day);
          day++;
        }
        // Assign the rest dates to the calendar.
        else {
          calendar[i][j] = ".";
        }
        // Fill the rest of the last row with dots.
      }
    }
    return calendar;
  }

}
