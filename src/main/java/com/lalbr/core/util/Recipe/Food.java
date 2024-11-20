package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_food")
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
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
