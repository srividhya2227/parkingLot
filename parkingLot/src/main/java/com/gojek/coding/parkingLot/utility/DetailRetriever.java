package com.gojek.coding.parkingLot.utility;

import com.gojek.coding.parkingLot.entity.Car;
import com.gojek.coding.parkingLot.entity.ParkingArea;

public class DetailRetriever 
{
	/**
	 * Creates a parking slot and parks the car.
	 * 
     * @param parkingArea
     *            The parking area in which car is to be parked.
     * @param input
     *            The string containing the information about car.            
     */
	public void getParkingSlot(final ParkingArea parkingArea, final String input)
	{
		String[] inputArray = input.split(" ");
		int availableSlot = parkingArea.getNextAvailableSlot();
		if(availableSlot == -1 )
		{
			System.out.println("Sorry, parking lot is full");
		}
		else
		{
			Car car = new Car(inputArray[1] , inputArray[2] , availableSlot);
			parkingArea.addCar(car);
			System.out.println("Allocated slot number: " + (availableSlot+1));
		}
	}
	
	/**
	 * Gives the particular status information about the parking lot.
	 * 
     * @param parkingArea
     *            The parking area in which cars are parked.
     */
	public void getStatus(final ParkingArea parkingArea)
	{
		Car[] cars = parkingArea.getCars();
		System.out.println("Slot No\t" +"Registration No.\t"+"colour\t\n");
		for(int i = 0; i < cars.length ; i++)
		{
			if(cars[i] != null)
			{
				Car car = cars[i];
				System.out.println((car.getSlotNbr()+1) + "\t" + car.getRegistrationNbr() + "\t"+ car.getColor() + "\t\n");
			}
		}
	}
	
	/**
	 * Retrieves the slot numbers for a particular color of car.
	 * 
     * @param parkingArea
     *            The parking area in which cars are parked.
     * @param input
     *            The string containing the information about car's color.            
     */
	public void getSlotsForCarColour(final ParkingArea parkingArea , final String input)
	{
		String[] inputArray = input.split(" ");
		String color = inputArray[1];
		Car[] cars = parkingArea.getCars();
		StringBuffer result = new StringBuffer();
		for(int i = 0,j=0; i < cars.length ; i ++)
		{
			if(cars[i] != null)
			{
				Car car = cars[i];
				if(car.getColor().equalsIgnoreCase(color))
				{
					result.append(i+1 + ", ");
				}
			}
		}
		if(result.length() == 0)
		{
			System.out.println("Not Found.");
		}
		else
		{
			result = result.deleteCharAt(result.length()-2);
			System.out.println(result);
		}
	}
	
	/**
	 * Retrieves the slot numbers for a particular registration number of car.
	 * 
     * @param parkingArea
     *            The parking area in which cars are parked.
     * @param input
     *            The string containing the information about car's registration number.            
     */
	public void getSlotsForRegistrationNumber(final ParkingArea parkingArea , final String input)
	{
		String[] inputArray = input.split(" ");
		String registrationNbr = inputArray[1];
		Car[] cars = parkingArea.getCars();
		int flag = 0;
		for(int i = 0,j=0; i < cars.length ; i ++)
		{
			if(cars[i] != null)
			{
				Car car = cars[i];
				if(car.getRegistrationNbr().equalsIgnoreCase(registrationNbr))
				{
					System.out.println(i+1);
					flag = 1;
					break;
				}
			}
		}
		
		if(flag == 0)
		{
			System.out.println("not Found.");
		}
	}
	
	/**
	 * Retrieves the registration number for a particular color of car.
	 * 
     * @param parkingArea
     *            The parking area in which cars are parked.
     * @param input
     *            The string containing the information about car's color            
     */
	public void getRegistrationNumberForColor(final ParkingArea parkingArea , final String input)
	{
		String[] inputArray = input.split(" ");
		String color = inputArray[1];
		Car[] cars = parkingArea.getCars();
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < cars.length ; i ++)
		{
			if(cars[i] != null)
			{
				Car car = cars[i];
				if(car.getColor().equalsIgnoreCase(color))
				{
					result.append(car.getRegistrationNbr() + ", ");
				}
			}
		}
		if(result.length() == 0)
		{
			System.out.println("Not Found.");
		}
		else
		{
			result = result.deleteCharAt(result.length()-2);
			System.out.println(result);
		}
	}
	
	/**
	 * Empties the particulat slot in the parking area..
	 * 
     * @param parkingArea
     *            The parking area in which cars are parked.
     * @param input
     *            The string containing the information about slot to be emptied.           
     */
	public void leaveSlot(final ParkingArea parkingArea, final String input)
	{
		String[] inputArray = input.split(" ");
		int slot = Integer.parseInt(inputArray[1]);
		if(slot < 1)
		{
			System.out.println("Not a valid slot");
			return;
		}
		parkingArea.removeCar(slot-1);
		System.out.println("Slot number " + input + " is free");
	}
}
