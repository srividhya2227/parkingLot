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
	 * Adds the car to the parking area.
	 * 
     * @param car
     *            Adds the car to the parking lot to the particular slot.
     */
	public void addCar(final Car car) 
	{
		cars[car.getSlotNbr()] = car;
	}
	
	/**
	 * Will give the next available slot number for the car.
	 * 
     * @return The next available slots.
     */
	public int getNextAvailableSlot() 
	{
		int availableSlot = -1;
		for(int i = 0 ; i < cars.length ; i++)
		{
			if(cars[i] == null)
			{
				availableSlot = i;
				break;
			}
		}
		
		return availableSlot;
	}
	
	/**
	 * Removes the car from the given slot number.
	 * 
     * @param slotNumber
     *            Removed the car from the particular slot number.
     */
	public void removeCar(final int slotNumber)
	{
		cars[slotNumber] = null;
	}
}
