/**
 * Class to compare calories and impletements a comparator
 */

package application;

import java.util.Comparator;

public class ExerciseCompareByCalories implements Comparator <Exercise> {
	@Override
	public int compare(Exercise e1, Exercise e2) {
		double calories1 = e1.getCaloriesBurned();
		double calories2 = e2.getCaloriesBurned();
		return Double.compare(calories1, calories2);
	}

}
