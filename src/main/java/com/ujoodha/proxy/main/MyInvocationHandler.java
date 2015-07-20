package com.ujoodha.proxy.main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.ujoodha.proxy.IFunctionnalBusiness;

public class MyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println(proxy.getClass());
		System.out.println(method.getName());

		switch (method.getName()) {
		case "doTheJob":

			IFunctionnalBusiness p = ((IFunctionnalBusiness) proxy);

			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < 60; i++) {
				// System.out.println(i);
				map.put("i" + i, "" + i);
			}

			break;

		default:
			break;
		}

		return "";
	}
}
