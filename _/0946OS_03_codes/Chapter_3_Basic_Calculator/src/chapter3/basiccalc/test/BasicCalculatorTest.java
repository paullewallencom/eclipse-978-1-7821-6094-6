package chapter3.basiccalc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import chapter3.basiccalc.BasicCalculator;

public class BasicCalculatorTest {
	
	private static BasicCalculator calculator;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setup() {
		calculator = new BasicCalculator();
	}
	
	@After
	public void teardown() {
		calculator.clear();
	}

	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(2);
		//result should be 4
		assertEquals(4 /*expected*/, calculator.getResult() /*actual*/);
	}

	@Test
	public void testSubtract() {
		calculator.add(35);
		calculator.subtract(5);
		assertEquals(30, calculator.getResult());
	}

	@Test
	public void testAddResultToTempAt() {
		calculator.add(9);
		calculator.addResultToTempAt(1);
		int[] temps = calculator.getTemps();
		assertEquals(9, temps[1]);
	}

	@Ignore
	@Test(timeout=1000)
	public void testSquareRoot() {
		while(true);
	}
 
	@Test
	public void testDivide() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("/ by zero");
		calculator.add(10);
		calculator.divide(0);
	}

	@Test
	public void testMultiply() {
		calculator.add(10);
		calculator.multiply(3);
		assertEquals(30, calculator.getResult());
	}

	@Ignore("Not implemented yet")
	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Ignore("Not implemented yet")
	@Test
	public void testClearTemps() {
		fail("Not yet implemented");
	}

}
