package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_category")
public class RecipeCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
