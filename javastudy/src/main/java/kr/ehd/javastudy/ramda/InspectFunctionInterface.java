package kr.ehd.javastudy.ramda;

import java.math.BigDecimal;
import java.util.function.Function;

public class InspectFunctionInterface {

	public static void main(String[] args) {
		Function<String, Integer> fnc = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		
		System.out.println("int value : " + fnc.apply("100"));
		
		fnc = (String value)-> Integer.parseInt(value);

		System.out.println("int value : " + fnc.apply("200"));
		
		fnc = value-> Integer.parseInt(value);
		
		System.out.println("int value : " + fnc.apply("300"));
		
		print(1, 2, 3, (i1, i2, i3)-> i1 + i2 + i3);
		print("Area is ", 4, 5, (message, i1, i2)-> message + (i1 * i2));
		print(13L, "Kyle", "neo4elf@gmail.com", (id, name, email)->String.format("id = %d, name = %s, email = %s", id, name, email));
		
		System.out.println("# Non Generic Function");
		
		print2(new BigDecimal("120.00"), bd->"$"+bd.toString());
	}
	
	public static <T1, T2, T3, R> void print(T1 t1, T2 t2, T3 t3, CustomFunction<T1, T2, T3, R> fnc ) {
		System.out.println(fnc.apply(t1, t2, t3).toString());
	}
	
	public static void print2(BigDecimal bd, NonGenericFunction fnc) {
		System.out.println(fnc.getCurrency(bd));
	}

}

@FunctionalInterface
interface CustomFunction<T1, T2, T3, R>{
	R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface NonGenericFunction{
	String getCurrency(BigDecimal bd);
}

/*
 * 아래와 같이 @FunctionalInterface 정의시에 메소드가 제너릭 미소드인경우
 * 자바 8에서는 오류없이 컴파일이 되나 자바 10에서는 컴파일 시에 오류가 발생 함
 * 오류 이유는 @FunctionalInterface 는 람다식을 사용 할 수 있는 인터페이 임에도 불구 하고
 * 내부 메소드가 제너릭으로 되어 있어 람다식으로 함수 정의 할때 타입을 추측(추론) 할 수 없기 때문 임 
 */
//@FunctionalInterface
//interface InvalidFunction{
//	<T> getMessage(T obj);
//}

