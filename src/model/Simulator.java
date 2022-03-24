package model;

import java.util.ArrayList;
import java.util.HashMap;

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

	public Building createBuilding(char id, int totalOffices) {
		
		Building b = new Building(id);
		
		HashMap<Integer, Person> f = new HashMap<>();

		for(int i = 1; i <= totalOffices; i++) {
			
			f.put(i, null);
		}
		
		b.setFloors(f);
//		buildings.add(b);

//		System.out.println("Id: " + b.getId());
//		System.out.println("F: " + b.getFloors());
		
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