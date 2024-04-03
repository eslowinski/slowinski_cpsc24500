package a5;

public interface INode extends Comparable<Object> {
	public static final int LOWER_LIMIT = -100;  
	public static final int UPPER_LIMIT =  100;
	static final int DEFAULT_X =0; 
	static final int DEFAULT_Y =0;
	
	
	public void add(Node INode) throws Exception;

}
