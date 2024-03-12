package pl.oszewczak.recipebook.exception;

public class ShoppingListNotFoundException extends Exception {

    public ShoppingListNotFoundException(Long id) {
        super("Shopping list with id " + id + " was not found");
    }

}
