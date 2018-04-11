package Exercice_3;

public class Exercice_date_time {

	public static void main(String[] args) {
		//I create three objects, one for each class

		Date object_date = new Date(20,10,2017);
		Time object_time = new Time(16,45,5);
		DateTime object_final = new DateTime(object_date,object_time);
		
		//checks and tells the user if the input year is or not leap
		if(object_date.isLeapYear()==true) {
			System.out.println("The year:"+object_date.year+" is a leap year.");
		}else {
			System.out.println("The year:"+object_date.year+" is not a leap year.");
		}
		
		//checks and tells user the total days in the entered month
		System.out.println("Total days in the entered month: "+object_date.daysinMonth());
		
		//advances one day of the date 
		System.out.println("The day is going to be advance of one day.");
		object_date.advance_1day();
		System.out.println("The current date is: "+object_date.format(false, "/"));
		System.out.println("In US format: "+object_date.format(true, "/"));
		
		//How many seconds until midnight ? 
		System.out.println("There still "+object_time.secondsUntilMidnight()+" seconds left to midnight.");
		
		//Advances the time one second and if we got a new day, also advances one day in the date
		object_final.tick();
		
		//Finally prints the current time and date 
		object_final.print();
		
	}

}
