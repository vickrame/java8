package com.ujoodha.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceLockCondition extends AbResources {

	// private Object mutex = new Object();

	private volatile boolean status = false;
	private Lock lock = null;
	private Condition conditionIncr = null;
	private Condition conditionDesIncr = null;

	public ResourceLockCondition() {
		lock = new ReentrantLock();
		conditionIncr = lock.newCondition();
		conditionDesIncr = lock.newCondition();

	}

	public int credit(final int credit) {
		// synchronized (mutex) {
		lock.lock();
		try {

			// conditionIncr.
			// int oldValue = count;
			setSolde(getSolde() + credit);
			conditionDesIncr.signalAll();
			// System.out.println(oldValue + " incr " + count);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			//
		} finally {
			// conditionDesIncr.signalAll();

			if (getSolde() <= 0) {
				status = true;
			} else {
				status = false;
			}

			lock.unlock();

		}
		return getSolde();
		// }
	}

	public void debiter(final int credit) {
		// synchronized (mutex) {
		// int oldValue = count;
		// count = count - 100;
		// System.out.println(oldValue + " desincr " + count);

		lock.lock();
		try {

			while (status) {
				System.err.println(Thread.currentThread().getName()
						+ " en att avec un solde de " + getSolde());
				conditionDesIncr.await();
				// conditionDesIncr.await();
			}
			if (!status) {
				credit(-credit);
				// conditionDesIncr.signalAll();
			}

		} catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			lock.unlock();

		}

		// }
	}
}
