package model;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Building {

	private char id;
	private HashMap<Integer, Person> floors;
	private PriorityQueue<Person> elevatorEntrance;
	private Stack<Person> elevatorExit;
	
	public Building(char id) {
		
		this.id = id;
		floors = new HashMap<Integer,Person>();
		elevatorEntrance = new PriorityQueue<>();
		elevatorExit = new Stack<>();
	}

	public char getId() {
		return id;
	}

	public HashMap<Integer, Person> getFloors() {
		return floors;
	}

	public PriorityQueue<Person> getElevatorEntrance() {
		return elevatorEntrance;
	}

	public Stack<Person> getElevatorExit() {
		return elevatorExit;
	}

	public void setId(char id) {
		this.id = id;
	}

	public void setFloors(HashMap<Integer, Person> floors) {
		this.floors = floors;
	}

	public void setElevatorEntrance(PriorityQueue<Person> elevatorEntrance) {
		this.elevatorEntrance = elevatorEntrance;
	}

	public void setElevatorExit(Stack<Person> elevatorExit) {
		this.elevatorExit = elevatorExit;
	}
}