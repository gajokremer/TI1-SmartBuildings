package model;

import java.util.HashMap;
import java.util.Queue;

public class Building {

	private char id;
	private Elevator elevator;
	private HashMap<Integer, Queue<Person>> floors;
	private HashMap<Integer, Person> offices;
	
	public Building(char id) {
		
		this.id = id;
		elevator = new Elevator();
		floors = new HashMap<>();
	}

	public char getId() {
		return id;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public HashMap<Integer, Queue<Person>> getFloors() {
		return floors;
	}

	public HashMap<Integer, Person> getOffices() {
		return offices;
	}

	public void setId(char id) {
		this.id = id;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public void setFloors(HashMap<Integer, Queue<Person>> floors) {
		this.floors = floors;
	}

	public void setOffices(HashMap<Integer, Person> offices) {
		this.offices = offices;
	}
	
//	@Override
//	public String toString() {
//
//		return "\n======================" + 
//				"\n-" + id + "\n-" + elevator + "\n-" + floors + "\n-" + offices + 
//				"\n======================\n";
//	}
	
	@Override
	public String toString() {
		return "\n======================" + 
				"\n-Id: " + id + 
				"\n-Elevator: " + elevator + 
				"\n-Floors: " + floors + 
				"\n-Offices: " + offices + 
				"\n======================";
	}
}