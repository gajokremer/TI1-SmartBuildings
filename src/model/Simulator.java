package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Simulator {

	private ArrayList<Building> buildings;

	public Simulator() {

		buildings = new ArrayList<>();
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}

	public Building createBuilding(char id, int numFloors, int numOfficesByFloor) {
		
		Building b = new Building(id);
		
		HashMap<Integer, Queue<Person>> floors = new HashMap<>();
		HashMap<Integer, Person> offices = new HashMap<>();
		
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
	
	public Building locateInFloor(Building b, Person p, int location) {
		
		b.getFloors().get(location).add(p);
		
		return b;
	}

//	public void addPeople(Building b, int numPeople) {
//
//		
//	}
	
	public void run() {
		
		
	}
	
	public String printBuildings() {
		
		String line = "";
		
		for(int i = 0; i < buildings.size(); i ++) {
			
			line += buildings.get(i).getId() + ", ";
		}
		
		return line;
	}
}