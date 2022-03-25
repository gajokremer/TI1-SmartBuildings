package model;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Elevator {

	private PriorityQueue<Person> elevatorEntrance;
	private Stack<Person> elevatorExit;
	
	public Elevator() {
		
		elevatorEntrance = new PriorityQueue<>(Collections.reverseOrder());
		elevatorExit = new Stack<>();
	}

	public PriorityQueue<Person> getElevatorEntrance() {
		return elevatorEntrance;
	}

	public Stack<Person> getElevatorExit() {
		return elevatorExit;
	}

	public void setElevatorEntrance(PriorityQueue<Person> elevatorEntrance) {
		this.elevatorEntrance = elevatorEntrance;
	}

	public void setElevatorExit(Stack<Person> elevatorExit) {
		this.elevatorExit = elevatorExit;
	}
	
	@Override
	public String toString() {
		return "\n--" + elevatorEntrance + "\n--" + elevatorExit; 
	}
}