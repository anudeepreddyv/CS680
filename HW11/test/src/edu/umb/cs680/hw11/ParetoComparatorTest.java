package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;


import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
class ParetoComparatorTest {
static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "IOP", 2019, 15000, 9500);
		Car car2 = new Car("VW", "ABC", 2002, 45000, 28000);
		Car car3 = new Car("Ford", "ASD", 2010, 30000, 25000);
		
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
	}
	
	@Test
	void checkCar1AfterSort() {
		Car car1 = new Car("Toyota", "IOP", 2019, 15000, 9500);
		carList.sort(new MileageComparator());
		assertEquals(car1, carList.get(2));
	}
	
	@Test
	void checkCar2AfterSort() {
		Car car2 = new Car("VW", "ABC", 2002, 45000, 28000);
		carList.sort(new MileageComparator());
		assertEquals(car2, carList.get(0));
	}
	
	@Test
	void checkCar3AfterSort() {
		Car car3 = new Car("Ford", "ASD", 2010, 30000, 25000);
		carList.sort(new MileageComparator());
		assertEquals(car3, carList.get(1));
	}
	
}