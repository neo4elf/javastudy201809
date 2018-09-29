package kr.ehd.javastudy.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;

public class RandomCalculatorTest {

	@Test
	public void plus() throws Exception{
		RandomCalculator randomCalculator = new RandomCalculator(new Random(), new Calculator());
		
		int result = randomCalculator.plus(2, 5);
		
		assertThat(result, is(10));
	}
	
	@Test
	public void plus_mockito() throws Exception{
		// given
		Random random = mock(Random.class);
		when(random.nextInt()).thenReturn(3);
		RandomCalculator randomCalculator = new RandomCalculator(random, new Calculator());
		
		int result = randomCalculator.plus(2, 5);
		
		assertThat(result,is(10));
	}
}
