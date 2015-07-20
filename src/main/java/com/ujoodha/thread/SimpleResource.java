/**
 * 
 */
package com.ujoodha.thread;

/**
 * @author vickrame
 *
 */
public class SimpleResource implements IResource {

	private int solde;

	private Object mutex = new Object();

	public SimpleResource() {
	}

	/**
	 * 
	 * @return
	 */
	public int getSolde() {
		return solde;
	}

	/**
	 * 
	 * @param solde
	 */
	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int credit(final int credit) {
		int result = 0;
		synchronized (mutex) {
			setSolde(getSolde() + credit);
			//
			result = getSolde();
			if (result > 0) {
				// // mutex.notifyAll();
				mutex.notifyAll();
			}
		}
		return result;
	}

	public void debiter(final int debit) {
		synchronized (mutex) {
			try {
				while (getSolde() == 0) {
					System.out.println(Thread.currentThread().getName()
							+ "en att avec un solde de " + getSolde());
					mutex.wait();
				}
			} catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				e.printStackTrace();
			}
			credit(-debit);
		}

	}
}