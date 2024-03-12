package pl.oszewczak.recipebook.service;

import org.springframework.stereotype.Service;
import pl.oszewczak.recipebook.model.ShoppingList;
import pl.oszewczak.recipebook.repository.ShoppingListItemRepository;
import pl.oszewczak.recipebook.repository.ShoppingListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    private final ShoppingListRepository listRepository;
    private final ShoppingListItemRepository itemRepository;

    public ShoppingListService(ShoppingListRepository listRepository, ShoppingListItemRepository itemRepository) {
        this.listRepository = listRepository;
        this.itemRepository = itemRepository;
    }

    public List<ShoppingList> getAll() {
        return listRepository.findAll();
    }

    public Optional<ShoppingList> getById(Long id) {
        return listRepository.findById(id);
    }

    public ShoppingList add(ShoppingList newList) {
        newList.getItems().forEach(item -> item.setShoppingList(newList));
        return listRepository.save(newList);
    }

    public ShoppingList replace(Long id, ShoppingList newList) {
        return listRepository.findById(id)
                .map(list -> {
                    list.setName(newList.getName());
                    list.getItems().forEach(item -> {
                        item.setShoppingList(null);
                        itemRepository.delete(item);
                    });
                    list.getItems().clear();
                    list.addAll(newList.getItems());
                    return listRepository.save(list);
                }).orElseGet(() -> {
                   newList.setId(id);
                   return listRepository.save(newList);
                });
    }

    public void delete(Long id) {
        listRepository.deleteById(id);
    }

}
