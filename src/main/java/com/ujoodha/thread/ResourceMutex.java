package com.ujoodha.thread;

public class ResourceMutex extends AbResources {

	private Object mutex = new Object();

	public int credit(final int credit) {
		synchronized (mutex) {
			// int oldValue = count;
			setSolde(this.getSolde() + credit);
			// System.out.println(oldValue + " incr " + count + "");
		}
		return getSolde();
	}

	public void debiter(final int credit) {
		credit(-credit);
	}

}
