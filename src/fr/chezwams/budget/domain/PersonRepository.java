package fr.chezwams.budget.domain;

import static java.util.Arrays.asList;

import java.util.List;

public class PersonRepository {

	public List<Person> all() {
		return asList(new Person("JB"), new Person("Angy"));
	}
}
