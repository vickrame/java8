package com.ujoodha.lambda.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.ujoodha.lambda.Lambda.Calculator;
import com.ujoodha.lambda.Lambda.IValidator;
import com.ujoodha.lambda.Lambda.Personne;
import com.ujoodha.lambda.MyArrayList;

public class Main {

	public static void main(String[] args) {

		// lambda ()-> veut dire sans parametre
		// avant -> apres : avant correspond au parametre
		// apres correspond aux operations effectuées.

		Calculator cal = (x, y) -> x + y;

		System.out.println(cal.calcul(3, 4));

		IValidator<Integer> valIn = (Integer a, Integer b) -> {
			return (a.equals(b)) ? true : false;
		};

		IValidator<Integer> valEntier = (Integer x, Integer y) -> {
			return (x.compareTo(x) < 0) ? true : false;
		};

		IValidator<Personne> compareAge = (Personne x, Personne y) -> {
			return (x.getAge() <= y.getAge()) ? true : false;
		};

		Z zz = (Iterable<String> list) -> {
			int size = 0;
			Iterator<String> it = list.iterator();
			while (it.hasNext()) {
				System.out.println("size " + size++);
				it.next();
			}
			;
			return size;
		};

		Z dd = (Iterable<String> list) -> {
			String ret = "";
			Iterator<String> it = list.iterator();
			while (it.hasNext()) {
				ret = ret + it.next();
			}
			;
			return ret.length();
		};

		List<String> list = Arrays.asList(new String[] { "coucou", "toto" });

		System.out.println("nombre d'element " + zz.m(list));
		;
		System.out.println("taille des element dans la liste " + dd.m(list));
		;

		System.out.println("Affiche contenu de la liste");
		Z ff = (Iterable<String> listStr) -> {
			int i = 0;
			listStr.forEach(System.out::println);
			;
			return 0;

		};

		ff.m(list);

		MyArrayList<String> listStr = (MyArrayList<String>) Arrays
				.asList(new String[] { "coucou", "toto" });

		listStr.forEach(System.out::print);
	}

}
