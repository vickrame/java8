package com.ujoodha.thread;

import java.io.Serializable;

public class Stat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3505126895489554857L;

	private int nbreTraitement, nbreEchec, nbreSucces;

	/**
	 * @return the nbreTraitement
	 */
	public int getNbreTraitement() {
		return nbreTraitement;
	}

	/**
	 * @param nbreTraitement
	 *            the nbreTraitement to set
	 */
	public void setNbreTraitement(int nbreTraitement) {
		this.nbreTraitement = nbreTraitement;
	}

	/**
	 * @return the nbreEchec
	 */
	public int getNbreEchec() {
		return nbreEchec;
	}

	/**
	 * @param nbreEchec
	 *            the nbreEchec to set
	 */
	public void setNbreEchec(int nbreEchec) {
		this.nbreEchec = nbreEchec;
	}

	/**
	 * @return the nbreSucces
	 */
	public int getNbreSucces() {
		return nbreSucces;
	}

	/**
	 * @param nbreSucces
	 *            the nbreSucces to set
	 */
	public void setNbreSucces(int nbreSucces) {
		this.nbreSucces = nbreSucces;
	}

}
