package pl.oszewczak.recipebook.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.oszewczak.recipebook.model.ShoppingList;
import pl.oszewczak.recipebook.model.ShoppingListItem;
import pl.oszewczak.recipebook.model.Unit;
import pl.oszewczak.recipebook.repository.ShoppingListRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ShoppingListRepository listRepository;

    public DatabaseLoader(ShoppingListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        ShoppingList shoppingList = new ShoppingList("Test");
        shoppingList.add(new ShoppingListItem("Tomato", 2.0, new Unit("Kilogramy", "Kg")));
        this.listRepository.save(shoppingList);
    }
}
