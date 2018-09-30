package kr.ehd.javastudy.junit;

import java.util.Arrays;

public class Calculator {
	
	public int plusSingle(int target1, int target2) {
		return target1 + target2;
	}
	
	public int plusMulti(int... targets) {
		return Arrays.stream(targets).sum();
	}

}
