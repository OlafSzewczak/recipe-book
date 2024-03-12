package pl.oszewczak.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.oszewczak.recipebook.model.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {



}
