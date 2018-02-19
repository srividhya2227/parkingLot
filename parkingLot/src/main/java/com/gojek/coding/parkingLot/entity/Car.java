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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((registrationNbr == null) ? 0 : registrationNbr.hashCode());
		result = prime * result + slotNbr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (registrationNbr == null) {
			if (other.registrationNbr != null)
				return false;
		} else if (!registrationNbr.equals(other.registrationNbr))
			return false;
		if (slotNbr != other.slotNbr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [registrationNbr=" + registrationNbr + ", color=" + color + ", slotNbr=" + slotNbr + "]";
	}
}
