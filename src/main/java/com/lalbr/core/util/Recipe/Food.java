package com.lalbr.core.util.Recipe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_food")
public class Food {


    @Id
    private Long id;

    @Column(name = "food_name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
