/**
 * Weightlifting subclass that extends the Exercise class
 */
package application;

import java.util.Date;

/**
 * Weightlifting Class
 */
public class WeightLifting extends Exercise {
    private double weight;

    //Constructor
    public WeightLifting(String name, Date date, double duration, String comment, double weight) {
        super();
        this.weight = weight;
        
    }

  //Getter
	public double getWeight() {
    	return weight;
    }
    
	//Setter
    public void setweight(double weight) {
    	this.weight = weight;
    }

    //Override toString
    @Override
    public String toStringCustomInfo() {
        return String.format("%.2f lbs", weight);
    }

    //Gets type of Exercise
    @Override
    public String getType() {
        return "Weightlifting";
    }

    //Get Calories Burned
    @Override
    public double getCaloriesBurned() {
        return (weight / getDuration()) * 50;
    }
}
