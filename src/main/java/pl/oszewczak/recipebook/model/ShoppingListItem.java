package pl.oszewczak.recipebook.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShoppingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    private Unit unit;
    private boolean checked;
    @ManyToOne
    @JoinColumn(name="shopping_list_id")
    private ShoppingList shoppingList;

}

