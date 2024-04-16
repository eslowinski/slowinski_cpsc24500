import java.util.Scanner;

public class Complex implements Comparable<Complex> {
	//real number
	private double a;
	
	//imaginary number
	private double b;
	
	//Constructor for (a,b)
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	//Constructor for b =0;
	public Complex(double a) {
		this(a,0);
	}
	
	//Copy Constructor
	public Complex(Complex complexNumber) {
		this(complexNumber.getRealPart(),complexNumber.getImaginaryPart());
	}
	
	//Constructor
	public Complex() {
		this(0,0);
	}
	
	/**gets the real number (a) 
	 * @return the value of a
	 */
	public double getRealPart() {
		return a;
	}
	
	/**
	 * gets the imaginary number (b)
	 * @return the value of b
	 */
	public double getImaginaryPart() {
		return b;
	}
	
	/**
	 * Method to return the addition of a and b
	 * @param other
	 * @return addition of a and b in a (#,#) format
	 */
	public Complex add(Complex other) {
		return new Complex(this.a + other.a, this.b + other.b);
	}
	
	/**
	 * Method to return the subtraction of a and b
	 * @param other
	 * @return subtraction of a and b in a (#,#) format
	 */
	public Complex subtract(Complex other) {
		return new Complex(this.a - other.a, this.b - other.b);
	}
	
	/**
	 * Method for multiplication
	 * @param other
	 * @return the multiplication of a and b
	 */
	public Complex multiply(Complex other) {
		return new Complex(this.a * other.a - b * other.b, this.b * other.a + this.a * other.b);
	}
	
	/**
	 * Method for division
	 * @param other
	 * @return the division of a and b
	 */
	public Complex divide(Complex other) {
		return new Complex((this.a * other.a + this.b * other.b) / 
				(Math.pow(other.a, 2) + Math.pow(other.b, 2)),
				(b * other.a - this.a * other.b) /
				(Math.pow(other.a, 2) + Math.pow(other.b, 2)));
				
	}
	
	/**
	 * Method for absolute value
	 * @return absolute value of a and b
	 */
	public double abs() {
		return Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));
	}

	//Override toStrin
	@Override
	public String toString() {
	return b == 0 ? a + "" :  + a + " + " + b + "i";
	}
	
	
	public int compareTo(Complex other) {
		return Double.compare(this.abs(),other.abs());
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first complex number:");
		double a1 = sc.nextDouble();
		double b1 = sc.nextDouble();
		Complex complex1 = new Complex(a1, b1);
		
		System.out.print("Enter the second complex number: ");
		double a2 = sc.nextDouble();
		double b2 = sc.nextDouble();
		Complex complex2 = new Complex(a2,b2);
		
		//Addition
		System.out.println("(" + complex1  +") + ("+ complex2 +") = " + complex1.add(complex2));

		//Subtraction
		System.out.println("(" + complex1  +") - ("+ complex2 +") = " + complex1.subtract(complex2));
		
		//multiplication
		System.out.println("(" + complex1  +") * ("+ complex2 +") = " + complex1.multiply(complex2));
		
		//division
		System.out.println("(" + complex1  +") / ("+ complex2 +") = " + complex1.divide(complex2));
		
		//absolute
		System.out.println("|" + complex1 + "| = " + complex1.abs());
		
		sc.close();
		
	}
	
}
