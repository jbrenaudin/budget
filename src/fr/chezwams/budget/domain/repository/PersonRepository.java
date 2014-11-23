package fr.chezwams.budget.domain.repository;

import static java.util.Arrays.asList;

import java.util.List;

import fr.chezwams.budget.domain.Person;

public class PersonRepository {

	public List<Person> all() {
		return asList(
				new Person("JB"), 
				new Person("Angy")
			);
	}
}
