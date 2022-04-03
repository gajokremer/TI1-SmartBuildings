package model;

public class Person implements Comparable<Person> {
	
	private String name;
	private int location;
	private int destination;
	
	public Person(String name, int location, int destination) {
		this.name = name;
		this.location = location;
		this.destination = destination;
	}
	
	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

	public int getDestination() {
		return destination;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(int location) {
		this.location = location;
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
		
		if(location < p.getLocation()) {
			
			return -1;
			
		} else if(location > p.getLocation()) {
			
			return 1;
		}
		
		return 0;
	}
}