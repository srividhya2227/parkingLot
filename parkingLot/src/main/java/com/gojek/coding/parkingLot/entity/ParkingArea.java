package com.gojek.coding.parkingLot.entity;

public class ParkingArea 
{
	int slots;
	Car[] cars;
	
	public ParkingArea(int slots)
	{
		this.slots = slots;
		this.cars = new Car[slots];
	}

	/**
     * @return The total number of slots.
     */
	public int getSlots() {
		return slots;
	}

	 /**
     * @return The list of cars in parking area.
     */
	public Car[] getCars() {
		return cars;
	}

	/**
     * @param car
     *            Adds the car to the parking lot to the particular slot.
     */
	public void addCar(final Car car) 
	{
		cars[car.getSlotNbr()-1] = car;
	}
}
