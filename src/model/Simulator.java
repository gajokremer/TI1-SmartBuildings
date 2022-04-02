package model;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Simulator {

	private MyArrayList<Building> buildings;

	public Simulator() {

		buildings = new MyArrayList<>();
	}

	public MyArrayList<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(MyArrayList<Building> buildings) {
		this.buildings = buildings;
	}

	public Building createBuilding(char id, int numFloors, int numOfficesByFloor) {
		
		Building b = new Building(id);
		
		MyHashMap<Integer, Queue<Person>> floors = new MyHashMap<>();
		MyHashMap<Integer, Person> offices = new MyHashMap<>();
		
		int totalOffices = numFloors * numOfficesByFloor;

		for(int i = 1; i <= numFloors; i++) {
			
			Queue<Person> q = new LinkedList<>();
			
			floors.put(i, q);
		}

		for(int i = 1; i <= totalOffices; i++) {
			
			offices.put(i, null);
		}
		
		b.setFloors(floors);
		b.setOffices(offices);
		
//		System.out.println(b);
		
//		b.setFloors(f);
//		buildings.add(b);

//		System.out.println("Id: " + b.getId());
//		System.out.println("F: " + b.getFloors());
		
		return b;
	}
	
	public Building locateInFloors(Building b, Person p, int location) {
		
		b.getFloors().get(location).add(p);
		
		return b;
	}
	
	public Building locateInEntrance(Building b, Person p) {
		
		b.getElevator().getEntrance().offer(p);
		
//		System.out.println("\nEntrance: " + b.getElevator().getEntrance());

		return b;
	}
	
	public Building locateInExit(Building b){
		
		
		MyStack<Person> exit = new MyStack<>();
		PriorityQueue<Person> entranceCopy = b.getElevator().getEntrance();
		
		int entranceSize = b.getElevator().getEntrance().size();
		
		for(int i = 0; i < entranceSize; i++) {
			
			exit.push(entranceCopy.poll());
		}
		
//		exit.addAll(b.getElevator().getEntrance());
		b.getElevator().setExit(exit);
		
		return b;
	}
	
	public String runSimulation(Building b) {
		
		String line = "";
		
		MyStack<Person> exit = b.getElevator().getExit();
		int size = exit.size();
		
		for(int i = 0; i < size; i++) {
			
			Person p = exit.pop();
			b.getElevator().setExit(exit);
			
			if(b.getOffices().containsKey(p.getDestination())) {
				
				b.getOffices().replace(p.getDestination(), p);
				
//				System.out.println(b.getOffices().containsKey(p.getDestination()));
//				System.out.println(b.getOffices().get(p.getDestination()));
//				
//				System.out.println("Destination: " + p.getDestination());
//				System.out.println("Offices: " + b.getOffices());
				
				b.getElevator().setEntrance(null);
				
				line += "\n-" + p.getName() + " moved to office " + p.getDestination();
				
			} else {
				
				line += "\n-" + p.getName() + " cannot enter a non-existant office";
			}
				
		}
		
		line += "\n\nOffices for Building " + b.getId() + ": " + 
				"\n" + b.getOffices() + "\n";
		
		return line;
	}
	
//	public void addPeople(Building b, int numPeople) {
//
//		
//	}
	
//	public String printBuildings() {
//		
//		String line = "";
//		
//		for(int i = 0; i < buildings.size(); i ++) {
//			
//			line += buildings.get(i).getId() + ", ";
//		}
//		
//		return line;
//	}
}