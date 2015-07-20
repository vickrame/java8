/**
 * 
 */
package com.ujoodha.thread;

import java.util.concurrent.Semaphore;

/**
 * @author vickrame
 *
 */
public class SemaphoreTaskResources extends AbstractTask implements Runnable {

	private IResource maResources;
	private String nomThread;
	private Semaphore semaphore;
	private boolean flag;

	public SemaphoreTaskResources(final Resource maResources,
			final Semaphore semaphore, final boolean flag) {
		this.maResources = maResources;
		this.semaphore = semaphore;
		this.flag = flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 3; i++)
			doJob(flag);
	}

	protected void doJob(boolean flag) {
		try {
			semaphore.acquire();
			super.doJob(flag);

			semaphore.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// taskResources.decrement(100);
	}

	public IResource getMaResources() {
		if (maResources == null) {
			maResources = new Resource();
		}

		return maResources;
	}

	/**
	 * @return the nomThread
	 */
	public String getNomThread() {
		return nomThread;
	}

	/**
	 * @param nomThread
	 *            the nomThread to set
	 */
	public void setNomThread(String nomThread) {
		this.nomThread = nomThread;
	}
}
