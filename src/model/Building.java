package model;

public class Building {

	private char id;
	private Elevator elevator;
	private MyHashMap<Integer, MyQueue<Person>> floors;
	private MyHashMap<Integer, Person> offices;
	
	public Building(char id) {
		this.id = id;
		elevator = new Elevator();
		floors = new MyHashMap<>();
	}

	public char getId() {
		return id;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public MyHashMap<Integer, MyQueue<Person>> getFloors() {
		return floors;
	}

	public MyHashMap<Integer, Person> getOffices() {
		return offices;
	}

	public void setId(char id) {
		this.id = id;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public void setFloors(MyHashMap<Integer, MyQueue<Person>> floors) {
		this.floors = floors;
	}

	public void setOffices(MyHashMap<Integer, Person> offices) {
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
				"\n======================\n";
	}
}