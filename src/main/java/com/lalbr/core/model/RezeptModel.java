package com.lalbr.core.model;

import com.lalbr.core.util.Recipe.Ingredient;
import com.lalbr.core.util.Recipe.RecipeCategory;
import com.lalbr.core.util.Recipe.RecipeDuration;
import com.lalbr.core.util.Recipe.RecipeTag;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "recipe")
public class RezeptModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private long id;
    @Column(name = "recipe_name")
    private String name;
    @Column(name = "recipe_description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "recipe_tag_join",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<RecipeTag> tags = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "recipe_category_join",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<RecipeCategory> category = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "recipe_duration")
    private RecipeDuration duration;

    @Column(name = "recipe_mealprep")
    private boolean mealprep;

    //@Lob
    //private byte[] image;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient_join",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();


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
