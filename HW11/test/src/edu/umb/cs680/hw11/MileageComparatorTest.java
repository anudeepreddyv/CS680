package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
class MileageComparatorTest {
	LinkedList<Car> carList = new LinkedList<Car>();

	@Test
	public void checkMileageComparator() {
		carList.add(new Car("Hundai", "H", 2016, 16, 50000));
		carList.add(new Car("Toyota", "Fortuner", 2018, 10, 300000));
		carList.add(new Car("VW", "M3", 2017, 8, 200000));
		Collections.sort(carList, new MileageComparator());

		assertEquals(16, carList.get(0).getMileage());
		assertEquals(10, carList.get(1).getMileage());
		assertEquals(8, carList.get(2).getMileage());

	}

}