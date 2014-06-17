
import javax.naming.LimitExceededException;

import org.junit.Before;
import org.junit.Test;

import com.calculator.lcm.LcmCalculator;
import com.calculator.lcm.NegativeNoException;
import com.calculator.lcm.NonIntegerException;


public class  LcmCalculatorTest {

	private LcmCalculator calculator;

	@Before
	public void before() {
		calculator = new LcmCalculator();
	}

	@Test(expected = NegativeNoException.class)
	public void testNegativeNoException() throws NegativeNoException,
			NonIntegerException, LimitExceededException {
		calculator.calculateAverage(-2);
	}

	@Test
	public void testavg() throws NegativeNoException, NonIntegerException, LimitExceededException {
		org.junit.Assert.assertEquals(Long.valueOf(32), Long.valueOf(calculator.calculateAverage(10)));
	}
	
	@Test
	public void testavg1() throws NegativeNoException, NonIntegerException, LimitExceededException {
		System.out.println(Long.valueOf(calculator.calculateAverage(1000000)));
	}


}
