package fr.chezwams.budget.domain;

public class Person {

	private String name;

	public Person(String name) {
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
