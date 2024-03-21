
package a5;
/** Class that represents a node in the xy coordinate
 * Includes:
 * - Three constructors: Default, copy, and a constructor that accepts two parameters for x and y
 * - Get and Set methods for X and Y
 * - Add method which ass given node to caller node
 * - Override toString method to return node as string
 * - Override equals method to check nodes for equality
 * @author emmas
 *
 */
public class Node {
	//Min and Max Value for range; does not change
	private static final int minValue = -100;
	private static final int maxValue = 100;
	
	// x coordinate variable
	private int x;
	
	//y coordinate variable
	private int y;
	
	/**
	 * Default constructor, initializes x and y to zero
	 */
	public Node() {
		this(0,0);
	}
	
	/**
	 * Constructor with given x and y coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @throws IllegalArgumentException if x or y is not in the valid range
	 */
	public Node(int x, int y) throws IllegalArgumentException {
		//trys to set x and y coordinates in node, of not Exception is thrown
		try{
			setX(x);
			setY(y);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid node coordinates: " + e.getMessage());
		}
		
		
	}
	
	/**
	 * Copy constructor
	 * @param other; the Node to copy
	 */
	public Node(Node other) {
		this(other.getX(), other.getY());
	}
	
	/**
	 * get the x coordinate
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * get the y coordinate
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * sets the x coordinate
	 * @param x; the new x coordinate
	 * @throws IllegalArgumentException if y is not in valid range
	 */
	public void setX(int x) throws IllegalArgumentException {
		//if statement to make sure x is in range
		if( x < minValue || x > maxValue) {
			throw new IllegalArgumentException("X value is out of range");
		}
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate
	 * @param y; the new y coordinate
	 * @throws IllegalArgumentException if y is not in the valid range
	 */
	public void setY(int y) throws IllegalArgumentException {
		//if statment to make sure y is in range
		if( y < minValue || y > maxValue) {
			throw new IllegalArgumentException("Y value is out of range");
		}
		this.y = y;
	}
	
	/**
	 * 
	 * @param other; the node to add
	 * @return; the resulting node after addition
	 * @throws IllegalArgumentException if the resulting coordinates are not in range
	 */
	public Node add(Node other) throws IllegalArgumentException {
		//adds node to other
		int newX = this.x + other.getX();
		int newY = this.y + other.getY();
		
		//determines if in range
		if(newX < minValue || newX > maxValue || newY < minValue || newY > maxValue) {
			throw new IllegalArgumentException("Addition result out of range");
		}
		return new Node(newX, newY);
	}
	
	/**
	 * Returns a string representation of the Node
	 * @return a string representation of the node
	 */
	@Override
	public String toString() {
		//string
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * Checks if two nodes are equal
	 * @param obj; the object to compare
	 * @returns True if the nodes are equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		// if both are equal it is true, if they are not, returns fals
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Node node = (Node) obj;
		return x == node.x && y ==node.y;
	}
}
