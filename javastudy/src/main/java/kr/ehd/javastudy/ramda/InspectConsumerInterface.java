package kr.ehd.javastudy.ramda;

import java.util.function.Consumer;

public class InspectConsumerInterface {

	public static void main(String[] args) {
		// Function 과 비슷하나 리턴값이 없는 (void) 경우 사용
		Consumer<String> print = (String value)->System.out.println(value);
		
		print.accept("hello kyle");

	}

}
