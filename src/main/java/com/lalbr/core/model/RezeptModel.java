package com.lalbr.core.model;

import com.lalbr.core.util.Recipe.RecipeCategory;
import com.lalbr.core.util.Recipe.RecipeDuration;
import com.lalbr.core.util.Recipe.RecipeTags;
import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;

@Entity()
@Table(name = "recipe")
public class RezeptModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    //@Enumerated(EnumType.STRING)
    private ArrayList<RecipeTags> tags;

    private ArrayList<RecipeCategory> category;

    private RecipeDuration duration;

    @Lob
    private byte[] image;
    //private String image;


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }
}
