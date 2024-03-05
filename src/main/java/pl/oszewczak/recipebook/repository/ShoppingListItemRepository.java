package pl.oszewczak.recipebook.repository;

import org.springframework.data.repository.CrudRepository;
import pl.oszewczak.recipebook.model.ShoppingListItem;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {

}
