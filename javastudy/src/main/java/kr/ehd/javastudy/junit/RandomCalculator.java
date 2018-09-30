package kr.ehd.javastudy.junit;

import java.util.Random;

public class RandomCalculator {
	private Random random;
	private Calculator calculator;
	
	public RandomCalculator(Random random, Calculator calculator) {
		this.random = random;
		this.calculator = calculator;
	}
	
	public int plus(int... targets) {
		return this.calculator.plus(targets) + this.random.nextInt();
	}

}
