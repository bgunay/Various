package com.github.pnowy.various.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.09.13 21:39
 */
public class MyInterceptor implements MethodInterceptor {

	private Object realObj;

	// constructor - the supplied parameter is object
	// whose proxy we weould like to create
	public MyInterceptor(Object realObj)
	{
		this.realObj = realObj;
	}

	// this method will called earch time when the object
	// proxy calls any of its methods
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
	{
		System.out.println("Before");
		long time1 = System.currentTimeMillis();
		// invoke the mothod on the real object with the given params
		Object res = method.invoke(realObj, objects);
		System.out.println("After");
		System.out.println("Took: "+(System.currentTimeMillis()-time1)+" ms");
		return res;
	}



}
