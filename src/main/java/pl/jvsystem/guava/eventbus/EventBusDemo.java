package pl.jvsystem.guava.eventbus;

import pl.jvsystem.guava.eventbus.events.CashPurchaseEvent;

import com.google.common.eventbus.EventBus;
import pl.jvsystem.guava.eventbus.events.CreditPurchaseEvent;

/**
 * Date: 16.12.13 18:26
 */
public class EventBusDemo {

	public static void main(String[] args) {

		EventBus eventBus = new EventBus();
		eventBus.register(new PurchaseSubscriber());

		eventBus.post(new CashPurchaseEvent("ItemOne", 35));
		eventBus.post(new CreditPurchaseEvent("ItemTwo", 42, "0098329832"));

	}

}
