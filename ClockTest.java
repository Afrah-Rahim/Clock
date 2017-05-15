
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClockTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockTest
{
    private Clock24 _clock24;

    /**
     * Default constructor for test class ClockTest
     */
    public ClockTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _clock24 = new Clock24();
        _clock24 = new Clock24(0);
        _clock24 = new Clock24(0,0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _clock24 = null;
    }

    /**
     * Test methods
     * /
     * 
     * //Test creation of clock24 objects
     */
    @Test
    public void testCreate()
    {
        //assert Equals of the _clock24 object created earlier
        assertEquals("Error in testCreate", 0, _clock24.getHour());
        assertEquals("Error in testCreate", 0, _clock24.getMinute());

        //test of object one:
        Clock24 clock1 = new Clock24(2,30);

        assertEquals("Error in testCreate", 2, clock1.getHour());
        assertEquals("Error in testCreate", 30, clock1.getMinute());

        //Test of object two:
        Clock24 clock2 = new Clock24(13,30);

        assertEquals("Error in testCreate", 13, clock2.getHour());
        assertEquals("Error in testCreate", 30, clock2.getMinute());

        //Test of object three:
        Clock24 clock3 = new Clock24(4);

        assertEquals("Error in testCreate", 4, clock3.getHour());
        assertEquals("Error in testCreate", 0, clock3.getMinute());

        //Test of object myClock:
        Clock24 myClock = new Clock24(13);

        assertEquals("Error in testCreate", 13, myClock.getHour());
        assertEquals("Error in testCreate", 0, myClock.getMinute());
    }

    //Test the setHour method of the Clock24 class
    @Test
    public void testSetHour()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(2, 30);
        clock1.setHour(5);

        Clock24 expectedTime = new Clock24(5, 30);
        int expectedHour = expectedTime.getHour();
        int actualHour = clock1.getHour();

        assertTrue("Error in testSetHour", (expectedHour == actualHour));

    }
    //Test the setMinute method of the Clock24 class
    @Test
    public void testSetMinute()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(3, 59);
        clock1.setMinute(20);

        Clock24 expectedTime = new Clock24(3, 20);
        int expectedMinute = expectedTime.getMinute();
        int actualMinute = clock1.getMinute();

        assertTrue("Error in testSetMinute", (expectedMinute == actualMinute));

    }
    //Test the setTime method of the Clock24 class
    @Test
    public void testSetTime()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(3, 0);
        clock1.setTime(5,50);

        Clock24 expectedTime = new Clock24(5, 50);
        Clock24 actualTime = clock1;

        assertTrue("Error in testSetTime", (actualTime.getHour() == expectedTime.getHour()));
        assertTrue("Error in testSetTime", (actualTime.getMinute() == expectedTime.getMinute()));

    }
    //Test the getHour method of the Clock24 class
    @Test
    public void testGetHour()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(4, 44);

        int expectedHour = 4;
        int actualHour = clock1.getHour();

        assertTrue("Error in testGetHour", (expectedHour == actualHour));

    }

    //Test the getMinute method of the Clock24 class
    @Test
    public void testGetMinute()
    {
        //Test object one:
        Clock24 clock1 = new Clock24( 1, 40);

        int expectedMinute = 40;
        int actualMinute = clock1.getMinute();

        assertTrue("Error in testGetMinute", (expectedMinute == actualMinute));

    }

    //Test the addMinutes method of the Clock24 class
    @Test
    public void testAddMinutes()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(5, 20);
        clock1.addMinutes(30);

        Clock24 expectedTime = new Clock24(5, 50);
        int expectedMinutes = expectedTime.getMinute();
        int actualMinutes = clock1.getMinute();

        assertTrue("Error in testAddMinutes", (expectedMinutes == actualMinutes));

        //Test object two:
        Clock24 clock2 = new Clock24 (6, 50);
        clock1.addMinutes(60);

        Clock24 expectedTime2 = new Clock24(7, 50);
        int expectedMinutes2 = expectedTime.getMinute();
        int actualMinutes2 = clock1.getMinute();

        assertTrue("Error in testAddMinutes", (expectedMinutes2 == actualMinutes2));

        //Test object myClock:
        Clock24 myClock = new Clock24 (13);
        myClock.addMinutes(150);

        Clock24 expectedTime3 = new Clock24(15, 30);
        int expectedMinutes3 = expectedTime3.getMinute();
        int actualMinutes3 = myClock.getMinute();

        assertTrue("Error in testAddMinutes", (expectedMinutes3 == actualMinutes3));

        myClock.addMinutes(330); //adds 5.5 hours more to myClock

        Clock24 expectedTime4 = new Clock24(9);
        int expectedMinutes4 = expectedTime4.getMinute();
        int actualMinutes4 = myClock.getMinute();

        assertTrue("Error in testAddMinutes", (expectedMinutes4 == actualMinutes4));

        myClock.addMinutes(180); //adds 3 hours more to myClock so it can hit 0:00

        Clock24 expectedTime5 = new Clock24(0);
        int expectedMinutes5 = expectedTime5.getMinute();
        int actualMinutes5 = myClock.getMinute();

        assertTrue("Error in testAddMinutes", (expectedMinutes5 == actualMinutes5));
    }

    //Test the addHours method of the Clock24 class
    @Test
    public void testAddHours()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(5, 40);
        clock1.addHours(2);

        Clock24 expectedTime = new Clock24(7, 40);
        int expectedHour = expectedTime.getHour();
        int actualHour = clock1.getHour();

        assertTrue("Error in testAddHours", (expectedHour == actualHour));

        //Test object myClock:
        Clock24 myClock = new Clock24(13);

        //adds increments of 6 hours to pass 24 hrs
        for ( int i = 1; i <= 4; i++ )
        {
            myClock.addHours(6); //add 6 hours to the current time
        }

        Clock24 expectedTime2 = new Clock24(13);
        int expectedHour2 = expectedTime2.getHour();
        int actualHour2 = myClock.getHour();

        assertTrue("Error in testAddHours", (expectedHour2 == actualHour2));
    }

    //Test the toString method of the Clock24 class
    @Test
    public void testToString()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(6, 20);

        String expectedOutput = "6:20";
        String actualOutput = clock1.toString();

        assertTrue("Error in testToString", expectedOutput.equals(actualOutput));

        //Test object two:
        Clock24 clock2 = new Clock24(3, 5);

        String expectedOutput2 = "3:05";
        String actualOutput2 = clock2.toString();

        assertTrue("Error in testToString", expectedOutput2.equals(actualOutput2));

    }

    //Test the toString conversion method of the CLock24 class
    @Test 
    public void testToStringConvert()
    {
        //Test object one:
        Clock24 clock1 = new Clock24(14, 15);

        String expectedOutput = "2:15 PM";
        String actualOutput = clock1.toString(true);

        assertTrue("Error in testToString", expectedOutput.equals(actualOutput));

        //Test object two:
        Clock24 clock2 = new Clock24(2, 15);

        String expectedOutput2 = "2:15 AM";
        String actualOutput2 = clock2.toString(true);

        assertTrue("Error in testToString", expectedOutput2.equals(actualOutput2));

        //Test object two:
        Clock24 clock3 = new Clock24(13, 35);

        String expectedOutput3 = "13:35";
        String actualOutput3 = clock3.toString(false);

        assertTrue("Error in testToString", expectedOutput3.equals(actualOutput3));

        //Test object myClock:
        Clock24 myClock = new Clock24(13);
        myClock.addMinutes(150); // adds 150 minutes (2.5 hrs)

        String expectedOutput4 = "3:30 PM";
        String actualOutput4 = myClock.toString(true);

        assertTrue("Error in testToString", expectedOutput4.equals(actualOutput4));

        myClock.addMinutes(330); //adds 330 minutes (5.5 hrs)

        String expectedOutput5 = "9:00 PM";
        String actualOutput5 = myClock.toString(true);

        assertTrue("Error in testToString", expectedOutput5.equals(actualOutput5));

        myClock.addMinutes(180); //adds enough minutes to set the clock to 0:00 or 12 AM

        String expectedOutput6 = "12:00 AM";
        String actualOutput6 = myClock.toString(true);

        assertTrue("Error in testToString", expectedOutput6.equals(actualOutput6));
    }
}
