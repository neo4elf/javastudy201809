package kr.ehd.javastudy.ramda;

import java.util.Arrays;
import java.util.List;

public class InspectRamda {
	
	private int number = 100;

	public static void main(String[] args) {
		InspectRamda self = new InspectRamda();
		
		System.out.println("----------");
		System.out.println("Access local variable");
		self.testRamda1();
		
		System.out.println("----------");
		System.out.println("Access non local variable(free variable)");
		self.testRamda2();
		
		System.out.println("----------");
		self.testRamda3();

	}

	// Access local variable
	private void testRamda1() {
		int number = 50;

		// case 1
		testRunnable(new Runnable() {

			@Override
			public void run() {
				System.out.println("number is " + number);
			}
		});
		
		// case 2
		testRunnable(()->System.out.println("number is " + number));
		
	}
	
	// Access non local variable(free variable)
	private void testRamda2() {
		int number = 50;
		
		// case 1
		testRunnable(new Runnable() {

			@Override
			public void run() {
				System.out.println("number is " + InspectRamda.this.number);
			}
		});
		
		// case 2
		testRunnable(()->System.out.println("number is " + number));
		
		// case 3
		testRunnable(()->System.out.println("number is " + this.number));
	}
	
	void testRunnable(Runnable runnable) {
		runnable.run();
	}
	
	private void testRamda3() {
		List<String> list = Arrays.asList("z", "f", "c", "s");
		
		System.out.println("list : " + list);
		System.out.println("after sort");
		list.sort((s1, s2)-> s1.compareTo(s2) );
		System.out.println("list : " + list);
	}

}
