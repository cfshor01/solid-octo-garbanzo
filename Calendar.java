package assignment_6;
import java.lang.*;
import java.util.*;

public class Calendar {
	//variables created for program functionality
	private int day;
	private int year;
	private int month;
	private String EventName;
	String smonth;
	String sday;
	String syear;

	//list of month names
	private ArrayList<String> monthName = new ArrayList<String>();
	{
		monthName.add("January");
		monthName.add("February");
		monthName.add("March");
		monthName.add("April");
		monthName.add("May");
		monthName.add("June");
		monthName.add("July");
		monthName.add("August");
		monthName.add("September");
		monthName.add("October");
		monthName.add("November");
		monthName.add("December");
	}
	//list of number of days in each month
	ArrayList<Integer> numDays = new ArrayList<Integer>();
	{
		numDays.add(31);
		numDays.add(28);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
	}

	private String date;
	//calendar constructor to initialize date object
	public Calendar() {
		Calendar date = new Calendar("1/1/1900", null);
	}
	//second calendar object to set date and event name
	public Calendar(String date, String EventName)  {
		this.setDate(date);
		this.EventName = EventName;
	}
	//method which sets the date
	public void setDate(String date) {
		Scanner scandate = new Scanner(date);
		//sets date if user enters information as XX/XX/XXXX
		if(date.contains("/")) {
			scandate.useDelimiter("\\D+");
			month = scandate.nextInt();
			day = scandate.nextInt();
			year = scandate.nextInt();	

		}
		//sets date if user enters words
		else {
			for(int i = 0 ; i < 12; i++) {
				if(date.contains(monthName.get(i))) {
					smonth = monthName.get(i);
					scandate.useDelimiter("\\D+");
					day = scandate.nextInt();
					year = scandate.nextInt();	
					month = monthName.indexOf(smonth) + 1;
				}
			}
		}
	}
	//getter methods
	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String getEventName() {
		return EventName;
	}
	//checks if leap year
	public boolean checkLeapYear() {
		if(year %4 == 0) {
			if(year %100 == 0 & year%400 != 0) {
				return false;
			}
			return true;
		}
		else return false;
	}
	//checks to make sure that day exists
	public void checkDay() throws DayException {
		for(int i = 1; i < 13; i++) {
			if(month == i && month != 2) {
				if(day <= 0 || day > numDays.get(i-1)) {
					throw new DayException("Invalid Day");
				}
			}
		}
		if (month == 2) {
			if(checkLeapYear() == true) {
				if(day <= 0 || day > 29) {
					throw new DayException("Invalid Day");
				}
			}
			else {
				if (day <= 0 || day > 28) {
					throw new DayException("Invalid Day");
				}
			}
		}
	}
	//checks to make sure year exists
	public void checkYear() throws YearException {
		if (year != (int)year) {
			throw new YearException("Invalid Year");
		}
	}
	//checks to make sure month exists
	public void checkMonth() throws MonthException {
		if(month < 1 || month > 12) {
			throw new MonthException("Invalid Month");
		}
	}
	//gets month
	public String getMonth() {
		for(int i = 1; i < 13; i++) {
			if(month == i) {
				return monthName.get(i-1);
			}
		}
		return smonth;
	}
	//sets event
	public void setEvent(String EventName) {
		this.EventName = EventName;
	}
	//gets event date in specific format
	public String getEventDate(String dateFormat) {
		if(dateFormat.equals("Number")) {
			return("Date: " + month + "\\" + day +"\\" + year + "\nEventName" + EventName );
		}
		else {
			return("Date: " + date +"\n Event: " + EventName);
		}
	}


}
