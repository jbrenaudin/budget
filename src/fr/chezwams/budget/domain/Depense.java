package fr.chezwams.budget.domain;

import java.util.Date;

public class Depense {

	private SubCategory subCategory;
	private Person person;
	private float montant;
	private Date created;

	public Depense(SubCategory subCategory, Person person, float montant, Date created) {
		this.subCategory = subCategory;
		this.person = person;
		this.montant = montant;
		this.created = created;
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

	public Date created() {
		return created;
	}
}
