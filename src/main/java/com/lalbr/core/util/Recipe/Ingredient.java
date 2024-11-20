package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "recipe_ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food")
    private Food food;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;



    public double getAmount() {
        return amount;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
