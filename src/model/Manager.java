package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

	private ArrayList<Building> buildings;

	public Manager() {

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

	public void addPeople(Building b, int numPeople) {

		
	}
}