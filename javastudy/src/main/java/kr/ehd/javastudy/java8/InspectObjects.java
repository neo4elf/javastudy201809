package kr.ehd.javastudy.java8;

import static java.lang.System.out;

import java.util.Objects;

public class InspectObjects {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		
		str2 = "test";
		
		// Null Point Exception 대응을 위한 코드
		out.println(Objects.equals(str1, str2));
		
		out.println(Objects.toString(str2));

		// if str1 is null then print str2
		out.println(Objects.toString(str1, str2));
	}

}
