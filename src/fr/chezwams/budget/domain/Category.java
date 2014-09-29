package fr.chezwams.budget.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String name;
	private List<SubCategory> subcategories;

	public Category(String name) {
		this.name = name;
		this.subcategories = new ArrayList<SubCategory>();
	}

	public String name() {
		return name;
	}

	public List<SubCategory> subCategories() {
		return this.subcategories;
	}

	public Category addSubCategory(String category) {
		this.subcategories.add(new SubCategory(category, this));
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((Category) obj).name);
	}
}
