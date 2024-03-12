package pl.oszewczak.recipebook.controller;

import org.springframework.web.bind.annotation.*;
import pl.oszewczak.recipebook.exception.ShoppingListNotFoundException;
import pl.oszewczak.recipebook.model.ShoppingList;
import pl.oszewczak.recipebook.service.ShoppingListService;

import java.util.List;

@RestController
@RequestMapping("/shopping-list-management")
public class ShoppingListController {

    private final ShoppingListService service;

    public ShoppingListController(ShoppingListService service) {
        this.service = service;
    }

    @GetMapping("/shopping-lists")
    public List<ShoppingList> all() {
        return service.getAll();
    }

    @PostMapping("/shopping-lists")
    public ShoppingList newList(@RequestBody ShoppingList shoppingList) {
        return service.add(shoppingList);
    }

    @ResponseBody
    @GetMapping("shopping-lists/{id}")
    public ShoppingList one(@PathVariable Long id) throws ShoppingListNotFoundException {
        return service.getById(id).orElseThrow(() -> new ShoppingListNotFoundException(id));
    }

    @PutMapping("/shopping-lists/{id}")
    public ShoppingList replaceList(@PathVariable Long id, @RequestBody ShoppingList newList) {
        return service.replace(id, newList);
    }

    @DeleteMapping("/shopping-lists/{id}")
    public void deleteList(@PathVariable Long id) {
        service.delete(id);
    }

}
