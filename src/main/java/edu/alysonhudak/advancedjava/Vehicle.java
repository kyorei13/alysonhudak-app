import java.util.List;

/**
 * Assignment One: simple class using the Dependency Injection
 * design pattern. Relies on JUnit test.
 * 
 * @author Alyson Hudak
 */

public class Vehicle 
{
    // Vehicle components
    private List<String> wheels;
    private String color;

    /**
     *
     * @param wheels list containing the wheels
     * @param color is the color of the vehicle
     */

    public Vehicle(List<String> wheels, String color ) 
    {
        this.wheels = wheels;
        this.color = color;
    }

    /**
     *
     * @param color color of vehicle
     */

    public void setColor(String color) {this.color = color;}

    /**
     *
     * @return color of vehicle
     */

    public String getColor() 
    {
        return color;
    }

    /**
     *
     * @param wheels list containing wheels
     */

    public void setWheels(List<String> wheels) 
    {
        this.wheels = wheels;
    }

    /**
     *
     * @return number of wheels
     */

    // returns the number of elements in the wheels list
    public int getWheelsNumber() { return wheels.size();}
}