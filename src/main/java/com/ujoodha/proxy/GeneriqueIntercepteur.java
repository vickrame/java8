/**
 * 
 */
package com.ujoodha.proxy;

/**
 * @author vickrame
 *
 */
@Intercepteur
public class GeneriqueIntercepteur {

	private static ThreadLocal<String> data = new ThreadLocal<String>();

	public String invocation() {
		return data.get();
	}

	public void alim(String nom) {
		data.set(nom);
	}

}
