/**
 * Run Walk is a subclass that extends the Exercise Class
 */
package application;

import java.util.Date;

/**
 * Run Walk Class
 */
public class RunWalk extends Exercise {
    private double distance;

    //Constructor
    public RunWalk(String name, Date date, double duration, String comment, double distance) {
        super();
        this.distance = distance;
    }

   // Getter
    public double getDistance() {
    	return distance;
    }
    
    // Setter
    public void setDistance(double distance) {
    	this.distance = distance;
    }

    //Overrides To String
    @Override
    public String toStringCustomInfo() {
        return String.format("%.2f miles", distance);
    }

    //Get Type of Exercise
    @Override
    public String getType() {
        return "Run/Walk";
    }

    //Get Calories Burned
    @Override
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }
}
