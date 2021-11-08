package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class CalculatorTest {

	@Test
    public void Addition_2And4() throws Exception{
		    Calculator calculator = new Calculator();
		    double number = calculator.Addition(2, 4);
		    assertEquals(6, number);
		}
	
	
	@Test
	   public void Subtraction_7And3() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Subtraction(7, 3);
			assertEquals(4, number);
		}
	
	
	@Test
	   public void Subtraction_4And6() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Subtraction(4, 6);
			assertEquals(-2, number);
		}
	
	
	@Test
	   public void Multiply_6And4() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Multiply(6, 4);
			assertEquals(24, number);
		}
	
	
	@Test
	   public void Multiply_0And0() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Multiply(0, 0);
			assertEquals(0, number);
		}
	
	
	@Test
	   public void Division_6And3() throws Exception{
			Calculator calculator = new Calculator();
			double number = calculator.Division(6, 3);
			assertEquals(2, number);
			
		}
	
	
	@Test
	   public void Division_8By0() throws Exception{
		    Calculator calculator = new Calculator();
		    try {
		    	calculator.Division(8, 0);
			    fail("Undefined!!");
			    } catch (IllegalArgumentException ex) {
			    	assertEquals("Undefined!!", ex.getMessage());		
		}
	}

}