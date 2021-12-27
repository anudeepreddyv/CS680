package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
class MileageComparatorTest {
static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "ASD", 2018, 10000, 9500);
		Car car2 = new Car("Hundai", "XYZ", 2002, 50000, 23000);
		Car car3 = new Car("Swift", "ABC", 2017, 40000, 34000);
		Car car4 = new Car("VW", "UVW", 2011, 35000, 10000);
		
		carList.add(car1);carList.add(car2);carList.add(car3);
		carList.add(car4);
		Collections.sort(carList,(Car arg0, Car arg1) -> arg1.getMileage()-arg0.getMileage());
	}
	
	@Test
	void checkCar1() {
		Car car1 = new Car("Toyota", "ASD", 2018, 10000, 9500);
		assertEquals(car1, carList.get(3));
	}
	
	@Test
	void checkCar2() {
		Car car2 = new Car("Hundai", "XYZ", 2002, 50000, 23000);
		assertEquals(car2, carList.get(0));
	}
	
	@Test
	void checkCar3() {
		Car car3 = new Car("Swift", "ABC", 2017, 40000, 34000);
		assertEquals(car3, carList.get(1));
	}
	
	@Test
	void checkCar4() {
		Car car4 = new Car("VW", "UVW", 2011, 35000, 10000);
		assertEquals(car4, carList.get(2));
	}
	
	


}