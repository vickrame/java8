package com.ujoodha.lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 */

/**
 * @author vickrame
 *
 */
public class MyArrayList<E> extends ArrayList<E> implements List<E>,
		Consumer<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2529495741545361451L;
	private boolean filtre = false;

	@Override
	public void accept(E t) {

		if (t.equals("coucou")) {
			System.out.println("je porte coucou");
			filtre = true;
		} else {
			System.out.println("je ne porte pas coucou");
			filtre = false;
		}

	}

}
