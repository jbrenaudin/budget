package fr.chezwams.budget.domain;

public class SubCategory {

	private String name;
	private Category category;

	public SubCategory(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public String name() {
		return name;
	}

	public Category category() {
		return category;
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((SubCategory) obj).name)
				&& category.equals(((SubCategory) obj).category);
	}
}