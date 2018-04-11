package Exercice_3;

import java.text.DecimalFormat;

class Date {
	int day,month,year,result_dim;
	DecimalFormat df = new DecimalFormat("00");
	
	Date(int day,int month,int year) {
		
		//setting var this.month
		if(month<=12) {
			this.month = month;
		}else if(month>12) {
			System.out.println("Month is too big, using december.");
			this.month = 12;
		}else if(month<0) {
			System.out.println("Month does not exist, using january.");
			this.month = 1;
		}
		
		//setting var this.day
		result_dim = daysinMonth(); // in case else happens daysinMonth() is only executed once.
		if(day <= result_dim) {
			this.day = day;
		}else {
			System.out.println(day+" is too big, using the last day of the current month.");
			this.day = result_dim;
		}
		
		//setting var this.year , 2^32 is the limit of the int type, prevent buffer overflow exploit
		if((year>Math.pow(2,32)) || (0>year)) {
			System.out.println("Year not valid, using 2017.");
			this.year = 2017;
		}else {
			this.year = year;
		}
	}
	
	//returns true if year is leap, false otherwise
	boolean isLeapYear() {
		if((year%4==0) && (year%100==0) && (year%400==0)) {
			return true;
		}else if((year%4==0) && (year%100!=0)) {
			return true;
		}else {
			return false;
		}
	}
	
	int daysinMonth() {
		if ((month==1) || (month==3) || (month==5) || (month==7) || (month==9) || (month==11)) {
			return 31;
		}else {
			if(month==2) {
				if(isLeapYear()==true) {
					return 29;
				}else  {
					return 28;
				}
			}else {
				return 30;
			}
		}
	}
	
	void advance_1day() {
		if((day==31) || (day==30)) {
			day = 1;
		}else if((month==2) && (isLeapYear()==true) && (day==29)) {
			day = 1;
		}else if((month==2) && (isLeapYear()==false) && (day==28)) {
			day = 1;
		}else if((month==12) && (day==31)) {
			month = 1;
		}else {
			day = ++day;
		}
	}
	
	/* Using the DecimalFormat method, it is not important if the int has or not a "0"
	 * in the left side. In case it is a two number decimal, like "20", the DecimalFormat 
	 * wont't change anything. 
	 * */
	 
	String format(boolean US, String delimeter) {
		String final_date;
		
		if(US!=true) {
			final_date = df.format(day)+delimeter+df.format(month)+delimeter+year;
			return final_date;
		}else {
			final_date = df.format(month)+delimeter+df.format(day)+delimeter+year;
			return final_date;
		}
		
	}
}

/*I did not understand what the exerice meant exeactly with : 
 * "Si les paramètres ne sont pas valides ils seront adaptés pour qu’ils représentent un temps correct."
 * there an enormous amount of possibilities where the parameters are not valid, do 
 * we have to take them all in consideration ?
 * */
 
class Time {
	int hours,minutes,seconds;
	DecimalFormat df = new DecimalFormat("00");
	
	Time(int hours, int minutes, int seconds) {
		if((hours>24) || (hours<0))	 {
			System.out.println("Hour enterd not valid, using 24h as input.");
			hours=24;
		}
		
		if((minutes>60) || (minutes<0)) {
			System.out.println("Minutes entered not valid, using 30 minutes as input.");
			minutes=30;
		}
		
		if((seconds>60) || (seconds<0)) {
			System.out.println("Seconds entered not valid, using 20 seconds as input.");
			seconds=20;
		}
		this.hours = hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}
	
	boolean tick() {
		if(seconds==60) {
			seconds=0;
			if(minutes==60) {
				minutes=0;
				if((hours==24) || (hours==00)) {
					hours=1;
				if(hours==23) {
					hours=hours++;
					return true;
					}else {
						hours=hours++;
					}
				}
			}else {
				minutes = minutes++;
			}
		}
		return false;
	}
	
	String format(boolean US) {
		String final_time;
		boolean pm = true;
		
		if(US) {
			if(hours==13) {hours=1;
			}else if(hours==14) {hours=2;
			}else if(hours==15) {hours=3;
			}else if(hours==16) {hours=4;
			}else if(hours==17) {hours=5;
			}else if(hours==18) {hours=6;
			}else if(hours==19) {hours=7;
			}else if(hours==20) {hours=8;
			}else if(hours==21) {hours=9;
			}else if(hours==22) {hours=10;
			}else if(hours==23) {hours=11;
			}else if((hours==24) || (hours==00)) {hours=12;
			}else {
				pm = false;
			}
			
			if(pm) {
				final_time = df.format(hours)+":"+df.format(minutes)+":"+df.format(seconds)+" PM";
				return final_time;
			}else {
				final_time = df.format(hours)+":"+df.format(minutes)+":"+df.format(seconds)+" AM";
				return final_time;
			}
		}else {
			final_time= df.format(hours)+":"+df.format(minutes)+":"+df.format(seconds);
			return final_time;
		}
	}
	
	/* I use the total number of seconds 24 hours have, finally 
	 * I subtract it the current seconds (which means the seconds since midnight
	 * and sum is the result of the seconds to midnight
	 * */
	 
	int secondsUntilMidnight( ) {
		int sof,cs,sum;
		sof = (24*3600); // total seconds of a day
		cs = ((hours*3600) + (minutes*60) + seconds); // current number of seconds
		sum = sof - cs; //seconds until midnight
		return sum;
	}
	
	int secondsSinceMidnight( ) {
		int cs;
		cs = ((hours*360) + (minutes*60) + seconds); // current number of seconds
		return cs;
	}
}

class DateTime {
	Date obj1;
	Time obj2;
	
	DateTime(Date obj1,Time obj2 ) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	void tick( ) {
		if(obj2.tick() == true) {
			obj1.advance_1day();
		}else {}
	}
	
	void print( ) {
		System.out.println("The current time is:"+obj2.format(false));
		System.out.println("The current day is:"+obj1.format(false, "/"));
	}
}
	

	
	

	


