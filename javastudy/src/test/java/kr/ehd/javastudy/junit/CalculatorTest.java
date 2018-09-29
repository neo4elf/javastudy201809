package kr.ehd.javastudy.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void plus() throws Exception{
		int result = this.calculator.plus(2, 5);
		
		assertThat(result, is(7));
	}
	
	@Test
	public void plus_multiple() throws Exception{
		int result = this.calculator.plus(1, 2, 3, 4);
		
		assertThat(result, is(10));
	}
	
}
