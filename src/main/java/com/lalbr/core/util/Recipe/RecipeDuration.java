package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_duration")
public class RecipeDuration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duration_id")
    private Long id;

    @Column(name = "duration_name")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
