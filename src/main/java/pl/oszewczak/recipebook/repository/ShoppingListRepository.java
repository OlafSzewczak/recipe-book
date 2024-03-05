package pl.oszewczak.recipebook.repository;

import org.springframework.data.repository.CrudRepository;
import pl.oszewczak.recipebook.model.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

}
