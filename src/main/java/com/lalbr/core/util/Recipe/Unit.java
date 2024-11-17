package com.lalbr.core.util.Recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Long id;

    @Column(name = "unit_name")
    private String name;


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
