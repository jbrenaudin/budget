package fr.chezwams.budget.domain.repository;

import static java.util.Arrays.asList;

import java.util.List;

import fr.chezwams.budget.domain.Person;
import fr.chezwams.budget.domain.Revenue;

public class RevenueRepository {

	public List<Revenue> all() {
		return asList(
			new Revenue(new Person("JB"), 2000F), 
			new Revenue(new Person("Angy"), 1900F)
		);
	}
}
