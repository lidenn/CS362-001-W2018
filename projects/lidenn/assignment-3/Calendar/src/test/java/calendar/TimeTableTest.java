package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018;
		 String title1="Christmas";
		 String description1="Merry Christmas";



		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 String title2="Easter";
		 String description2="He is risen!";


		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
		 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title1, description2);


		 listAppts.add(appt1);
		 listAppts.add(appt2);

		 int thisYear = 2018;
		 int thisMonth = 2;
		 int thisDay = 15;

		 int nextYear = 2018;
		 int nextMonth = 2;
		 int nextDay = 16;




		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar today2 = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar tomorrow = new GregorianCalendar(nextYear, nextMonth, nextDay);


		 TimeTable timeTable = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 assertNotEquals("Second date specified is not before the first date specified.", timeTable.getApptRange(listAppts, today, tomorrow));
		 int pv[] = {1, 0}; //Switches
		 timeTable.permute(listAppts, pv);

		 LinkedList<Appt> testAppts = new LinkedList<Appt>();
		 testAppts.add(appt1);
		 timeTable.deleteAppt(listAppts, appt2);
		// assertEquals(testAppts, listAppts);

		 TimeTable nullTable = new TimeTable();
		 assertEquals(null, nullTable.deleteAppt(listAppts, null));
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 // create another appointment
		 int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 listAppts.add(appt);
		 TimeTable timeTable=new TimeTable();
		 GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
		 assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
	 }
//add more unit tests as you needed

	@Test
	public void test03()  throws Throwable  {
		TimeTable timetable = new TimeTable();

		GregorianCalendar today = new GregorianCalendar(2018,01,01);

		Appt appt = new Appt(01, 01, 02, 01, 2018, "First", "First");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Second", "Second");
		Appt appt3 = new Appt(28,22, 22, 12, 2020, "Third", "Third");
		Appt appt4 = new Appt(02,40, 01, 02, 2019, "Fourth", "Fourth");
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);

		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		listAppts2.add(appt2);

		LinkedList<Appt> nullListAppts = null;



		assertEquals(null, timetable.deleteAppt(nullListAppts, appt));
		assertEquals(false, appt3.getValid());
		assertEquals(null, timetable.deleteAppt(listAppts, appt3));
		assertEquals(null, timetable.deleteAppt(listAppts, appt));

	}

	@Test
	public void test04()  throws Throwable  {
		TimeTable timetable = new TimeTable();

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Appt appt = new Appt(01, 01, 02, 01, 2018, "First", "First");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Second", "Second");
		Appt appt3 = new Appt(28,22, 22, 12, 2020, "Third", "Third");
		Appt appt4 = new Appt(02,40, 01, 02, 2019, "Fourth", "Fourth");


		int [] pv4 = {};
		timetable.permute(listAppts, pv4);

		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);
		int[] pv = {0, 1, 2};
		timetable.permute(listAppts, pv);



		LinkedList<Appt> newApptsTest = new LinkedList<Appt>();
		LinkedList<Appt> newAppts = new LinkedList<Appt>();

		newAppts.add(appt);
		newAppts.add(appt2);
		newApptsTest.add(appt2);
		newApptsTest.add(appt);

		int[] pv3 = {1,0}; //Testing to see if you can switch

		newAppts = timetable.permute(newAppts, pv3);


		System.out.print(newApptsTest.getFirst().toString());
		System.out.print(newAppts.getFirst().toString());

	}
}
