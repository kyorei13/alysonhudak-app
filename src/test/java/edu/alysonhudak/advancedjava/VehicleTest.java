import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Assignment One JUnit Test
 * Each public method in that class has a test and has a positive
 * and negative test.
 * 
 * @author Alyson Hudak
 */

public class VehicleTest extends TestCase 
{

    /**
     * Create the test case
     *
     * @param vehicleTest name of the test case
     */
    public VehicleTest( String vehicleTest )
    {
        super( vehicleTest );
    }

    private List<String> wheels;
    private String color;
    private Vehicle vehicle;

    /**
     *
     * @throws Exception
     */

    public void setUp() throws Exception 
    {
        super.setUp();
        wheels = new ArrayList<String>();
        color = "";
        vehicle = new Vehicle(wheels, color);
        vehicle.setColor("Red");
        wheels.add("Front Left");
        wheels.add("Front Right");
        wheels.add("Back Left");
        wheels.add("Back Right");
        vehicle.setWheels(wheels);
   }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( VehicleTest.class );
    }

    public void testGetColorPositive() 
    {
        assertEquals("Red", vehicle.getColor());
    }

   
    public void testGetColorNegative() 
    {
        assertNotSame("Green", vehicle.getColor());
    }

    public void testGetWheelsNumberPositive() 
    {
        assertEquals(4, vehicle.getWheelsNumber());
    }

    public void testGetWheelsNumberNegative() 
    {
        assertNotSame( 5, vehicle.getWheelsNumber());
    }
}