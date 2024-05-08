/**
 * RockClimbing subclass that Extends the Exercise Class
 */
package application;
import java.util.Date;

/**
 * RockClimbing class
 */
public class RockClimbing extends Exercise {
    private double wallHeight;
    private int repetitions;

    //Constructor
    public RockClimbing(String name, Date date, double duration, String comment, double wallHeight, int repetitions) {
        super();
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }

    //Getter for Wall Height
	public double getwallHeight() {
    	return wallHeight;
    }
    
	//Setter for Wall Height
    public void setWallHeight(double wallHeight) {
    	this.wallHeight = wallHeight;
    }
    
    //Getter for Repetitions
    public int getRepetitions() {
    	return repetitions;
    }
    
    //Setter for Repetitions
    public void setRepetitions(int repetitions) {
    	this.repetitions = repetitions;
    }

    //Override To String
    @Override
    public String toStringCustomInfo() {
        return String.format("Wall Height: %.2f ft, Repetitions: %d", wallHeight, repetitions);
    }
    

    //Get type of exercise
    @Override
    public String getType() {
        return "Rock Climbing";
    }

    //Get Calories Burned
    @Override
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }
}