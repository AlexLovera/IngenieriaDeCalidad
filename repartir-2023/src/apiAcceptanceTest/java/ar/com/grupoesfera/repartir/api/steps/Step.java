package ar.com.grupoesfera.repartir.api.steps;

import io.cucumber.java.StepDefinitionAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@StepDefinitionAnnotation
@Documented
public @interface Step {

    /**
     * A cucumber or regular expression.
     *
     * @return a cucumber or regular expression
     */
    String value();
}
