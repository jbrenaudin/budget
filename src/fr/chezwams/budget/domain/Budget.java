package fr.chezwams.budget.domain;

import java.text.DateFormatSymbols;
import java.util.List;

import fr.chezwams.budget.domain.repository.Repositories;

public class Budget {

	private List<Revenue> revenues;
	private List<Depense> depenses;
	private String month;
	
	public Budget(int month) {
		this.revenues = Repositories.ofRevenue().all();
		this.depenses = Repositories.ofDepense().getByMonth(month); 
		this.month = new DateFormatSymbols().getMonths()[month - 1];
	}

	public String month() {
		return month;
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
