/**
 * 
 */
package com.ujoodha.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vickrame
 *
 */
public class ResourceAtomic extends AbResources {

	private AtomicInteger solde = null;

	private volatile boolean soldeNegatif = false;

	public ResourceAtomic() {
		solde = new AtomicInteger();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ujoodha.thread.IResource#credit(int)
	 */
	@Override
	public int credit(int somme) {
		solde.addAndGet(somme);
		int result = solde.get();

		if (result <= 0) {
			soldeNegatif = true;
		} else {
			soldeNegatif = false;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ujoodha.thread.IResource#debiter(int)
	 */
	@Override
	public void debiter(int somme) {
		while (soldeNegatif) {
			System.err.println(Thread.currentThread().getName() + "en att");
		}
		credit(-somme);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ujoodha.thread.AbResources#getSolde()
	 */
	@Override
	public int getSolde() {
		// TODO Auto-generated method stub
		return solde.get();
	}

	/**
	 * @return the soldeNegatif
	 */
	public boolean isSoldeNegatif() {
		return soldeNegatif;
	}

	/**
	 * @param soldeNegatif
	 *            the soldeNegatif to set
	 */
	public void setSoldeNegatif(boolean soldeNegatif) {
		this.soldeNegatif = soldeNegatif;
	}

}
