package com.github.pnowy.various.guava.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pnowy.various.guava.eventbus.events.CashPurchaseEvent;

import com.google.common.eventbus.EventBus;
import com.github.pnowy.various.guava.eventbus.events.CreditPurchaseEvent;

/**
 * Date: 16.12.13 18:26
 */
public class EventBusDemo {
	private static final Logger LOG = LoggerFactory.getLogger(EventBusDemo.class);

	public static void main(String[] args) {
		LOG.debug("startuję!");
		EventBus eventBus = new EventBus();
		eventBus.register(new PurchaseSubscriber());

		eventBus.post(new CashPurchaseEvent("ItemOne", 35));
		eventBus.post(new CreditPurchaseEvent("ItemTwo", 42, "0098329832"));
	}

}
