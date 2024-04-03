package a5;

/**
 * Represents a node in the three dimensional xyz-space
 * Extends the Node class and implements the INode Interface
 * The first class to develop is called ThreeDNode that extends class Node, and represents a node 
in the xyz-space (three-dimensional space). The class contains the following:
1. Three constructors. extends
a. Default, x and y, z are assumed to be zero
b. Copy Constructor
c. A constructor that accepts three parameters for x, y, and z.
2. Get and Set methods for x, y, and z.
3. Method add, which adds a given ThreeDNode to the caller ThreeDNode. The addition is 
performed simply by adding x,y, and z from the parameter node to the caller node, 
respectively.
4. Override toString method to return a string that represents the ThreeDNode
5. Override equals method to check for nodes equality. Two ThreeDNode are equal if they 
have the same values for x, y, and z.
Pre-conditions
a. Values of x, y, and z should be in the range [-100,100]. 
b. When a constructor is given an invalid value for either x, y, or z, an exception is 
thrown with a proper error message.
c. When a set method is given an invalid value, the current value of x ,y, or z
(depending on whether you are calling setX, setY, or setZ) is not changed, and an 
exception is thrown with a proper error message.
d. When calling add method, if the result is invalid, add is not performed and an 
Exception is thrown
 */
public class ThreeDNode extends Node implements INode {
	private int z;
	
	
	/**
	 * Constructs a Three D Node with default coordinates (0,0,0).
	 * @throws Exception if coordinates are invalid
	 */
	public ThreeDNode() throws Exception {
		this(DEFAULT_X, DEFAULT_Y,0);
	}
	
	/**
	 * Constructs a ThreeDNode with Specified coordinates
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 * @throws Exception if coordinates are invalid
	 */
	public ThreeDNode (int x, int y, int z) throws Exception {
		super(x,y);
		setZ(z);
	}
	
	/**
	 * Copy constructor
	 * @param node the ThreeDNOde to copy
	 * @throws Exception
	 */
	public ThreeDNode(ThreeDNode node) throws Exception {
		super(node.getX(), node.getY());
		this.z = node.getZ();
	}
	
	/**
	 * gets the z coordinate
	 * @return the z coordinate
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the Z coordinate of the ThreeDNode
	 * @param z coordinate to set
	 * @throws Exception if z coordinate is invalid
	 */
	public void setZ(int z) throws Exception {
		if (isValidZ(z))
			this.z =z;
		else
			throw new Exception("Invalid operation: z value should be in the range of: [" + LOWER_LIMIT + "," + UPPER_LIMIT + "]");
	}
	
	/**
	 *  makes sure z is in the range of [-100,100]
	 * @param z
	 * @return z in limit
	 */
	private boolean isValidZ(int z) {
		return z <=UPPER_LIMIT && z >= LOWER_LIMIT;	
	}
	
	 /** Override toString method to represent ThreeDNode
	  * 
	  */
    @Override
    public String toString() {
        return  "(" + super.getX() + "," + super.getY() + ","+ getZ() + ")";
    }

    /** Override equals method to compare ThreeDNode objects
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return super.equals(obj) && getZ() == other.getZ();
    }

   /**
    * Overrides to add all nodes 
    */
    @Override
    public void add(Node node) throws Exception {
    	if(!(node instanceof ThreeDNode))
    		throw new Exception ("invalid operation");
    	ThreeDNode threedNode = (ThreeDNode) node;
    	super.add(threedNode);
    	this.z += threedNode.getZ();
    }
   
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
