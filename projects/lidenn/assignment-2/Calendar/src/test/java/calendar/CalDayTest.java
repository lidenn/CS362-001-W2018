package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			int day = 25;
			int month = 12;
			int year = 2018;

			GregorianCalendar Day = new GregorianCalendar(year, month, day);

		 CalDay Christmas = new CalDay(Day);
		 assertEquals(25, Christmas.getDay());
		 assertEquals(12, Christmas.getMonth());
		 assertEquals(2018, Christmas.getYear());


	 }

	 //Test adds a appointment
	 @Test
	  public void test02()  throws Throwable  {
		 int day = 25;
		 int month = 12;
		 int year = 2018;

		 GregorianCalendar Day = new GregorianCalendar(year, month, day);

		 CalDay Christmas = new CalDay(Day);
		 assertEquals(25, Christmas.getDay());
		 assertEquals(12, Christmas.getMonth());
		 assertEquals(2018, Christmas.getYear());

		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 //Add Appointment
		 Christmas.addAppt(appt);
		 assertEquals(1, Christmas.getSizeAppts());
		 assertEquals("01/15/2017", Christmas.toString());
	 }
//add more unit tests as you needed	
}
