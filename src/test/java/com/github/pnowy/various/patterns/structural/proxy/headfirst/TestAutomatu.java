package com.github.pnowy.various.patterns.structural.proxy.headfirst;

public class TestAutomatu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutomatSprzedajacy a = new AutomatSprzedajacy("Kielce",3);
		AutomatSprzedajacyMonitor m = new AutomatSprzedajacyMonitor(a);
		m.raport();
//		System.out.println(a);
//		a.wlozMonete();
//		a.przekrecGalke();
//		a.wlozMonete();
//		a.wlozMonete();
//		a.przekrecGalke();
//		System.out.println(a);
	}

}
