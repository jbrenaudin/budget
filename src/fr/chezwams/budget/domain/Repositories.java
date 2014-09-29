package fr.chezwams.budget.domain;

public class Repositories {

	public static BudgetRepository ofBudget() {
		return new BudgetRepository();
	}

	public static PersonRepository ofPerson() {
		return new PersonRepository();
	}

	public static CategoryRepository ofCategory() {
		return new CategoryRepository();
	}
}
