package kr.ehd.javastudy.junit;

import java.util.Random;

public class RandomCalculator {
	private Random random;
	private Calculator calculator;
	
	public RandomCalculator(Random random, Calculator calculator) {
		this.random = random;
		this.calculator = calculator;
	}

	public int plus(int i1, int i2) {
		return this.calculator.plusSingle(i1, i2);
	}
	
	public int plus(int... targets) {
		return this.calculator.plusMulti(targets) + this.random.nextInt();
	}

}
