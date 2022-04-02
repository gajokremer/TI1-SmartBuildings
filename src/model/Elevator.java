package model;

public class Elevator {

//	private int location;
//	private boolean direction;
	private MyPriorityQueue<Person> entrance;
	private MyStack<Person> exit;
	
	public Elevator() {
//		location = 1;
//		direction = true;
//		entrance = new MyPriorityQueue<>(Collections.reverseOrder());
		entrance = new MyPriorityQueue<>();
		exit = new MyStack<>();
	}
	
//	public int getLocation() {
//		return location;
//	}
//
//	public boolean isDirection() {
//		return direction;
//	}

	public MyPriorityQueue<Person> getEntrance() {
		return entrance;
	}

	public MyStack<Person> getExit() {
		return exit;
	}

//	public void setLocation(int location) {
//		this.location = location;
//	}
//
//	public void setDirection(boolean direction) {
//		this.direction = direction;
//	}

	public void setEntrance(MyPriorityQueue<Person> entrance) {
		this.entrance = entrance;
	}

	public void setExit(MyStack<Person> exit) {
		this.exit = exit;
	}
	
//	public void changeDirection() {
//		
//		if(direction == true) direction = false;
//		if(direction == false) direction = true;
//	}
//	
//	public void moveUp(int buildingSize) {
//		
//		if(location <= buildingSize) {
//			
//			location = location+1;
//		}
//	}
//	
//	public void moveDown(int buildingSize) {
//		
//		if(location >= 1) {
//			
//			location = location-1;
//		}
//	}
	
//	@Override
//	public String toString() {
//		return "\n--" + elevatorEntrance + "\n--" + elevatorExit; 
//	}

	@Override
	public String toString() {
		return 
//				"\n--Location: " + location +
//				"\n--Direction: " + direction + 
				"\n--Entrance: " + entrance + " Head: "  + entrance.peek().toString();
//				+ 
//				"\n--Exit: " + exit + " Head: " + exit.peek().toString();
	}
}