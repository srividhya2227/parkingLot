package com.gojek.coding.parkingLot.entity;

import junit.framework.TestCase;

/**
 * Unit test for {@link Car}.
 */
public class CarTest 
    extends TestCase
{
	/**
     * Test for {@link Car}.<br>
     * Case: Car entity is created.<br>
     * Result: Columns are set according to the parameter values.
     */
    public void testCar()
    {
    	Car car = new Car("KA-0110-1110", "red", 1);
        assertEquals("KA-0110-1110", car.getRegistrationNbr());
        assertEquals("red", car.getColor());
        assertEquals(1, car.getSlotNbr());
    }
}
