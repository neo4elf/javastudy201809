package kr.ehd.javastudy.java8;

import static java.lang.System.out;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class JodaTime {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2017, 9, 23);
		LocalTime localTime = LocalTime.of(19, 57, 10);
		LocalDateTime localDateTime = LocalDateTime.of(2017,9,23,9,59,10);

		
		out.println(localDate);
		out.println(localTime);
		out.println(localDateTime);
		
		// localDate 자체는 변경되지 않고 연산 결과만 반환
		out.println(localDate.withMonth(5));
		out.println(localDate.withDayOfMonth(10));
		out.println(localDate.plusDays(10));
		out.println(localDate.minusDays(10));

		LocalDate localDate1 = LocalDate.of(2017, 3, 1);
		LocalDate localDate2 = LocalDate.of(2017, 3, 30);
		LocalTime localTime1 = LocalTime.of(17, 30, 30);
		LocalTime localTime2 = LocalTime.of(17, 31, 0);

		out.println(Period.between(localDate1, localDate2).getDays());
		out.println(Duration.between(localTime1, localTime2).getSeconds());



		
	}

}
