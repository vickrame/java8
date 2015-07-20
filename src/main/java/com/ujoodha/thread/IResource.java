/**
 * 
 */
package com.ujoodha.thread;

/**
 * @author vickrame
 *
 */
public interface IResource {

	public int credit(final int somme);

	public void debiter(final int somme);

	public int getSolde();
}
