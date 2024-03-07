import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Assignment4 {
	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws IOException{
		//gets number of lines in text file and returns them
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} catch(IOException e) {
			throw new FileNotFoundException("File not found: " + filename);
		}	
	}

	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		//gets lines from file to create array
		try (Scanner sc = new Scanner(new File(filename))){
			int lines;
			try {
				lines = getNoLines(filename);
			} catch(Exception e) {
				throw new Exception("Error while getting number of lines:"+ e.getMessage(), e);
			}
			int[][] array = new int[lines][];
			
			int i =0;
			//creates array with the values on each line
			while(sc.hasNextLine()) {
				String [] values = sc.nextLine().split("\\s+");
				array[i] = new int[values.length];
				for(int j =0; j<values.length; j++) {
					array[i][j] = Integer.parseInt(values[j]);
				}
				i++;
			}
			return array;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found:" + filename);
		}
	}
	
	/**
	 * Finds the maximum value in a 2D array
	 * @param array(2D)
	 * @return The max value in the array
	 * @throws IllegalArgumentException if the array is null or empty from validateArray(array)
	 */
	
	public static int findMax(int[][] array) throws IllegalArgumentException {
		//validates if array is filled
		validateArray(array);
		
		///sets max to 0,0 to later 
		int max = array[0][0];
		
		//if array is empty, throws exceptions
		for(int i =0; i <array.length; i++) {
			if(array[i]== null || array[i].length == 0) {
				throw new IllegalArgumentException("Invalid row in the array: null or empty");
			}
			
			//finds max value
			for(int j =0; j < array[i]. length; j++) {
				if(array[i][j]> max) {
					max = array[i][j];
				}
			}
		}
		return max;
	}
	
	/**
	 * Finds the maximum value in a specific row of a 2D array
	 * @param array (2D)
	 * @param rowIndex (Index of row)
	 * @return the maximum value in each of the row
	 * @throws IllegalArgumentException if the array or row is invalid from validateRow(array,rowIndex)
	 */
	public static int findMaxInRow(int[][] array, int rowIndex) throws IllegalArgumentException {
		//validates array or row(method that throws exception
		validateRow(array,rowIndex);

		//sets to find the max number in row
		int max= array[rowIndex][0];
		
		//determines what the max is and returns it
		for(int i=1; i < array[rowIndex].length; i++) {
			if(array[rowIndex][i]> max) {
				max = array[rowIndex][i];
			}
		}
		return max;
	}
	
	/**
	 * Finds the index of the longest row in a 2D array
	 * @param array (2D)
	 * @return the index of the longest row
	 * @throws IllegalArgumentException if the array is null or empty from validateArray(array)
	 */
	public static int findLongestRow(int[][] array) throws IllegalArgumentException {
		//validates array to be full or empty
		validateArray(array);
		
		//sets maxLength and longest row to 0
		int maxLength = 0;
		int longestRow = 0;
		
		//finds longest row and returns it
		for(int i =0; i < array.length; i ++) {
			if(array[i].length > maxLength) {
					maxLength = array[i].length;
					longestRow = i;
				}	
			}
			return longestRow;
		}
	
	/**
	 * Validates the array
	 * @param array
	 * @throws IllegalArgumentException if array is empty
	 */
	private static void validateArray(int[][] array) throws IllegalArgumentException {
		//validates array
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}
	}
	
	/**
	 * Validates a row in the 2D array, ensuring it is not empty or null
	 * @param array
	 * @param rowIndex
	 * @throws IllegalArgumentException if array or row is invalid
	 */
	private static void validateRow(int[][] array, int rowIndex) throws IllegalArgumentException {
		//validates row index
		if(array == null|| array.length == 0|| rowIndex< 0 || rowIndex>=array.length) {
			throw new IllegalArgumentException("Invalid array or row index");
		}
		
		//validates if row is filled
		if(array[rowIndex]== null || array[rowIndex].length == 0) {
			throw new IllegalArgumentException("Inavlid row is null or empty");
		}
	}
	
	/**
	 * Returns all information in the file by calling the different arrays
	 * @param args
	 */
	public static void main(String[] args) {
		//gets text file and inputs it as a variable
		String filename = null;
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);		
		}
		filename = args[0];
		int arr[][] = null;
		
		//Prints out all the information needed from the text file if not, catches the exception
		try {
			System.out.println("Number of lines in the file =" + getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" , with length of: " 
			+arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
