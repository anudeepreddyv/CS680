package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class PrimeGeneratorTest {

	@Test
	 public void primes() {
	       PrimeGenerator primeGen = new PrimeGenerator(1, 30);
	       primeGen.generatePrimes();
	       Long[] expectedprimes = { 2L, 3L, 5L, 7L,11L, 13L, 17L, 19L, 23L, 29L };
	       assertArrayEquals(expectedprimes, primeGen.getPrimes().toArray());
	 }


	 @Test
	 public void noPrimes() {
	       PrimeGenerator primeGen = new PrimeGenerator(14, 16);
	       primeGen.generatePrimes();
	       assertEquals(primeGen.getPrimes().size(), 0);
	 }

  
	    @Test
	    public void invalidInputRangeStartNegativeNumber() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(-10, 1);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=-10 to=1", ex.getMessage());
	        }
	    }

	    @Test
	    public void invalidInputRangeEndNegativeNumber() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(10, -1);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=-1", ex.getMessage());
	        }
	    }

	   

	    @Test
	    public void invalidInputRangeValues() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(10, 0);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=0", ex.getMessage());
	        }
	    }

	    @Test
	    public void BothValuesInRangeAreZeroes() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(0, 0);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=0 to=0", ex.getMessage());
	        }
	    }

	    @Test
	    public void BothValuesInRangeAreEqual() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(10, 10);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=10", ex.getMessage());
	        }
	    }

	    @Test
	    public void RangeWithNegativeValues() {
	        try {
	            PrimeGenerator primeGen = new PrimeGenerator(-10, -1);
	            primeGen.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=-10 to=-1", ex.getMessage());
	        }
	    }

}