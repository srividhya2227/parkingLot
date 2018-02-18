package com.gojek.coding.parkingLot.entity;

/**
 * Entity class for car.
 */
public class Car 
{
    private String registrationNbr;
    private String color;
    private int slotNbr;
    
    public Car(final String registrationNbr , final String color , final int slotNbr)
    {
    	this.registrationNbr = registrationNbr;
    	this.color = color;
    	this.slotNbr = slotNbr;
    }
    
    /**
     * @return The registration number.
     */
	public String getRegistrationNbr() 
	{
		return registrationNbr;
	}
	
	 /**
     * @param registrationNbr
     *            The registration number
     */
	public void setRegistrationNbr(final String registrationNbr)
	{
		this.registrationNbr = registrationNbr;
	}
	
	 /**
     * @return The color of the car.
     */
	public String getColor()
	{
		return color;
	}
	
	/**
     * @param color
     *            The color of the car.
     */
	public void setColor(final String color)
	{
		this.color = color;
	}
	
	 /**
     * @return The slot number.
     */
	public int getSlotNbr()
	{
		return slotNbr;
	}
	
	/**
     * @param slotNbr
     *            The slot number of the car.
     */
	public void setSlotNbr(final int slotNbr) 
	{
		this.slotNbr = slotNbr;
	}
}
