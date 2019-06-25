package assignment_6;

import java.util.*;

public class CalendarBuilder {

	public static void main(String args[]) throws MonthException {
		//successful date calendar objects
		Calendar[] tdates = new Calendar[10];
		//potential calendar objects
		Calendar [] dates = new Calendar [100];
		Scanner scan = new Scanner(System.in);
		//variables for program functionality
		String date = " ";
		String event;
		String user_response;
		int temp = 0;
		boolean good = false;
		//loop to ask for user information
		while(good == false) {
			System.out.println("Enter a date: ");
			date = scan.nextLine();
			System.out.println("Enter an event: ");
			event = scan.nextLine();
			//checks to make sure user is entering valid information
			try {
				dates[temp] = new Calendar(date, event);
				dates[temp].checkMonth();
				dates[temp].checkDay();
				dates[temp].checkYear();
				//sets successful object
				tdates[temp] = dates[temp];
				//output if date is created
				System.out.println(temp + 1 + ". Date Created");
				temp++;
			}
			//catches potential errors
			catch(MonthException me) {
				System.out.println(me);
			}
			catch(DayException de) {
				System.out.println(de);
			}
			catch(YearException ye) {
				System.out.println(ye);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("No more space");
			}
			catch(NullPointerException ne) {
				System.out.println("");
			}
			//asks user to continue or quit
			System.out.println("Continue or Quit (c or q): ");
			user_response = scan.nextLine();
			
			if(user_response.equals("q")) {
				good = true;
			}
			else {
				good = false;
			}
		}
		//prints out list of dates and events
		for(int i = 0; i < 10; i++) {
			if(dates[i]!=null) {
				System.out.println(i+1 +". Date: " + tdates[i].getMonth() + " " + tdates[i].getDay() +", " + tdates[i].getYear());
				System.out.println("Event: " + tdates[i].getEventName());
			}
			else {
				System.out.println(" ");
			}
		}
	}
}
