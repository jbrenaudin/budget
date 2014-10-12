package fr.chezwams.budget.domain.repository;

import static java.util.Arrays.asList;

import java.util.List;

import fr.chezwams.budget.domain.Category;
import fr.chezwams.budget.domain.SubCategory;

public class CategoryRepository {

	public List<Category> all() {
		return asList(
				new Category("Logement")
					.addSubCategory("Loyer")
					.addSubCategory("Electricité")
					.addSubCategory("Eau")
					.addSubCategory("Assurance Maison"),
				new Category("Autre")
					.addSubCategory("Alimentation")
		);
	}

	public SubCategory getSubCategoryByName(String name) {
		for (Category category : all()) {
			for (SubCategory subCategory : category.subCategories()) {
				if (name.equals(subCategory.name())) {
					return subCategory;
				}
			}
		}
		return null;
	}
}
