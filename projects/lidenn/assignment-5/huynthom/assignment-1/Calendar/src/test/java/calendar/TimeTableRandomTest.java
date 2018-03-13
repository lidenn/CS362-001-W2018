package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"deleteAppt", "getApptRange", "getApptError"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */

	@Test
	public void timeTableTest()  throws Throwable  {
		System.out.println("timeTable Testing");

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				GregorianCalendar day = new GregorianCalendar(2018, 6, 2);
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="one";
				String description="one";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);

				int startHour2=ValuesGenerator.RandInt(random);
				int startMinute2=ValuesGenerator.RandInt(random);
				int startDay2=ValuesGenerator.RandInt(random);;
				int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2=ValuesGenerator.RandInt(random);
				String title2="two";
				String description2="two";
				//Construct a new Appointment object with the initial data
				Appt appt2 = new Appt(startHour2,
						startMinute2 ,
						startDay2 ,
						startMonth2 ,
						startYear2 ,
						title2,
						description2);


				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					if (methodName.equals("deleteAppt")) {
						TimeTable timetable = new TimeTable();
						LinkedList<Appt> listAppts = new LinkedList<Appt>();
						listAppts.add(appt);
						listAppts.add(appt2);
						timetable.deleteAppt(listAppts, appt2);
						timetable.deleteAppt(listAppts, appt);
						timetable.deleteAppt(listAppts, null);
						timetable.deleteAppt(null, appt);
						assertEquals(null, timetable.deleteAppt(null, appt));
					}
					else if (methodName.equals("getApptRange")) {
						int thisDay=ValuesGenerator.RandInt(random);
						int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int thisYear=ValuesGenerator.RandInt(random);
						int nextDay=ValuesGenerator.RandInt(random);
						GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
						GregorianCalendar tomorrow = new GregorianCalendar(thisYear, thisMonth, thisDay+3);
						CalDay calday = new CalDay(today);
						calday.addAppt(appt);
						calday.addAppt(appt2);
						TimeTable timetable = new TimeTable();
						LinkedList<Appt> listAppts = new LinkedList<Appt>();
						listAppts.add(appt2);
						listAppts.add(appt);

						timetable.getApptRange(listAppts, today, tomorrow);
					}
					else if (methodName.equals("getApptError")) {
						int thisDay=ValuesGenerator.RandInt(random);
						int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int thisYear=ValuesGenerator.RandInt(random);
						int nextDay=ValuesGenerator.RandInt(random);
						GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
						GregorianCalendar errorDay = new GregorianCalendar(thisYear, thisMonth, thisDay-3);
						CalDay calday = new CalDay(today);
						calday.addAppt(appt);
						calday.addAppt(appt2);
						TimeTable timetable = new TimeTable();
						LinkedList<Appt> listAppts = new LinkedList<Appt>();
						listAppts.add(appt2);
						listAppts.add(appt);

						//Results in error based on lastday before first day, not sure how to catch
						//timetable.getApptRange(listAppts, today, errorDay);

					}
				}



				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}


		System.out.println("Done testing...");


	}
}

