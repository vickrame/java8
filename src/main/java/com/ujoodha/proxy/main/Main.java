/**
 * 
 */
package com.ujoodha.proxy.main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.ujoodha.proxy.FunctionnalBuisiness;
import com.ujoodha.proxy.IFunctionnalBusiness;

/**
 * @author vickrame
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long debut = System.currentTimeMillis();
		FunctionnalBuisiness f = new FunctionnalBuisiness();

		f.doTheJob();
		System.out.println(System.currentTimeMillis() - debut);

		IFunctionnalBusiness iF = null;
		InvocationHandler handler = new MyInvocationHandler();

		iF = (IFunctionnalBusiness) Proxy.newProxyInstance(
				IFunctionnalBusiness.class.getClassLoader(),
				new Class[] { IFunctionnalBusiness.class }, handler);

		// redefinition

		debut = System.currentTimeMillis();
		iF.doTheJob();
		System.out.println(System.currentTimeMillis() - debut);

	}

}
