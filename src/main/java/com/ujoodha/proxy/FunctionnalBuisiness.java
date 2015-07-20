package com.ujoodha.proxy;

import java.util.HashMap;
import java.util.Map;

public class FunctionnalBuisiness implements IFunctionnalBusiness {

	private Map<String, String> map;

	public FunctionnalBuisiness() {
		map = new HashMap<String, String>();
	}

	@Override
	public void doTheJob() {

		for (int i = 0; i < 60; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("i" + i, "" + i);
		}

	}

	@Override
	public void cleanTheContext() {
		// TODO Auto-generated method stub

	}

}
