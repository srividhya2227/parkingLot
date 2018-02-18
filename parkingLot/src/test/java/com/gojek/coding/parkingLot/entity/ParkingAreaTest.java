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
		Car car1 = new Car("KA-1111-9999" , "Red" , 0);
		Car car2 = new Car("KA-1111-9998" , "Blue" , 1);
		parkingArea.addCar(car1);
		parkingArea.addCar(car2);
		Car[] cars = parkingArea.getCars();
		assertEquals(car1, cars[0]);
		assertEquals(car2, cars[1]);
	}
	
	/**
     * Test for {@link ParkingArea#getNextAvailableSlot()}.<br>
     * Result: The next available slot is returned from the array.
     */
	public void testGetNextAvailableSlot()
	{
		ParkingArea parkingArea = new ParkingArea(6);
		Car car1 = new Car("KA-1111-9999" , "Red" , 0);
		Car car2 = new Car("KA-1111-9998" , "Blue" , 1);
		Car car3 = new Car("KA-1111-9997" , "Blue" , 2);
		parkingArea.addCar(car1);
		parkingArea.addCar(car2);
		parkingArea.addCar(car3);
		parkingArea.removeCar(1);
		
		Car[] cars = parkingArea.getCars();
		assertEquals(car1, cars[0]);
		assertEquals(null, cars[1]);
		assertEquals(car3, cars[2]);
		assertEquals(1, parkingArea.getNextAvailableSlot());
	}
	
	/**
     * Test for {@link ParkingArea#removeCar(int)}.<br>
     * Case: A valid slot number is passed.<br>
     * Result: Slot is emptied for the given slot number.
     */
	public void testRemoveCar()
	{
		ParkingArea parkingArea = new ParkingArea(6);
		Car car1 = new Car("KA-1111-9999" , "Red" , 0);
		Car car2 = new Car("KA-1111-9998" , "Blue" , 1);
		Car car3 = new Car("KA-1111-9997" , "Blue" , 2);
		parkingArea.addCar(car1);
		parkingArea.addCar(car2);
		parkingArea.addCar(car3);
		
		Car[] cars = parkingArea.getCars();
		assertEquals(car1, cars[0]);
		assertEquals(car2, cars[1]);
		assertEquals(car3, cars[2]);
		
		parkingArea.removeCar(1);
		cars = parkingArea.getCars();
		assertEquals(car1, cars[0]);
		assertEquals(null, cars[1]);
		assertEquals(car3, cars[2]);
	}
}