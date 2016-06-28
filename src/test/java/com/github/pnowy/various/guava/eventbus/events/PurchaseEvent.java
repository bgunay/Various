package com.github.pnowy.various.guava.eventbus.events;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Date: 16.12.13 18:16
 */
public abstract class PurchaseEvent {

	String item;

	protected PurchaseEvent(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
