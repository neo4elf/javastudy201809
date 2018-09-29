package kr.ehd.javastudy.stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InspectStram01 {

	public static void main(String[] args) {
		InspectStram01 self = new InspectStram01();
		
//		self.testStream();
//		self.testStream01();
		self.testStream02();
	}
	
	private void testStream02() {
		System.out.println("collect(toList()) : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.collect(toList())
		);
		
		System.out.println("collect(toSet()) : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.collect(toSet())
		);
		
		System.out.println("distinct().collect(toList()) : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.map(i -> "#" + i)
				.distinct()
				.collect(toList())
		);
		
		System.out.println("distinct().collect(joining()) : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.map(i -> "#" + i)
				.distinct()
				.collect(joining())
		);
		
		System.out.println("distinct().collect(joining()) : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.map(i -> "#" + i)
				.distinct()
				.collect(joining(", ", "[", "]"))
		);
		
		System.out.println("distinct().count() : " + 
				Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
				.filter(i -> i > 3)
				.map(i -> i * 2)
				.map(i -> "#" + i)
				.distinct()
				.count()
		);
		
		System.out.print("distinct().forEach() : ");
		Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
		      .distinct()
		      .forEach(i -> System.out.print(i + " "));
		
	}

	private void testStream() {
		
		IntStream.range(0, 10).forEach(i->System.out.print(i + " "));
		System.out.println("");
		IntStream.rangeClosed(1, 10).forEach(i->System.out.print(i + " "));
		
//		Stream.iterate(BigDecimal.ONE, bd->bd.add(BigDecimal.ONE)).forEach(bd->System.out.println(bd + " "));
		Stream.iterate(BigDecimal.ONE, bd->bd.compareTo(new BigDecimal("1000")) < 0, bd->bd.add(BigDecimal.ONE)).forEach(bd->System.out.println(bd));
	}
	
	private void testStream01() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		List<Integer> filteredList = null;
		AtomicInteger count = new AtomicInteger(0);
		Predicate<Integer> greaterThan3 = i -> {
			System.out.println(count.addAndGet(1) + " : i > 3 ");
			return i > 3;
		};
		Predicate<Integer> lessThan9 = i -> {
			System.out.println(count.addAndGet(1) + " : i < 9 ");
			return i < 9;
		};
		Predicate<Integer> lessThan10 = i -> {
			System.out.println(count.addAndGet(1) + " : i > 10 ");
			return i > 10;
		};
		Function<Integer, Integer> doubled = i -> {
			System.out.println(count.addAndGet(1) + " : i * 2 ");
			return i * 2;
		};
		
		System.out.println("Original list : " + list);
		filteredList = filter(list, greaterThan3);
		System.out.println("Greater than 3 filtered list : " + filteredList);
		filteredList = filter(filteredList, lessThan9);
		System.out.println("Less than 9 filtered list : " + filteredList);
		filteredList = map(filteredList, doubled);
		System.out.println("Doubled list : " + filteredList);
		filteredList = filter(filteredList, lessThan10);
		System.out.println("Less than 10 filtered list : " + filteredList.get(0));
		
		System.out.println("=================================================");
		count.set(0);
		System.out.println(
		list.stream().filter(greaterThan3)
					.filter(lessThan9)
					.map(doubled)
					.filter(lessThan10)
					.findFirst()
//					.get()
		);
		
		System.out.println("finally list is " + list);

	}
	
	private <T> List<T> filter(List<T> list, Predicate<T> filter){
		List<T> result = new ArrayList<>();
		for (T t : list) {
			if(filter.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	private <T, R> List<R> map(List<T> list, Function<T, R> fnc){
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(fnc.apply(t));
		}
		return result;
	}

}
