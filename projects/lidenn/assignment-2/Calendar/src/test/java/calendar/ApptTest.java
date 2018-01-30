package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable {
		 int startHour = 21;
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
		 String title = "Birthday Party";
		 String description = "This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
		 // assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

	 }
		 @Test
		 public void test02()  throws Throwable  {
		int startHour1=12;
		int startMinute1=50;
		int startDay1=17;
		int startMonth1=03;
		int startYear1=2018;
		String title1="Spring Break";
		String description1="Can't wait for.";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour1,
				startMinute1 ,
				startDay1 ,
				startMonth1 ,
				startYear1 ,
				title1,
				description1);
		assertTrue(appt1.getValid());
		assertEquals("01/15/2017", appt1.toString());
		assertEquals(10, appt1.compareTo(appt1));



		 
	 }
//add more unit tests as you needed
	
}
