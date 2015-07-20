/**
 * 
 */
package com.ujoodha.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ujoodha.thread.habilitation.User;

/**
 * @author vickrame
 *
 */
public class StreamTest {

	private static List<User> lstUser;
	private static Comparator<User> compareAge;
	private static Predicate<User> filtre;
	// private static Predicate<User> sexe;
	private static CustumPredicate<User> customPredicate;

	private static int age = 40;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lstUser = RepoData.jeuDonnee();

		compareAge = (User a, User b) -> {
			if (a.getAge() < b.getAge())
				return -1;
			else if (a.getAge() == b.getAge()) {
				return a.getPrenom().compareTo(b.getPrenom());
			} else
				return 1;

		};

		filtre = (User a) -> {
			boolean ret = false;

			if (a.getAge() < age)
				ret = true;
			else
				ret = false;

			return ret;
		};

		customPredicate = (User a) -> {
			boolean ret = true;
			return ret;
		};

	}

	@Test
	public void testPrintStream() {
		System.out.println("Test 1");

		System.out.println("transformation en stream");
		Stream<User> stream = lstUser.stream().sorted(compareAge);

		System.out.println("print stream");
		stream.forEach(System.out::println);

		stream.close();
	}

	@Test
	public void testTriInverse() {
		System.out.println("Test 2");

		System.out.println("transformation en stream");
		Stream<User> stream = lstUser.stream().sorted(compareAge.reversed());

		System.out.println("print stream");
		stream.forEach(System.out::println);

		stream.close();
	}

	@Test(expected = java.lang.IllegalStateException.class)
	public void testReUseStream() {
		System.out.println("Test 3");

		System.out.println("transformation en stream");
		Stream<User> stream = lstUser.stream().sorted(compareAge);

		System.out.println("print stream");
		stream.forEach(System.out::println);

		System.out.println("tri inverse");
		try {
			stream.sorted(compareAge.reversed()).forEach(System.out::println);
		} catch (IllegalStateException e) {
			System.err.println(e);
			throw e;
		}
		stream.close();
	}

	@Test
	public void testFiltreAge() {
		System.out.println("Test 4");

		System.out.println("transformation en stream");
		Stream<User> stream = lstUser.stream().sorted(compareAge.reversed())
				.filter(filtre);

		System.out.println("print stream");
		List<User> finalList = null;
		User[] tabUser = (User[]) stream.peek(
				user -> System.out.println(user.toString())).toArray(
				User[]::new);

		assertNotNull(tabUser);

		finalList = Arrays.asList(tabUser);

		assertEquals("taille de la liste", 4, finalList.size());

		stream.close();
	}

	@Test
	public void testFiltreDynamicAge() {
		System.out.println("Test 5");

		System.out.println("transformation en stream");

		Stream<User> stream = lstUser
				.stream()
				.sorted(compareAge.reversed())
				.filter(filtre)
				.filter(u -> customPredicate.test(u, int.class, 36,
						EnumarationSens.EGAL));

		System.out.println("print stream");
		List<User> finalList = null;
		User[] tabUser = (User[]) stream.peek(
				user -> System.out.println(user.toString())).toArray(
				User[]::new);

		assertNotNull(tabUser);

		finalList = Arrays.asList(tabUser);

		assertEquals("taille de la liste", 1, finalList.size());

		stream.close();
	}

	@Test
	public void testFiltreDynamic() {
		System.out.println("Test 6");

		Stream<User> stream = lstUser
				.stream()
				.sorted(compareAge.reversed())
				.filter(filtre)
				.filter(u -> customPredicate.test(u, int.class, 36,
						EnumarationSens.INF));

		System.out.println("print stream");
		List<User> finalList = null;
		User[] tabUser = (User[]) stream.peek(
				user -> System.out.println(user.toString())).toArray(
				User[]::new);

		assertNotNull(tabUser);

		finalList = Arrays.asList(tabUser);

		assertEquals("taille de la liste", 3, finalList.size());

		stream.close();
	}
}
