package pl.oszewczak.recipebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ShoppingListRestAdvice {

    @ResponseBody
    @ExceptionHandler(ShoppingListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ShoppingListNotFoundException ex) {
        return ex.getMessage();
    }

}