package com.lalbr.core.model;

import com.lalbr.core.util.Recipe.RecipeCategory;
import com.lalbr.core.util.Recipe.RecipeDuration;
import com.lalbr.core.util.Recipe.RecipeTag;
import jakarta.persistence.*;

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

    @OneToMany
    @Column(name = "tags")
    private ArrayList<RecipeTag> tags;

    @OneToMany
    @Column(name = "category")
    private ArrayList<RecipeCategory> category;

    @ManyToOne
    @JoinColumn(name = "duration")
    private RecipeDuration duration;

    @Lob
    private byte[] image;

    //@OneToMany
    //@Column(name = "test")
    //private ArrayList<Ingredient> ingredients;
    //ingredient = String name , double amount , Einheit einheit


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
