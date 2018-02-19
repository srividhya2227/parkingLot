package com.gojek.coding.parkingLot.utility;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.gojek.coding.parkingLot.entity.Car;
import com.gojek.coding.parkingLot.entity.ParkingArea;

import junit.framework.TestCase;

public class DetailRetrieverTest extends TestCase
{
	ParkingArea parkingArea = new ParkingArea(4);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Override
	public void setUp()
	{
		Car car1 = new Car("KA-01-1992-12" , "White" , 0);
		Car car2 = new Car("KA-01-1992-10" , "Black" , 1);
		Car car3 = new Car("KA-01-1992-17" , "Red" , 2);
		parkingArea.addCar(car1);
		parkingArea.addCar(car2);
		parkingArea.addCar(car3);
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@Override
	public void tearDown()
	{
		 System.setOut(System.out);
		 System.setErr(System.err);
	}
	
	/**
     * Test for {@link DetailRetriever#getParkingSlot(ParkingArea, String)}.<br>
     * Case: Another car is added to parking slot..<br>
     * Result: Slot gets allocated and car is parked.
     */
    public void testGetParkingSlot()
    {
    	String input = "park KA-01-P-3334 White";
    	new DetailRetriever().getParkingSlot(parkingArea, input);
    	
    	Car[] cars = parkingArea.getCars();
    	Car car1 = new Car("KA-01-1992-12" , "White" , 0);
		Car car2 = new Car("KA-01-1992-10" , "Black" , 1);
		Car car3 = new Car("KA-01-1992-17" , "Red" , 2);
		Car car4 = new Car("KA-01-P-3334" , "White" , 3);

		assertEquals(car1.getColor() , cars[0].getColor());
		assertEquals(car1.getRegistrationNbr() , cars[0].getRegistrationNbr());
		assertEquals(car1.getSlotNbr() , cars[0].getSlotNbr());
		assertEquals(car2.getColor() , cars[1].getColor());
		assertEquals(car2.getRegistrationNbr() , cars[1].getRegistrationNbr());
		assertEquals(car2.getSlotNbr() , cars[1].getSlotNbr());
		assertEquals(car3.getColor() , cars[2].getColor());
		assertEquals(car3.getRegistrationNbr() , cars[2].getRegistrationNbr());
		assertEquals(car3.getSlotNbr() , cars[2].getSlotNbr());
		assertEquals(car4.getColor() , cars[3].getColor());
		assertEquals(car4.getRegistrationNbr() , cars[3].getRegistrationNbr());
		assertEquals(car4.getSlotNbr() , cars[3].getSlotNbr());
		assertEquals("Allocated slot number: 4\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getParkingSlot(ParkingArea, String)}.<br>
     * Case: Another car is added to parking slot when the parking is full.<br>
     * Result: Car is not added to the parking and message is shown on console.
     */
    public void testGetParkingSlot_withParkingFull()
    {
    	String input = "park KA-01-P-3334 White";
    	new DetailRetriever().getParkingSlot(parkingArea, input);
    	input = "park KA-01-P-3336 White";
    	new DetailRetriever().getParkingSlot(parkingArea, input);

		assertEquals("Allocated slot number: 4\r\nSorry, parking lot is full\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getSlotsForCarColour(ParkingArea, String)}.<br>
     * Case: Input is sent for a color which exists in parking lot.<br>
     * Result: Slot of the particular color car is given.
     */
    public void testGetSlotsForCarColour()
    {
    	String input = "slot_numbers_for_cars_with_colour White";
    	new DetailRetriever().getSlotsForCarColour(parkingArea, input);

		assertEquals("1\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getSlotsForCarColour(ParkingArea, String)}.<br>
     * Case: Input is sent for a color which does not exists in parking lot.<br>
     * Result: Not found message is displayed in console.
     */
    public void testGetSlotsForCarColour_forNotFound()
    {
    	String input = "slot_numbers_for_cars_with_colour Yellow";
    	new DetailRetriever().getSlotsForCarColour(parkingArea, input);

		assertEquals("Not found\r\n", outContent.toString());
    }

    /**
     * Test for {@link DetailRetriever#getSlotsForRegistrationNumber(ParkingArea, String)}.<br>
     * Case: Input is sent for a registration number which exists in parking lot.<br>
     * Result: Slot number for the particular car is displayed in console.
     */
    public void testGetSlotsForRegistrationNumber()
    {
    	String input = "slot_number_for_registration_number KA-01-1992-10";
    	new DetailRetriever().getSlotsForRegistrationNumber(parkingArea, input);

		assertEquals("2\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getSlotsForRegistrationNumber(ParkingArea, String)}.<br>
     * Case: Input is sent for a registration number which does not exists in parking lot.<br>
     * Result: Not found message is displayed in console.
     */
    public void testGetSlotsForRegistrationNumber_forNotFound()
    {
    	String input = "slot_number_for_registration_number KA-01-1992-19";
    	new DetailRetriever().getSlotsForRegistrationNumber(parkingArea, input);

		assertEquals("Not found\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getRegistrationNumberForColor(ParkingArea, String)}.<br>
     * Case: Input is sent for a color of car which exists in parking lot.<br>
     * Result: Registration number of all cars of that particular color is displayed in console.
     */
    public void testGetRegistrationNumberForColor()
    {
    	String input = "registration_numbers_for_cars_with_colour White";
    	new DetailRetriever().getRegistrationNumberForColor(parkingArea, input);

		assertEquals("KA-01-1992-12\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#getRegistrationNumberForColor(ParkingArea, String)}.<br>
     * Case: Input is sent for a color of car which does not exists in parking lot.<br>
     * Result: Not found message is displayed in console.
     */
    public void testGetRegistrationNumberForColor_forNotFound()
    {
    	String input = "registration_numbers_for_cars_with_colour Blue";
    	new DetailRetriever().getRegistrationNumberForColor(parkingArea, input);

		assertEquals("Not found\r\n", outContent.toString());
    }
    
    /**
     * Test for {@link DetailRetriever#leaveSlot(ParkingArea, String)}.<br>
     * Case: Input is sent for a particular slot that exists in parking lot.<br>
     * Result: The slot is emptied.
     */
    public void testLeaveSlot()
    {
    	String input = "leave 3";
    	new DetailRetriever().leaveSlot(parkingArea, input);

		assertEquals("Slot number 3 is free\r\n", outContent.toString());
    }
}