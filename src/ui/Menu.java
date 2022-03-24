package ui;

import java.util.Scanner;

import model.Building;
import model.Simulator;
import model.Person;

public class Menu {

	private Simulator simulator;
	private Scanner sc;

	public Menu() {

		sc = new Scanner(System.in);
		simulator = new Simulator();
	}

	public void mainMenu() {
		
//		manager.createBuilding('A', 8);
		
//		inputData();
		
		int option = 0;

		System.out.println("\n\n========MAIN MENU========\n");

		System.out.println(
				"Select an option:\n" + 
						"(1) to input data\n" +
						"(2) to run simulation\n" +
						"(3) to find a person\n" + 

				"\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();
//
		if(option != 0) {

			switch(option) {

			default:

				System.out.println("\n---Invalid Option");
				mainMenu();
				break;

			case 1:
				simulator.getBuildings().removeAll(simulator.getBuildings());
				inputData();
//				System.out.println("Buildings: " + manager.printBuildings());
				mainMenu();
				break;
				
			case 2:
				simulator.run();
				break;
				
			case 3:
				System.out.println("Person: " + finder());
				mainMenu();
				break;
			} 

		} else if (option == 0) {

			System.out.println("\n-----OPERATION ENDED-----\n");
		}
	}

	private void inputData() {
		
		System.out.println("\n------Input Data------");
		
		System.out.print("\nBuilding #: ");
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
		
		Building b = simulator.createBuilding(id, totalOffices);
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
			
			simulator.getBuildings().add(b);

			System.out.println(b.getFloors());
		}
	}
	
	private Person finder() {
		
		System.out.println("\n------Finder------");
		
		System.out.print("\nID + Key: ");
		String line = sc.nextLine();
		String[] data = line.split(" ");
		
		char id = line.charAt(0);
		int key = Integer.parseInt(data[1]);
		
//		System.out.print("\nBuilding ID: ");
//		String line = sc.nextLine();
//		char id = line.charAt(0);
//		
//		System.out.print("Key: ");
//		int key = sc.nextInt();
		
		Person p = null;
		
		for(int i = 0; i < simulator.getBuildings().size(); i++) {
			
			Building b = simulator.getBuildings().get(i);
			
//			System.out.println("B:" + b);
			
			if(b.getId() == id) {
				
				p = b.getFloors().get(key);
			}
		}
		
		return p;
	}
}