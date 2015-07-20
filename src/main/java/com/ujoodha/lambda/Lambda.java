package com.ujoodha.lambda;

import java.io.Serializable;

public class Lambda {

	private static void showIdentity(Runnable runnable) {
		System.out.println("debut identity");
		System.out.printf(" les args %x ", System.identityHashCode(runnable));
		runnable.run();
		System.out.println("fin identity");
	}

	// dans la interface functionels il faut faire attention
	// au polymorphisme.
	//

	@FunctionalInterface
	public interface Calculator {
		public int calcul(final int a, final int b);

		// public int minus(final int a, final int b);
	}

	@FunctionalInterface
	public interface IValidator<T> {
		public boolean check(T a, T b);
	}

	// Functional: two methods, but they have the same signature

	@FunctionalInterface
	public interface IValidatorPrimitive<T> {
		public boolean checkPrimitive();
	}

	public interface IValid<T> extends IValidator<T>, IValidatorPrimitive<T> {
	}

	public class Personne implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1856559906742473746L;

		private String nom;
		private String prenom;
		private int age;

		/**
		 * @return the nom
		 */
		public String getNom() {
			return nom;
		}

		/**
		 * @param nom
		 *            the nom to set
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}

		/**
		 * @return the prenom
		 */
		public String getPrenom() {
			return prenom;
		}

		/**
		 * @param prenom
		 *            the prenom to set
		 */
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * @param age
		 *            the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}

	}
}
