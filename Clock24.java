/**
 * A clock, with hours and minutes,
 * and operations to set the time, advance the time, and 
 * display the time in 24-hour and 12-hour formats.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock24
{
  // instance variables
  private int hour;
  private int minute;
  private static final int HOURS_PER_DAY = 24;
  private static final int MIN_PER_HOUR = 60;

  /**
   * Default constructor for objects of class Clock24
   * 
   * Preconditions: none
   * Postconditions: time is set to 12:00 midnight.
   */
  public Clock24() {
    this.setHour(0);
    this.setMinute(0);
  } //end Constructor

  /**
   * Constructor for objects of class Clock24
   * 
   * @param hval    the desired hour.
   * Postcondition: a Clock24 object is created with the given hour value
   * and a default minute value of 0.
   */
  public Clock24( int hval ) {
    this.setHour( hval );
    this.setMinute(0);
  } //end Constructor

  /**
   * Constructor for objects of class Clock24
   * 
   * @param hval    the desired hour value
   * @param mval    the desired minute value
   * Preconditions: 0 <= hval <= 23, 0 <= mval <= 59
   * Postcondition: the Clock24 object is created with the specified hour and
   * minute values.
   */
  public Clock24( int hval, int mval ) {
    this.setHour( hval );
    this.setMinute( mval );
  } //end Constructor

  /**
   * setHour: what it sounds like.
   * 
   * @param val     the desired new hour value
   * Precondition:  val >= 0
   * Postcondition: The new hour value is set 
   * (using modulo to ensure maintenance of 24-hour format).
   */
  public void setHour( int val ) {
    this.hour = ( val % this.HOURS_PER_DAY );
  } //end setHour(int)

  /**
   * setMinute: what it sounds like.
   * 
   * @param val     the desired minute value
   * Precondition:  0 <= val <= 59
   * Postcondition: The new minute value is set.
   */
  public void setMinute( int val ) {
    this.minute = val;
  } //end setMinute(int)

  /**
   * setTime: set the time by setting the hour and minute.
   * 
   * @param hval    the desired new hour
   * @param mval    the desired new minute
   * Postcondition: The new hour and minute values are set.
   */
  public void setTime( int hval, int mval ) {
    this.setHour( hval );
    this.setMinute( mval );
  } //end setTime(int, int)

  /**
   * getHour: what it sounds like.
   * 
   * @return    an int, the current hour value (in 24 hour format).
   */
  public int getHour() {
    return this.hour;    
  } //end getHour()

  /**
   * getMinute: what it sounds like.
   * 
   * @return    an int, the current minute value (in 24 hour format).
   */ 
  public int getMinute() {
    return this.minute;
  } //end getMinute()

  /**
   * addHours: advance the hour by a given amount,
   * 
   * @param hadd    the desired number of hours to be added.
   * Postcondition: hour is updated to the new time 
   * (using modulo to ensure maintenance of 24-hour format).
   */
  public void addHours( int hadd ) {
    setHour(this.hour + hadd);
  } //end addHours(int)

  /**
   * addMinutes: advance the minutes by a given amount.
   * 
   * @param madd    the desired number of minutes to add.
   * Postcondition: minute (and hour if necessary) is updated.
   */
  public void addMinutes( int madd ) {
    setTime( ( this.hour + ( this.minute + madd ) / this.MIN_PER_HOUR ), 
             ( this.minute + madd ) % this.MIN_PER_HOUR );
  } //end addMinutes(int)

  /**
   * toString: convert the time to String (hh:mm)
   * 
   * @return    a String, representing the time in 24-hour format.
   */
  public String toString() {
    String min = "";
    if ( this.minute < 10 ) //only one digit!  Should display two!
      min = "0" + Integer.toString( this.minute );
    else
      min = Integer.toString( this.minute );
    //end if

    return Integer.toString( this.hour ) + ":" + min;
  } //end toString()

  /**
   * toString: convert the time to String (hh:mm AM|PM, or hh:mm) according to the desired format (12-hour or 24-hour)..
   * 
   * @param fmt     a boolean, true if 12-hour format is desired; false if 24-hour format is desired.
   * @return        a String, representing the time in the given format (12-hour or 24-hour).
   */
  public String toString( boolean fmt ) {
    //fmt values: false = 24 hour, true = 12 hour
    if (fmt) { //if fmt == 1 [true] (12-hour)
      //handle hour...
      int hour12 = ( this.hour % 12 );
      String time = "";
      if ( ( this.hour / 12 ) == 0 ) //find AM/PM
        time = "AM";
      else
        time = "PM";
      //end if
      if ( hour12 == 0 ) //0 doesn't make sense in 12-hour notation!
        hour12 = 12;
      //end if

      //handle minute...
      String min12 = "";
      if ( minute < 10 ) //only one digit!  Should display two!
        min12 = "0" + Integer.toString( this.minute );
      else
        min12 = Integer.toString( this.minute );
      //end if
        
      return Integer.toString( hour12 ) + ":" + min12 + " " + time;
    }
    else //fmt ==  false (24-hour)
      return this.toString();
    //end if
  } //end toString(boolean)
  
  /**
    * Test method -- every class should have one.
    */
  public static void test() {
    // Create new Clock24 object with time 13:00 (1:00 PM)
    Clock24 myClock = new Clock24(13);
 
    System.out.println("Test cases");
    System.out.println("----------");
    
    // Each test case consists of an actual value and an expected value.
    // ----------------------------------------------------------------
    
    // Print out the current time, first in 24 hour format, then in 12.
    System.out.print( "myClock's time is now set to " + myClock + " " );
    System.out.println( "(or in 12-hour format, " + myClock.toString(true) + ")" );
    System.out.println("That should have printed 13:00 (or in 12-hour format, 1:00 PM)."); 
    System.out.println("---------------------------------------------------------------");
    myClock.addMinutes(150); //effectively add 2.5 hours to the current time
    System.out.println( "myClock's time after adding 150 minutes: " + myClock + " (" + myClock.toString(true) + ")" );
    System.out.println("That should have printed 15:30 (3:30 PM)"); 
    System.out.println("--------------------------------------------------------------");
    myClock.addMinutes(330); //add 5.5 more hours to the current time
    System.out.println( "myClock's time after adding 330 more minutes: " + myClock + " (" + myClock.toString(true) + ")" );
    System.out.println("That should have printed 21:00 (9:00 PM)"); 
    System.out.println("-------------------------------------------------------------");
    myClock.addMinutes(180); //add 3 hours - just enough to bring the clock around to 0:00
    System.out.println( "myClock's time after adding 180 more minutes: " + myClock + " (" + myClock.toString(true) + ")" );
    System.out.println("That should have printed 0:00 (12:00 AM)"); 
    System.out.println("------------------------------------------------------------");
    
    // Test the addHours method, by quickly passing another day by in increments of 6 hours.
    for ( int i = 1; i <= 4; i++ ) {
      myClock.addHours(6); //add 6 hours to the current time
      System.out.println( "myClock's time after adding 6 more hours: " + myClock + " (" + myClock.toString(true) + ")" );
    }
    
    System.out.println("That should have printed 0:00 (12:00 AM)"); 
    System.out.println("-----------------------------------------------------------");
    System.out.println("End of tests.");
  } //end test

} //end class