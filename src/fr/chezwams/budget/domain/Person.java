package fr.chezwams.budget.domain;

public class Person {

	private int id;

	private String name;

	public Person() {}

	public Person(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Person) obj).name);
	}

	@Override
	public String toString() {
		return name;
	}
}
