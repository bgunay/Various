package com.github.pnowy.various.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 15.08.13 23:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InvokeMultiple {
	int numberOfTimesToInvoke() default 1;
}
