package pl.jvsystem.guava.eventbus.events;

/**
 * Date: 16.12.13 18:18
 */
public class CreditPurchaseEvent extends PurchaseEvent {

	int amount;
	String cardNumber;

	public CreditPurchaseEvent(String item, int amount, String cardNumber) {
		super(item);
		this.amount = amount;
		this.cardNumber = cardNumber;
	}
}
