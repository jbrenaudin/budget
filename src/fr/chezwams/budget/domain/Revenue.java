package fr.chezwams.budget.domain;

public class Revenue {

	private Person person;
	private float montant;

	public Revenue(Person person, float montant) {
		this.person = person;
		this.montant = montant;
	}

	public Person person() {
		return person;
	}

	public float montant() {
		return montant;
	}
}
