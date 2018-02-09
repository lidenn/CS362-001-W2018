package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int day = 02;
		 int month = 06;
		 int year = 2018;

		 GregorianCalendar Day = new GregorianCalendar(year, month, day);

		 CalDay Today = new CalDay(Day);
		 assertEquals(02, Today.getDay());
		 assertEquals(06, Today.getMonth());
		 assertEquals(2018, Today.getYear());

		 int startHour=7;
		 int startMinute=30;
		 int startDay=02;
		 int startMonth=06;
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


		 int startHour2=9;
		 int startMinute2=30;
		 int startDay2=02;
		 int startMonth2=06;
		 int startYear2=2018;
		 String title2="Birthday Party 2";
		 String description2="This is my birthday party 2.";
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2 ,
				 title2,
				 description2);

		 //Add Appointment
		 Today.addAppt(appt);
		 Today.addAppt(appt2);
		 Today.iterator();
		 assertEquals(2, Today.getSizeAppts());


		 //Temp Day to test GetAppts
		 int day2 = 02;
		 int month2 = 06;
		 int year2 = 2018;

		 GregorianCalendar tempDay = new GregorianCalendar(year, month, day);

		 CalDay tempToday = new CalDay(tempDay);
		 tempToday.addAppt(appt);
		 tempToday.addAppt(appt2);
		 assertEquals(tempToday.getAppts(), Today.getAppts());

		 //Test To string

		 StringBuilder sb = new StringBuilder();


		 String todayDate = (month + "/" + day + "/" + year);
		 sb.append("\t --- " + todayDate + " --- \n");
		 sb.append(" --- -------- Appointments ------------ --- \n");
		 Iterator<Appt> itr = Today.appts.iterator();
		 while(itr.hasNext()) {
			 Object element = itr.next();
			 sb.append(element + " ");
			 }
		 sb.append("\n");

		 assertEquals( sb.toString(), Today.toString());


	 }

	 //Test adds a appointment
	 @Test
	public void test02()  throws Throwable  {
		 int Day=29;
		 int Month=5;
		 int Year=2018;
		 GregorianCalendar today = new GregorianCalendar(Year, Month, Day);
		 CalDay calday = new CalDay(today);
		 assertTrue(calday.isValid());


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

		 calday.addAppt(appt);
		 assertNotEquals(null, calday.toString());



	}

//add more unit tests as you needed	
}
