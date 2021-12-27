package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.LinkedList;


class YearComparatorTest {
	LinkedList<Car> carsList = new LinkedList<Car>();
	@Test
	void verifyYear() {

		carsList.add(new Car("Hundai", "H", 2018, 16, 45000));
		carsList.add(new Car("VW", "M3", 2019, 8, 100000));
		carsList.add(new Car("Toyota", "Fortuner", 2020, 10, 30000));

		Collections.sort(carsList, new YearComparator());

		assertEquals(2018, carsList.get(0).getYear());
		assertEquals(2019, carsList.get(1).getYear());
		assertEquals(2020, carsList.get(2).getYear());

	}

}