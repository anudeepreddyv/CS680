package edu.umb.cs680.hw01;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	@Test
	 public void primes() {
	       PrimeGenerator primeGenerator = new PrimeGenerator(1, 30);
	       primeGenerator.generatePrimes();
	       Long[] expectedprimes = { 2L, 3L, 5L, 7L,11L, 13L, 17L, 19L, 23L, 29L };
	       assertArrayEquals(expectedprimes, primeGenerator.getPrimes().toArray());
	 }


	 @Test
	 public void noPrimes() {
	       PrimeGenerator primeGenerator = new PrimeGenerator(14, 16);
	       primeGenerator.generatePrimes();
	       assertEquals(primeGenerator.getPrimes().size(), 0);
	 }

 
	    @Test
	    public void invalidInputRangeStartNegativeNumber() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(-10, 1);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=-10 to=1", ex.getMessage());
	        }
	    }

	    @Test
	    public void invalidInputRangeEndNegativeNumber() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(10, -1);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=-1", ex.getMessage());
	        }
	    }

	   

	    @Test
	    public void invalidInputRangeValues() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(10, 0);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=0", ex.getMessage());
	        }
	    }

	    @Test
	    public void BothValuesInRangeAreZeroes() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(0, 0);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=0 to=0", ex.getMessage());
	        }
	    }

	    @Test
	    public void BothValuesInRangeAreEqual() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(10, 10);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=10 to=10", ex.getMessage());
	        }
	    }

	    @Test
	    public void RangeWithNegativeValues() {
	        try {
	            PrimeGenerator primeGenerator = new PrimeGenerator(-10, -1);
	            primeGenerator.generatePrimes();
	        } catch (RuntimeException ex) {
	            assertEquals("Wrong input values: from=-10 to=-1", ex.getMessage());
	        }
	    }
}
