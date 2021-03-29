//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P01 Calendar Printer
// Files:           CalendarTester.java, CalendarPrinter.java
// Course:          CS300, first term, 2019
//
// Author:          Weihang Guo
// percentage:           wguo63@wisc.com
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

/**
 * This class tests each method in the CalendarPrinter class to see the positions of possible bugs.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class CalendarTester {

  /**
   * Test if the "getCentury" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Test if the "getYearWithinCentury" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  /**
   * Test if the "getIsLeapYear" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2016") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("2000") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("1000") != false)
      return false;
    return true;
  }

  /**
   * Test if the "getYearMonthIndex" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("January") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("Mar") != 2)
      return false;
    if (CalendarPrinter.getMonthIndex("Dece") != 11)
      return false;
    return true;
  }

  /**
   * Test if the "getNumberOfDaysInMonth" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("January", "2019") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("Feb", "2016") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("Oct", "1997") != 31)
      return false;
    return true;
  }

  /**
   * Test if the "getFirstDayOfWeekInMonth" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("January", "2019") != 1)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("Feb", "2016") != 0)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("Oct", "1997") != 2)
      return false;
    return true;
  }

  /**
   * Test if the "getRowsInMonth" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGetRowsInMonth() {
    if (CalendarPrinter.getRowsInMonth("January", "2019") != 6)
      return false;
    if (CalendarPrinter.getRowsInMonth("FEB", "2016") != 6)
      return false;
    if (CalendarPrinter.getRowsInMonth("Sepetemmmm", "2019") != 7)
      return false;
    return true;
  }

  /**
   * Test if the "generateCalendar" method runs correctly when given three different inputs.
   * 
   * @return true when the method runs correctly, and false when the method runs incorrectly.
   */
  public static boolean testGenerateCalendar() {
    if (!CalendarPrinter.generateCalendar("May", "2010")[3][5].equals("15"))
      return false;
    if (!CalendarPrinter.generateCalendar("Oct", "1993")[2][0].equals("4"))
      return false;
    if (!CalendarPrinter.generateCalendar("Mar", "2045")[4][1].equals("21"))
      return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(testGetCentury() + "\n" + testGetYearWithinCentury() + "\n"
        + testGetIsLeapYear() + "\n" + testGetMonthIndex() + "\n" + testGetNumberOfDaysInMonth()
        + "\n" + testGetFirstDayOfWeekInMonth() + "\n" + testGetRowsInMonth() + "\n"
        + testGenerateCalendar());
    /*
     * Print out the result of each testing method to see if all the methods in the CalendarPrinter
     * class are running well.
     */
  }

}
