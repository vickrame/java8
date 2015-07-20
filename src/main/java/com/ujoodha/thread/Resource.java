package com.ujoodha.thread;

public class Resource extends AbResources {

	public int credit(final int credit) {
		// int oldValue = count;
		setSolde(this.getSolde() + credit);
		// System.out.println(oldValue + " incr " + count + "");
		return getSolde();
	}

	public void debiter(final int credit) {
		credit(-credit);
	}

}
