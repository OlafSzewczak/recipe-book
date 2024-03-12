package pl.oszewczak.recipebook.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@Entity
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="shoppingList", cascade=CascadeType.ALL)
    private List<ShoppingListItem> items;

    public ShoppingList(String name, List<ShoppingListItem> items) {
        this.name = name;
        this.items = items;
    }

    public ShoppingList(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public ShoppingList(ShoppingList other) {
        this.name = other.getName();
        this.items = other.getItems().stream()
                .map(ShoppingListItem::new)
                .collect(Collectors.toList());
    }

    public void add(ShoppingListItem item) {
        if(item != null) {
            items.add(item);
            item.setShoppingList(this);
        }
    }

    public void addAll(List<ShoppingListItem> newItems) {
        if(items == null) {
            items = new ArrayList<>();
        }
        items.addAll(newItems.stream().peek(item -> item.setShoppingList(this)).toList());
    }

}
