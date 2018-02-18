package com.gojek.coding.parkingLot.utility;

import java.util.Scanner;

import com.gojek.coding.parkingLot.entity.ParkingArea;

public class Simulator
{
	public void createParkingLot(final Scanner scanner , final int slots)
	{
		ParkingArea parkingArea = new ParkingArea(slots);
		System.out.println("Created a parking lot with " + slots +" slots");
		while(scanner.hasNext())
		{
			String input = scanner.nextLine();
			if (input.contains("park"))
			{
				new DetailRetriever().getParkingSlot(parkingArea, input);
			}
			else if (input.contains("leave"))
			{
				new DetailRetriever().leaveSlot(parkingArea, input);
			}
			else if(input.contains("slot_numbers_for_cars_with_colour"))
			{
				new DetailRetriever().getSlotsForCarColour(parkingArea, input);
			}
			else if(input.contains("slot_number_for_registration_number"))
			{
				new DetailRetriever().getSlotsForRegistrationNumber(parkingArea, input);
			}
			else if(input.contains("registration_numbers_for_cars_with_colour"))
			{
				new DetailRetriever().getRegistrationNumberForColor(parkingArea, input);
			}
			else if(input.contains("status"))
			{
				new DetailRetriever().getStatus(parkingArea);
			}
		}

	}
}
