package fr.chezwams.budget.domain.repository;

import java.util.Date;

import fr.chezwams.budget.domain.Budget;

public class BudgetRepository {

	public Budget getByToday() {
		return new Budget(new Date().getMonth());
	}
}
