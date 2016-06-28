package com.github.pnowy.various.guava.eventbus.events;

/**
 * Date: 16.12.13 18:17
 */
public class CashPurchaseEvent extends PurchaseEvent {

	int amout;

	public CashPurchaseEvent(String item, int amount) {
		super(item);
		this.amout = amount;
	}
}
