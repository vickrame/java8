/**
 * 
 */
package com.ujoodha.stream;

import java.util.Arrays;
import java.util.List;

import com.ujoodha.thread.habilitation.User;
import com.ujoodha.thread.habilitation.UserKey;

/**
 * @author vickrame
 *
 */
public class RepoData {

	/**
	 * 
	 */
	public static List<User> jeuDonnee() {
		UserKey clef = new UserKey();
		clef.setEmail("ujoodha.vickRAme@gmail.Com");

		UserKey clef2 = new UserKey();
		clef2.setEmail("rouat.Anne@gmail.Com");

		UserKey clef3 = new UserKey();
		clef3.setEmail("ujoodha.lea@gmail.Com");

		UserKey clef4 = new UserKey();
		clef4.setEmail("UJOOOdha.chloé@gmail.Com");

		User u1 = new User();
		u1.setNom("ujoodha");
		u1.setKey(clef);
		u1.setAge(36);
		u1.setPrenom("vickrame");
		u1.setSexe(EnumSexe.MASCULIN);
		u1.setCate(CategoriePersonne.ADULTE);

		User u2 = new User();
		u2.setNom("UJOODDHA");
		u2.setKey(clef2);
		u2.setAge(34);
		u2.setPrenom("anne");
		u2.setSexe(EnumSexe.FEMININ);
		u2.setCate(CategoriePersonne.ADULTE);

		User u3 = new User();
		u3.setNom("UJoodha");
		u3.setKey(clef3);
		u3.setAge(4);
		u3.setPrenom("lea");
		u3.setSexe(EnumSexe.FEMININ);
		u3.setCate(CategoriePersonne.ENFANT);

		User u4 = new User();
		u4.setNom("UJOODDHA");
		u4.setKey(clef4);
		u4.setAge(1);
		u4.setPrenom("chloé");
		u4.setSexe(EnumSexe.FEMININ);
		u4.setCate(CategoriePersonne.BEBE);

		return Arrays.asList(u1, u2, u3, u4);
	}
}
