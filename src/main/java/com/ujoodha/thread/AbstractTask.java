package com.ujoodha.thread;

public abstract class AbstractTask {

	protected abstract IResource getMaResources();

	protected void doJob(final boolean flagCredit) {
		IResource taskResources = getMaResources();

		int avant = taskResources.getSolde();

		if (flagCredit) {
			taskResources.credit(100);
		} else {
			taskResources.debiter(100);
		}

		int apres = taskResources.getSolde();

		System.out.println("dans " + Thread.currentThread().getName()
				+ "desincr " + " credit " + avant + " apres " + apres);
		// taskResources.decrement(100);
	}
}
