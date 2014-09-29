package fr.chezwams.budget.domain;

public class Repositories {

	public static BudgetRepository forBudget() {
		return new BudgetRepository();
	}

	public static PersonRepository forPerson() {
		return new PersonRepository();
	}

	public static CategoryRepository forCategory() {
		return new CategoryRepository();
	}
}
