package model;

public class Person {
	
	private String name;
	private int destination;
	
	public Person(String name, int destination) {
		this.name = name;
		this.destination = destination;
	}
	
	public String getName() {
		return name;
	}

	public int getDestination() {
		return destination;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "(" + name + " -> " + destination + ")";
	}
}