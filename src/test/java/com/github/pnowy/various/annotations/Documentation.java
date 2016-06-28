package com.github.pnowy.various.annotations;

import java.lang.annotation.*;

/**

 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Documentation
{
	public String author() default "Przemek Nowak <przemek.nowak.pl@gmail.com>";
	public String version() default "1.0";
	public String shortDescription() default "";
	public String[] reviews() default "";
}
