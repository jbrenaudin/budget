package fr.chezwams.budget.domain;

import static java.util.Arrays.asList;

import java.util.List;

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
					.addSubCategory("Alimentation Chat")
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
