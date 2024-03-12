package pl.oszewczak.recipebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
public class ShoppingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    private Unit unit;

    private boolean checked;

    @Setter
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="shopping_list_id")
    private ShoppingList shoppingList;

    public ShoppingListItem(String name, Double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.checked = false;
    }

    public ShoppingListItem(ShoppingListItem other) {
        this.name = other.getName();
        this.amount = other.getAmount();
        this.unit = other.getUnit();
        this.checked = other.isChecked();
    }
}

