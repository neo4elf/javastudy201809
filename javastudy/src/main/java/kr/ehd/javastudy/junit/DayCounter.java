package kr.ehd.javastudy.junit;

import java.util.Calendar;

public class DayCounter {

	public int MILLI_PER_DAY = 1000*60*60*24;
	private Calendar day1 = null;
	private Calendar day2 = null;
	
	public void setDay1(Calendar day) {
		this.day1 = day;
	}
	
	public Calendar getDay1() {
		return this.day1;
	}

	public void setDay2(Calendar day) {
		this.day2 = day;
	}
	
	public Calendar getDay2() {
		return this.day2;
	}
	
	public long getDays() {
		long l_remain_date = day1.getTime().getTime() - day2.getTime().getTime();
		
		long remain_date = l_remain_date/MILLI_PER_DAY;
		
		return remain_date;
	}
	
	public static void main(String[] args) {
		DayCounter counter = new DayCounter();
		Calendar day = Calendar.getInstance();
		
		day.set(2003, 10, 5);
		counter.setDay1(day);
		
		day = Calendar.getInstance();
		day.set(2002, 6, 2);
		counter.setDay2(day);
		
		System.out.println(String.format("day1 - day2 = %d", counter.getDays()));
	}

}
