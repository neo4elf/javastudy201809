package kr.ehd.javastudy.ramda;

import java.util.function.Function;

public class InspectHigherOrderFunction {

	public static void main(String[] args) {
		InspectHigherOrderFunction self = new InspectHigherOrderFunction();
		
		self.doWorks();

	}

	private void doWorks() {
		test01();
		
	}

	private void test01() {
		// 함수의 인자 값으로 함수를 받기
		Function<Function<Integer, String>, String> f01 = f1->f1.apply(10);
		
		System.out.println("f01 : " + f01.apply(i-> "#" + i));
		
		// 함수의 리턴값으로 함수 보내기
		Function<Integer, Function<Integer, Integer>> f02 = i -> i2-> i + i2;
		
		System.out.println("f02 : " + f02.apply(2).apply(3));
		
		Function<Integer, Function<Integer, Function<Integer, Integer>>> f03 = i1->i2->i3->i1+i2+i3;
		
		System.out.println("f03.apply(10)                    : " + f03.apply(10));
		System.out.println("f03.apply(10).apply(20)          : " + f03.apply(10).apply(20));
		System.out.println("f03.apply(10).apply(20).apply(5) : " + f03.apply(10).apply(20).apply(5));
		
	}

}
