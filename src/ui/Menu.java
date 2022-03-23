package ui;

import java.util.Scanner;

import model.Building;
import model.Manager;
import model.Person;

public class Menu {

	private Manager manager;
	private Scanner sc;

	public Menu() {

		sc = new Scanner(System.in);
		manager = new Manager();
	}

	public void mainMenu() {
		
//		manager.createBuilding('A', 8);
		
		inputData();

//		int option = 0;
//
//		System.out.println("\n\n--------MAIN MENU--------\n");
//
//		System.out.println(
//				"\nSelect an option:\n" + 
//						"(1) to start" + 
//
//				"\n\n(0) to exit");
//
//		option = sc.nextInt();
//		sc.nextLine();
//
//		if(option != 0) {
//
//			switch(option) {
//
//			default:
//
//				System.out.println("\n---Invalid Option");
//				mainMenu();
//				break;
//
//			case 1:
//				inputData();
//				mainMenu();
//				break;
//			} 
//
//		} else if (option == 0) {
//
//			System.out.println("\n-----OPERATION ENDED-----\n");
//		}
	}

	private void inputData() {
		
		System.out.print("Building #: ");
		int size = sc.nextInt();
		sc.nextLine();
		
//		int i = 1;
		
		for (int i = 1; i <= size; i++) {
			
			buildingData(i);
			System.out.println("Done...");
		}
		
//		while(i <= size) {
//			
//			buildingData(i);
//			System.out.println("Done...");
//			i = i+1;
//		}
	}

	private void buildingData(int i) {

		System.out.print("\n-Building " + i + " data: ");
		String line = sc.nextLine();
		String[] data = line.split(" ");
		
//		System.out.println(data[0]);

		char id = line.charAt(0);
		int numPeople = Integer.parseInt(data[1]);
		int numFloors = Integer.parseInt(data[2]);
		int numOfficesByFloor = Integer.parseInt(data[3]);
		
		int totalOffices = numFloors * numOfficesByFloor;
		
		Building b = manager.createBuilding(id, totalOffices);
		System.out.println(b.getFloors());
		
//		manager.addPeople(b, numPeople);
		
		peopleData(b, numPeople);
	}
	
	private void peopleData(Building b, int numPeople) {
		
		for(int i = 1; i <= numPeople; i++) {
			
			System.out.print("\nPerson " + i + ": ");
			String line = sc.nextLine();
			
			String[] data = line.split(" ");
			String name = data[0];
			int destination = Integer.parseInt(data[2]);
			
			Person p = new Person(name, destination);
			
			int location = Integer.parseInt(data[1]);
			b.getFloors().put(location, p);

			System.out.println(b.getFloors());
		}
	}
}