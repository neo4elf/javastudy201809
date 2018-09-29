package kr.ehd.javastudy.junit;

import java.util.Arrays;

public class Calculator {
	
	public int plus(int target1, int target2) {
		return target1 + target2;
	}
	
	public int plus(int... targets) {
		return Arrays.stream(targets).sum();
	}

}
