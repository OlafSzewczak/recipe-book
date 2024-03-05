package pl.oszewczak.recipebook.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="shoppingList", cascade=CascadeType.PERSIST)
    private List<ShoppingListItem> items;

    public ShoppingList(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(ShoppingListItem item) {
        if(item != null) {
            items.add(item);
        }
    }



}
