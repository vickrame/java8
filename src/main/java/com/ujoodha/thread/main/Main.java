/**
 * 
 */
package com.ujoodha.thread.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import com.ujoodha.thread.MyTaskAddResources;
import com.ujoodha.thread.MyTaskRemoveResources;
import com.ujoodha.thread.MyTaskResources;
import com.ujoodha.thread.ReentrantMyTaskResources;
import com.ujoodha.thread.Resource;
import com.ujoodha.thread.ResourceAtomic;
import com.ujoodha.thread.ResourceLockCondition;
import com.ujoodha.thread.ResourceMutex;
import com.ujoodha.thread.SemaphoreTaskResources;
import com.ujoodha.thread.SimpleResource;
import com.ujoodha.thread.habilitation.Droit;
import com.ujoodha.thread.habilitation.User;
import com.ujoodha.thread.habilitation.UserCache;
import com.ujoodha.thread.habilitation.UserKey;

/**
 * @author vickrame
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub

		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
	}

	private static void test9() {
		UserKey clef = new UserKey();
		clef.setEmail("ujoodha.vickrame@gmail.com");

		Droit d1 = new Droit();
		d1.setActif(false);
		d1.setDateDebut(null);
		d1.setDateFin(null);
		d1.setDomaine("OSR");
		d1.setLibelle("droit consulter");

		LocalDate date = LocalDate.now();

		Droit d2 = new Droit();
		d2.setActif(true);
		d2.setDateDebut(date);
		d2.setDateFin(null);
		d2.setDomaine("FUI");
		d2.setLibelle("droit consulter");

		List<Droit> lstDroit = Arrays.asList(d1, d2);

		User u = new User();
		u.setKey(clef);
		u.setListDroit(lstDroit);
		u.setNom("UJOODHA");
		u.setPrenom("VICKRAME");

		UserCache.INSTANCE.put(u);

	}

	/**
	 * 
	 */
	private static void test8() {

		ResourceAtomic maResources = new ResourceAtomic();

		ThreadGroup grpThread = new ThreadGroup("groupe");

		MyTaskAddResources mt1 = new MyTaskAddResources(maResources, true);
		mt1.setNomThread("thread credit ");
		MyTaskRemoveResources mt2 = new MyTaskRemoveResources(maResources,
				false);
		mt2.setNomThread("thread debit ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1 credit ");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 debit ");
		Thread t3 = new Thread(grpThread, mt1, "thread 3 credit ");
		Thread t4 = new Thread(grpThread, mt2, "thread 4 debit ");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

			// maResources.credit(100);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

	/**
	 * 
	 */
	private static void test7() {

		ResourceLockCondition maResources = new ResourceLockCondition();

		ThreadGroup grpThread = new ThreadGroup("groupe");

		MyTaskAddResources mt1 = new MyTaskAddResources(maResources, true);
		mt1.setNomThread("thread credit ");
		MyTaskRemoveResources mt2 = new MyTaskRemoveResources(maResources,
				false);
		mt2.setNomThread("thread debit ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1 credit ");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 debit ");
		Thread t3 = new Thread(grpThread, mt1, "thread 3 credit ");
		Thread t4 = new Thread(grpThread, mt2, "thread 4 debit ");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

			// maResources.credit(100);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

	/**
	 * 
	 */
	private static void test6() {

		SimpleResource maResources = new SimpleResource();

		ThreadGroup grpThread = new ThreadGroup("groupe");

		MyTaskAddResources mt1 = new MyTaskAddResources(maResources, true);
		mt1.setNomThread("thread credit ");
		MyTaskRemoveResources mt2 = new MyTaskRemoveResources(maResources,
				false);
		mt1.setNomThread("thread debit ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1 credit");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 debit");
		Thread t3 = new Thread(grpThread, mt1, "thread 3 credit");
		Thread t4 = new Thread(grpThread, mt2, "thread 4 debit");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

			// maResources.credit(100);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

	/**
	 * 
	 */
	private static void test5() {

		Resource maResources = new Resource();
		Semaphore semaphore = new Semaphore(2);

		ThreadGroup grpThread = new ThreadGroup("groupe");

		SemaphoreTaskResources mt1 = new SemaphoreTaskResources(maResources,
				semaphore, true);
		mt1.setNomThread("thread 1 ");

		SemaphoreTaskResources mt2 = new SemaphoreTaskResources(maResources,
				semaphore, false);
		mt2.setNomThread("thread 2 ");

		SemaphoreTaskResources mt3 = new SemaphoreTaskResources(maResources,
				semaphore, true);
		mt3.setNomThread("thread 3 ");

		SemaphoreTaskResources mt4 = new SemaphoreTaskResources(maResources,
				semaphore, false);
		mt4.setNomThread("thread 4 ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 ");
		Thread t3 = new Thread(grpThread, mt3, "thread 3 ");
		Thread t4 = new Thread(grpThread, mt4, "thread 4 ");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

	/**
	 * 
	 */
	private static void test4() {

		ResourceLockCondition maResources = new ResourceLockCondition();

		ThreadGroup grpThread = new ThreadGroup("groupe");

		ReentrantMyTaskResources mt1 = new ReentrantMyTaskResources(
				maResources, true);
		mt1.setNomThread("thread 1 ");

		ReentrantMyTaskResources mt2 = new ReentrantMyTaskResources(
				maResources, false);
		mt2.setNomThread("thread 2 ");
		//
		// MyTaskResources mt3 = new MyTaskResources(maResources);
		// mt3.setNomThread("thread 3 ");
		//
		// MyTaskResources mt4 = new MyTaskResources(maResources);
		// mt4.setNomThread("thread 4 ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 ");
		// Thread t3 = new Thread(grpThread, mt1, "thread 3 ");
		// Thread t4 = new Thread(grpThread, mt1, "thread 4 ");

		t1.start();
		t2.start();
		// t3.start();
		// t4.start();
		try {
			t1.join();
			t2.join();
			// t3.join();
			// t4.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

	/**
	 * 
	 */
	private static void test3() {

		ResourceMutex maResources = new ResourceMutex();

		ThreadGroup grpThread = new ThreadGroup("groupe");

		MyTaskResources mt1 = new MyTaskResources(maResources, true);
		mt1.setNomThread("thread 1 ");

		MyTaskResources mt2 = new MyTaskResources(maResources, false);
		mt2.setNomThread("thread 2 ");
		//
		// MyTaskResources mt3 = new MyTaskResources(maResources);
		// mt3.setNomThread("thread 3 ");
		//
		// MyTaskResources mt4 = new MyTaskResources(maResources);
		// mt4.setNomThread("thread 4 ");

		Thread t1 = new Thread(grpThread, mt1, "thread 1");
		Thread t2 = new Thread(grpThread, mt2, "thread 2 ");
		// Thread t3 = new Thread(grpThread, mt1, "thread 3 ");
		// Thread t4 = new Thread(grpThread, mt1, "thread 4 ");

		t1.start();
		t2.start();
		// t3.start();
		// t4.start();
		try {
			t1.join();
			t2.join();
			// t3.join();
			// t4.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("maResources.getCount(): " + maResources.getSolde());
	}

}
