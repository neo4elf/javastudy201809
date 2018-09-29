package kr.ehd.javastudy.ramda;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class InspectSupplierInterface {

	public static void main(String[] args) {
		InspectSupplierInterface self = new InspectSupplierInterface();
		
		System.out.println("process start");
		
		long start = System.currentTimeMillis();
		self.printMessage1(0, self.getMessage());
		self.printMessage1(-1, self.getMessage());
		
		System.out.println("it took " + ((System.currentTimeMillis() - start)/1000) + " seconds");
		
		start = System.currentTimeMillis();
		
		// 문자열이 전달되는 것이 아니라 함수가 전달되기 때문에 문자열이 출력될때만 함수가 실행되어
		// 불필요한 지연이 발생하지 않음
		self.printMessage2(0, ()->self.getMessage());
		self.printMessage2(-1, ()->self.getMessage());

		System.out.println("it took " + ((System.currentTimeMillis() - start)/1000) + " seconds");
	}
	
	String getMessage() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Kyle";
	}
	
	void printMessage1(int condition, String message) {
		if (condition >= 0) {
			System.out.println("Hello " + message);
		} else {
			System.out.println("Invalid");
		}
	}

	void printMessage2(int condition, Supplier<String> supplier) {
		if (condition >= 0) {
			System.out.println("Hello " + supplier.get());
		} else {
			System.out.println("Invalid");
		}
	}
}
