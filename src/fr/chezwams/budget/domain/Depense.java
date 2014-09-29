package fr.chezwams.budget.domain;

public class Depense {

	private SubCategory subCategory;
	private Person person;
	private float montant;

	public Depense(SubCategory subCategory, Person person, float montant) {
		this.subCategory = subCategory;
		this.person = person;
		this.montant = montant;
	}

	public SubCategory subCategory() {
		return subCategory;
	}

	public Person person() {
		return person;
	}

	public float montant() {
		return montant;
	}
}
