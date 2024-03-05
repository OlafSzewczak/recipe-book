package pl.oszewczak.recipebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class ShoppingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Unit unit;
    private boolean checked;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="shopping_list_id")
    private ShoppingList shoppingList;

    public ShoppingListItem(String name, Double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
}

