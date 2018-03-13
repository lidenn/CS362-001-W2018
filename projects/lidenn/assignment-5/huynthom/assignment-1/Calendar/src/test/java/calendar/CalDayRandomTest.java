package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */


public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	 @Test
	  public void testAddAppt()  throws Throwable  {
		 System.out.println("isValid Testing");

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 GregorianCalendar day = new GregorianCalendar(2018, 6, 2);
			 	CalDay today = new CalDay(day);
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
				 String title2="two";
				 String description2="two";
				 //Construct a new Appointment object with the initial data
				 Appt appt2 = new Appt(startHour2,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						 description);

				 today.addAppt(appt);
				 today.addAppt(appt2);





				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
		 
		 
	 }


	
}
