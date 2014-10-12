package fr.chezwams.budget.domain;

import static java.util.Arrays.asList;

import java.util.List;

public class Budget {

	private List<Revenue> revenues;
	private List<Depense> depenses;

	public Budget() {
		this.revenues = asList(
				new Revenue(new Person("JB"), 2000F),
				new Revenue(new Person("Angy"), 1900F)
		);
		this.depenses = asList(
				new Depense(Repositories.ofCategory().getSubCategoryByName("Loyer"), new Person("JB"), 900F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 30F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 10F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 28.79F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 45.11F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("JB"), 57.79F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Electricité"), new Person("Angy"), 80F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Eau"), new Person("Angy"), 21F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Assurance Maison"), new Person("Angy"), 16F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 100F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 75F),
				new Depense(Repositories.ofCategory().getSubCategoryByName("Alimentation"), new Person("Angy"), 82.80F)
		);
	}

	public String month() {
		return "Septembre";
	}

	private float totalRevenues(Predicate predicate) {
		float result = 0F;
		for (Revenue revenue : revenues) {
			if (predicate.evaluate(revenue)) {
				result += revenue.montant();
			}
		}
		return result;
	}
	
	public float totalRevenues() {
		return totalRevenues(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return true;
			}
		});
	}
	
	public float totalRevenues(final Person person) {
		return totalRevenues(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return person.equals(((Revenue) obj).person());
			}
		});
	}

	private float totalDepenses(Predicate predicate) {
		float result = 0F;
		for (Depense depense : depenses) {
			if (predicate.evaluate(depense)) {
				result += depense.montant();
			}
		}
		return result;
	}
	
	public float totalDepenses() {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return true;
			}
		});
	}

	public float totalDepenses(final Person person) {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return person.equals(((Depense) obj).person());
			}
		});
	}
	
	public float totalDepenses(final SubCategory subCategory) {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return subCategory.equals(((Depense) obj).subCategory());
			}
		});
	}
	
	public float totalDepenses(final Category category) {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return category.equals(((Depense) obj).subCategory().category());
			}
		});
	}

	public float totalDepenses(final SubCategory subCategory, final Person person) {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return subCategory.equals(((Depense) obj).subCategory()) && person.equals(((Depense) obj).person());
			}
		});
	}

	public float totalDepenses(final Category category, final Person person) {
		return totalDepenses(new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				return category.equals(((Depense) obj).subCategory().category()) && person.equals(((Depense) obj).person());
			}
		});
	}
}
