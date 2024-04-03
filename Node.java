package a5;
/**
 * Develop a class called Node, which represents a node in the xy-coordinate. The class contains the following:
1.	Three constructors. 
a.	Default, x and y are assumed to be zero
b.	Copy Constructor
c.	A constructor that accepts two parameters for x and y.
2.	Get and Set methods for x and y.
3.	Method add, which adds a given node o the caller node. The addition is performed simply by adding x,y from the parameter node to the caller node, respectively.
4.	Override toString method to return a string that represents the Node
5.	Override equals method to check for nodes equality. Two nodes are equal if they have the same values for x and y.
Pre-conditions
a.	Values of x and y should be in the range [-100,100]. 
b.	When a constructor is given an invalid value for either x or y, an exception is thrown with a proper error message.
c.	When a set method is given an invalid value, the current value of x or y (depending on whether you are calling setX or setY) is not changed, and an exception is thrown with a proper error message.
d.	When calling add method, if the result is invalid, add is not performed and an Exception is thrown.
Notes:
•	Save your class in a package named a5. This is very important as I want to import the class and test it. 
•	Avoid code duplication, you might call setter from the constructors, or call a constructor from another constructor. 
•	Use constants (finals) for the numbers that restrict ranges. This will allow us to easily change these values in the future.
•	All methods are documented with JavaDoc, use @override annotation for overridden methods.
•	All data members are private. If you develop a method that is not part of the class interface (I already have one such method in mind), this method should be also private.

 */
public class Node implements INode {
	
    private int x,y;

    public Node() throws Exception{
    	this( DEFAULT_X, DEFAULT_Y);
    }
    
	public Node(int x, int y) throws Exception {
		setX(x); setY(y);  //set to given values if valid
	}
	/**
	 * Copy constructor
	 * @param node
	 * @throws Exception
	 */
	public Node(Node node) throws Exception {
		setX(node.getX());
		setY(node.getY());
	}

	private boolean isValidX(int x) {
		if (x<=UPPER_LIMIT && x>=LOWER_LIMIT)
			return true;
		return false;
	}
	private boolean isValidY(int y) {
		if (y<=UPPER_LIMIT && y>=LOWER_LIMIT)
			return true;
		return false;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) throws Exception {
		if (isValidX(x))
			this.x = x;
		else
		throw new Exception("Invalid operation: x value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws Exception {
		if (isValidY(y))
			this.y = y;
		else
		throw new Exception("Invalid operation: y value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
	}
	public void add(Node node) throws Exception {
		if (isValidX(this.x+node.getX()) && isValidY(this.y+node.getY()) ) {
			this.x+=node.getX();
			this.y+=node.getY();
		}	else
			throw new Exception("Invalid operation, the result exceeds the xy-space boundaries...");
	}
	
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	public boolean equals(Object obj) {
		//to restrict call with only objects of type Node
		if (obj instanceof Node) {
			Node ref = (Node) obj;
			if (this.x==ref.x && this.y == ref.y)
				return true;
			return false;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
   
} //class Node
