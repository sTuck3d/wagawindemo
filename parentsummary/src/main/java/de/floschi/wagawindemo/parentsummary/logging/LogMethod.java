package de.floschi.wagawindemo.parentsummary.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.METHOD)
@Retention(value = RUNTIME)
public @interface LogMethod {

}
