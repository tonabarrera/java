package com.tona.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author tona created on 10/03/2018 for backendninja.
 * Esa clase no es tan necesaria debido a que spring encuentra
 * que plantillar cargar si es que estan en la carpeta error
 * con un nombre adecuado a su error
 */
@ControllerAdvice
public class ErrorsController {
    public static String ISE_ERROR = "error/500";

    @ExceptionHandler(Exception.class)
    public String showInternalServerError() {
        return ISE_ERROR;
    }
}
