package com.github.pnowy.various.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import com.github.pnowy.various.guava.eventbus.events.CreditPurchaseEvent;
import com.github.pnowy.various.guava.eventbus.events.PurchaseEvent;

/**
 * Date: 16.12.13 18:24
 */
public class PurchaseSubscriber {

	@Subscribe
	public void handlePurchaseEvent(PurchaseEvent event) {
		System.out.println("Default event coming:"+event);
	}

	@Subscribe
	public void handlePurchaseEvent(CreditPurchaseEvent event) {
		System.out.println("Credit event coming:"+event);
	}

}
