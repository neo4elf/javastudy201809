package kr.ehd.javastudy.ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class InspectPredicateInterface {

	public static void main(String[] args) {
		// Function<T, Boolean> 과 동일 함
		Predicate<Integer> isPositive = i -> i > 0;
		
		System.out.println(isPositive.test(1));
		System.out.println(isPositive.test(0));
		System.out.println(isPositive.test(-1));
		
		List<Integer> list = Arrays.asList(-5, -4, -3, -2, -1, 0 , 1, 2, 3, 4, 5);
		
		System.out.println(filter(list, i-> i > 0));
		System.out.println(filter(list, i-> i < 3));
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> filter){
		List<T> result = new ArrayList<>();
		
		for(T input:list) {
			if (filter.test(input)) {
				result.add(input);
			}
		}
		
		return result;
	}

}
