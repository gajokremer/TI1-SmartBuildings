package model;

public class Person implements Comparable<Person> {
	
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
		return name;
	}

	@Override
	public int compareTo(Person p) {
		
		if(destination < p.getDestination()) {
			
			return -1;
			
		} else if(p.getDestination() > destination) {
			
			return 1;
		}
		
		return 0;
	}
}