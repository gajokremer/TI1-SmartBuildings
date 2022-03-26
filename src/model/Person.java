package model;

public class Person {
	
	private String name;
//	private int location;
	private int destination;
	
//	public Person(String name, int location, int destination) {
//		this.name = name;
//		this.location = location;
//		this.destination = destination;
//	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, int destination) {
		this.name = name;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}