package com.gojek.coding.parkingLot.entity;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Unit test for {@link ParkingArea}.
 */
public class ParkingAreaTest extends TestCase
{
	/**
     * Test for {@link ParkingArea}.<br>
     * Case: ParkingArea entity is created.<br>
     * Result: Slots are set according to the parameter value.
     */
	public void testParkingArea()
	{
		ParkingArea parkingArea = new ParkingArea(6);
		assertEquals(6, parkingArea.getSlots());
	}
	
	/**
     * Test for {@link ParkingArea#addCar(Car)}.<br>
     * Case: ParkingArea entity is created.<br>
     * Result: Slots are set according to the parameter value.
     */
	public void testAddCar()
	{
		ParkingArea parkingArea = new ParkingArea(6);
		Car car1 = new Car("KA-1111-9999" , "Red" , 1);
		Car car2 = new Car("KA-1111-9999" , "Blue" , 2);
		parkingArea.addCar(car1);
		parkingArea.addCar(car2);
		Car[] cars = parkingArea.getCars();
		assertEquals(car1, cars[0]);
		assertEquals(car2, cars[1]);
	}
}
