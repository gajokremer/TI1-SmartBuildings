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
//						"(2) to run simulation\n" +
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
//				simulator.getBuildings().removeAll(simulator.getBuildings());
				simulator.getBuildings().removeAll();
				inputData();
				run();
				mainMenu();
				break;
				
//			case 2:
//				run();
//				mainMenu();
//				break;
				
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
		
		for (int i = 0; i < size; i++) {
			
			buildingData(i+1);
			System.out.println("Done...");
		}
		
		System.out.println("\nBUILDINGS: " + simulator.getBuildings());
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
		
//		int totalOffices = numFloors * numOfficesByFloor;
		
		Building b = simulator.createBuilding(id, numFloors, numOfficesByFloor);
//		System.out.println(b.getFloors());
		
//		manager.addPeople(b, numPeople);
		
		b = peopleData(b, numPeople);
		b = simulator.locateInExit(b);
		
		simulator.getBuildings().add(b);
	}
	
	private Building peopleData(Building b, int numPeople) {
		
		System.out.println();
		
		for(int i = 0; i < numPeople; i++) {
			
			System.out.print("--Person " + (i + 1) + ": ");
			String line = sc.nextLine();
			
			String[] data = line.split(" ");
			String name = data[0];
			int location = Integer.parseInt(data[1]);
			int destination = Integer.parseInt(data[2]);
			
			Person p = new Person(name, location, destination);
			
//			System.out.println(p.getName());
			
			b = simulator.locateInFloors(b, p, location);
			b = simulator.locateInEntrance(b, p);
			
//			System.out.println(b);

//			System.out.println(b.getFloors());

			
//			Person p = new Person(name, location, destination);
			
//			System.out.println("Location: " + location);
			
//			b.getElevatorEntrance().add(p);
			
//			simulator.getBuildings().add(b);

//			System.out.println("Floors: " + b.getFloors());
//			System.out.println("Elevator: " + b.getElevatorEntrance());
		}

//		simulator.getBuildings().add(b);
//		System.out.println(b);
		
		return b;
	}
	
	private void run() {

		System.out.println("\n------Run------");

//		System.out.println(simulator.getBuildings());
		
		System.out.println("Size: " + simulator.getBuildings().size());
		
		for(int i = 0; i < simulator.getBuildings().size(); i++) {
			
//			System.out.println(i);
//			System.out.println("Size: " + simulator.getBuildings().size());
			
			System.out.println(simulator.runSimulation(simulator.getBuildings().get(i)));
			
//			System.out.println(simulator.getBuildings());
		}
	}
	
	private Person finder() {
		
		System.out.println("\n------Finder------");
		
//		System.out.print("\nID + Key: ");
//		String line = sc.nextLine();
//		String[] data = line.split(" ");
//		
//		char id = line.charAt(0);
//		int key = Integer.parseInt(data[1]);
		
		System.out.print("\nBuilding ID: ");
		String line = sc.nextLine();
		char id = line.charAt(0);
		
		System.out.print("Key: ");
		int key = sc.nextInt();
		
		Person p = null;
		
		for(int i = 0; i < simulator.getBuildings().size(); i++) {
			
			Building b = simulator.getBuildings().get(i);
			
//			System.out.println("B:" + b);
			
			if(b.getId() == id) {
				
//				p = b.getFloors().get(key);
			}
		}
		
		return p;
	}
}