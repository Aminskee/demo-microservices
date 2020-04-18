package com.daimler.alr.commons;

import com.daimler.alr.commons.errorhandling.ExceptionHandlers;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enables the Customized ExceptionHandler.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ExceptionHandlers.class})
public @interface EnableWebCommons {
}
