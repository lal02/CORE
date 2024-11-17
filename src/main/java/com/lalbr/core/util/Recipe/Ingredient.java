package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

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

    @Column(name = "ingredient_amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;




    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }




    public double getAmount() {
        return amount;
    }
    public Unit getUnit() {
        return unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
