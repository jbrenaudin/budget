package fr.chezwams.budget.domain.repository;

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

	public static RevenueRepository ofRevenue() {
		return new RevenueRepository();
	}

	public static DepenseRepository ofDepense() {
		return new DepenseRepository();
	}
}
