/**
 * 
 */
package com.ujoodha.stream;

import java.util.function.Predicate;

import com.ujoodha.thread.habilitation.User;

/**
 * @author vickrame
 *
 *
 */
@FunctionalInterface
public interface CustumPredicate<T> extends Predicate<T> {

	default public boolean test(T input, Class o, Object value,
			EnumarationSens sens) {

		if (Integer.class.isInstance(value) || Boolean.class.isInstance(value)) {

			if (Boolean.class.isInstance(value)) {
				return test(input);
			} else {
				User u = (User) input;
				if (sens.equals(EnumarationSens.EGAL)) {
					return value.equals(u.getAge());
				} else if (sens.equals(EnumarationSens.INF)) {
					return (Integer.valueOf(value + "").intValue() > (u
							.getAge()));
				} else {
					return (Integer.valueOf(value + "").intValue() < (u
							.getAge()));
				}
			}
		} else {
			return value.equals(input);
		}

	}
}
