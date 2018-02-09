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
		 timeTable.deleteAppt(listAppts, appt2);

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
}
