package a5;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Nodes nodes = new Nodes();
		
		int choice;
		
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Fill");
			System.out.println("2. Clear");
			System.out.println("3. Count Nodes");
			System.out.println("4. Count ThreeDNodes");
			System.out.println("5. Sort");
			System.out.println("6. Display");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					System.out.print("Enter the size to fill: ");
					int size = sc.nextInt();
					nodes.fill(size);
					break;
				case 2:
					nodes.clear();
					break;
				case 3:
					System.out.println("Number of Nodes: " + nodes.countNodes());
					break;
				case 4:
					System.out.println("Number of ThreeDNodes: " + nodes.countThreeDNodes());
					break;
				case 5:
					nodes.sort();
					break;
				case 6:
					System.out.println("Nodes: ");
					System.out.println(nodes);
					break;
				case 7:
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1-7");
					}
				} while (choice != 7);
				sc.close();
	}
}
