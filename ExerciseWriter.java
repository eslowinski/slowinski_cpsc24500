/**
 * Exercise Writer to help convert inputs to a String
 */

package application;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;

//Exercise Writer
public class ExerciseWriter {
    private static final SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public static boolean writeToFile(List<Exercise> exercises, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Exercise exercise : exercises) {
                writer.write(exercise.toString() + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Prints Summary
    public static void printToScreen(List<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toString());
        }
    }

    //Forms Summary to print
    public static String tabulateSummary(List<Exercise> exercises, JLabel summaryLabel) {
        System.out.println(String.format("%-20s%-25s%-15s%10s", "Name", "Date", "Duration", "Distance"));
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toSummaryString());
        }
		return null;
    }
}