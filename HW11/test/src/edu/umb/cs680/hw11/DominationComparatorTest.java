package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DominationComparatorTest {

static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 10000, 8000);
		Car car2 = new Car("BMW", "XYZ", 2000, 40000, 28000);
		Car car3 = new Car("Ford", "ABC", 2010, 30000, 20000);
		Car car4 = new Car("KIA", "UVW", 2012, 25000, 10000);
		Car car5 = new Car("Toyota", "KKK", 2015, 20000, 22000);
		Car car6 = new Car("Toyota", "ABD", 2017, 15000, 8000);
		carList.add(car1);carList.add(car2);carList.add(car3);
		carList.add(car4);carList.add(car5);carList.add(car6);
		carList.sort(new ParetoComparator());
	}
	
	@Test
	void checkCar1AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(5, carList.get(0).getDominationCount());
	}
	
	@Test
	void checkCar2AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(4, carList.get(1).getDominationCount());
	}
	
	@Test
	void checkCar3AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(3, carList.get(2).getDominationCount());
	}
	
	@Test
	void checkCar4AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(2, carList.get(3).getDominationCount());
	}
	
	@Test
	void checkCar5AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(1, carList.get(4).getDominationCount());
	}
	
	@Test
	void checkCar6AfterSort() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(0, carList.get(5).getDominationCount());
	}

	
	

}