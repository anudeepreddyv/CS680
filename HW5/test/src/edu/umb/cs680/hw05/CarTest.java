package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car car) {
		String[] carInformation = {car.getMake(),car.getModel(),Integer.toString(car.getYear())};
		return carInformation;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() throws Exception{
		Car actual = new Car("Maserati","Ghibli",15,2018,69000);
		String[] expected = {"Maserati","Ghibli","2018"};
		assertArrayEquals(expected,carToStringArray(actual));
	}

}