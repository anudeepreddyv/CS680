package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	LinkedList<Car> carsList = new LinkedList<Car>();

    @Test
	void verifyPrice() {
		
    	carsList.add(new Car("Audi", "A4", 2018, 16, 65000));
		carsList.add(new Car("VW", "M3", 2019, 8, 165000));
		carsList.add(new Car("Toyota", "Fortuner", 2020, 10, 85000));
		
		Collections.sort(carsList,new PriceComparator());
		
		assertEquals(165000, carsList.get(0).getPrice());
		assertEquals(85000, carsList.get(1).getPrice());
		assertEquals(65000, carsList.get(2).getPrice());
		
	}
}