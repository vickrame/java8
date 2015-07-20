/**
 * 
 */
package com.ujoodha.thread;

/**
 * @author vickrame
 *
 */
public class ReentrantMyTaskResources extends AbstractTask implements Runnable {

	private IResource maResources;
	private String nomThread;

	private boolean flag;

	public ReentrantMyTaskResources(final ResourceLockCondition maResources,
			final boolean flag) {
		this.maResources = maResources;
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

	public IResource getMaResources() {
		if (maResources == null) {
			maResources = new ResourceLockCondition();
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
