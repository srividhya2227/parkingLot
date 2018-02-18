package com.gojek.coding.parkingLot.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gojek.coding.parkingLot.entity.ParkingArea;
import com.gojek.coding.parkingLot.utility.DetailRetriever;
import com.gojek.coding.parkingLot.utility.Simulator;

public class Application 
{
	public static void main(String args[])
	{
		if(args.length > 1)
		{
			File file = new File(args[1]);
			try 
			{
				Scanner scanner = new Scanner(file);
				String inputArray[] = scanner.nextLine().split(" ");
				new Simulator().createParkingLot(scanner, Integer.parseInt(inputArray[1]));
			} 
			catch (FileNotFoundException e)
			{
				System.out.println("File not found : " + file.getAbsolutePath());
			}
			
		}
		else
		{
			System.out.println("create_parking_lot");
			Scanner scanner = new Scanner(System.in);
			new Simulator().createParkingLot(scanner, scanner.nextInt());
		}
	}
}
