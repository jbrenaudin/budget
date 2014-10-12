package fr.chezwams.budget.domain.repository;

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import fr.chezwams.budget.domain.Depense;
import fr.chezwams.budget.domain.Person;

public class DepenseRepository {

	public List<Depense> all() {
		return asList(
			new Depense(Repositories.ofCategory().getSubCategoryByName("Loyer"), new Person("JB"), 900F, new Date(2014, 9, 1)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 30F, new Date(2014, 9, 10)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 10F, new Date(2014, 9, 5)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 28.79F, new Date(2014, 9, 16)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 45.11F, new Date(2014, 10, 18)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 57.79F, new Date(2014, 10, 20)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Electricité"), new Person("Angy"), 80F, new Date(2014, 9, 1)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Eau"), new Person("Angy"), 21F, new Date(2014, 9, 1)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Assurance Maison"), new Person("Angy"), 16F, new Date(2014, 9, 1)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 100F, new Date(2014, 9, 3)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 75F, new Date(2014, 9, 5)),
			new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 82.80F, new Date(2014, 10, 1))
		);
	}

	public List<Depense> getByMonth(final int month) {
		List<Depense> depenses = new LinkedList<Depense>();
		for(Depense depense : all()) {
			if(depense.created().getMonth() == (month - 1)) {
				depenses.add(depense);
			}
		}
		Collections.sort(depenses, new Comparator<Depense>() {
			@Override
			public int compare(Depense o1, Depense o2) {
				return o1.created().compareTo(o2.created());
			}
		});
		return depenses;
	}

}
