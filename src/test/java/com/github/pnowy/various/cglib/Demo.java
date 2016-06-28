package com.github.pnowy.various.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.09.13 21:56
 */
public class Demo
{
	public static void main(String[] args)
	{
		// create the real object
		Algorithm algorithm = new Algorithm();
		// create the proxy
		Algorithm proxifiedAlgorithm = createProxy(algorithm);
		// execute the proxy - as we see it has the same API as the real object
		proxifiedAlgorithm.runAlgorithm();
	}

	public static <T> T createProxy(T obj)
	{
		// this is the main cglib api entry-point
		// this object will 'enhance' (in terms of CGLIB) with new capabilities
		// one can treat this class as a 'Builder' for the dynamic proxy
		Enhancer e = new Enhancer();
		//the class will extend from the real class
		e.setSuperclass(obj.getClass());
		// we have to declare the interceptor - the class whose 'intercept'
		// will be called when any method of the proxified object is called
		e.setCallback(new MyInterceptor(obj));
		// now th eenhancer is configured and we'll create the proxified object
		T proxifiedObj = (T)e.create();
		// the object is ready to be used - return it
		return proxifiedObj;
	}

}
