package a5;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * . A default constructor, which creates an empty ArrayList
2. Method Fill, takes one parameter which is the size. The method will fill the array 
randomly with objects of type ThreeDNode or Node. So for example, if I call the method 
like this: obj.fill(20), the arraylist might contain 8 Nodes and 12 ThreeDNodes. If I call fill 
again, I might get different numbers. The values in the created nodes are also randomly 
generated.
I provided two factory methods for creating the nodes which method fill will use. These 
factory methods are in the attached class called NodeFactory. (On Monday, I will 
explain this concept of factories).
3. Method clear, which deletes all elements in the ArrayList
4. Method countNodes, which returns the number of objects of type Node in the ArrayList
5. Method countThreeDNones, which returns the number of objects of type Node in the 
ArrayList
6. Method sort, which sorts the ArrayList. The sorting is based on the sum of the values x 
and y, or x and y and z if the node is of type ThreeDNode. So only one sorter that 
implements interface Comparator is needed. The sorter needs to check the node type 
(either Node or ThreeDNode) and then calculates the sum.
7. Method toString, returns a multi-line string that represents the nodes in the ArrayList. 
Each line represents a node.

 */
public class Nodes {
	private ArrayList <INode> nodeList;
	
	//constructor; constructs a new Nodes object with an empty ArrayList
	public Nodes() {
		nodeList = new ArrayList <>();
	}
	
	/**
	 * Fills the ArrayList with randomly generated INode objects 
	 * @param size The Number of INode objects to generate and add to the Array lists
	 */
	public void fill(int size) {
		nodeList.clear();
		//adds node to list
	    for (int i = 0; i < size; i++) {
	        try {
	         
	            int rand = (int) (Math.random() * 2);
	            if (rand == 0) {
	                nodeList.add(NodeFactory.getThreeDNode());
	            } else {
	                nodeList.add(NodeFactory.getNode());
	            }
	        } catch (Exception e) {
	            System.out.println("Error creating node: " + e.getMessage());
	        }
	    }
		}
	
	/**
	 * Clears all elements from the Arraylist
	 */
	public void clear() {
		nodeList.clear();
	}
	
	/**
	 * Counts the number of Node objects in the ArrayList
	 * @return the number of Node objects
	 */
	public int countNodes() {
		int count = 0;
		for(INode node: nodeList) {
			if(node instanceof Node) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Counts the number of ThreeDNode objects in the ArrayList
	 * @return The number of threeDNode objects
	 */
	public int countThreeDNodes() {
		int count = 0;
		for (INode node: nodeList) {
			if(node instanceof ThreeDNode) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Sorts the ArrayList based on the sum of coordinates
	 */
	public void sort() {
		nodeList.sort(new Sorter());
	}
	
	/**
	 * Returns a multi-line string representation of the Nodes collection
	 * @return a multi line string representation of the Nodes
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(INode node: nodeList) {
			sb.append(node.toString()).append("\n");
		}
		return sb.toString();
	}
	
}

/**
 * The Sorter class provides a comparator for sorting INode objects based on the sum of coordinates
 */
class Sorter implements Comparator<INode>{
	/**
	 * Compares two INode objects based on the sum of their coordinates
	 * @param node1 the first INode to compare
	 * @param node2 the second INode to compare
	 * @return an integer value indicating the comparison result
	 */
	@Override
	public int compare(INode node1, INode node2) {
		int sum1 = getSum(node1);
		int sum2 = getSum(node2);
		return Integer.compare(sum1, sum2);
	}
	
	/**
	 * Calculates the sum of coordinates for the given INode
	 * @param node The INode object for which to calculate the sum of the coordinates
	 * @return The sum of coordinates
	 */
	private int getSum(INode node) {
		if (node instanceof ThreeDNode) {
			ThreeDNode threeDNode = (ThreeDNode) node;
			return threeDNode.getX() + threeDNode.getY() + threeDNode.getZ();
		} else {
			Node baseNode = (Node) node;
			return baseNode.getX() + baseNode.getY();
		}
	}
	
	
}
