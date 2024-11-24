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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<RecipeCategory> getCategory() {
        return category;
    }

    public List<RecipeTag> getTags() {
        return tags;
    }

    public RecipeDuration getDuration() {
        return duration;
    }

    public void setCategory(List<RecipeCategory> category) {
        this.category = category;
    }

    public void setDuration(RecipeDuration duration) {
        this.duration = duration;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setMealprep(boolean mealprep) {
        this.mealprep = mealprep;
    }

    public void setTags(List<RecipeTag> tags) {
        this.tags = tags;
    }

    public boolean getMealPrep() {
        return mealprep;
    }

    public String getMealPrepStringGerman(){
        if(mealprep){
            return "Ja!";
        }
        return "Nein!";
    }


    public String getTagsAsString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(RecipeTag tag : tags){
            if(!first){
                sb.append(", ");
            }
            sb.append(tag.getName());
            first = false;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String getCategoryAsString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(RecipeCategory category : category){
            if(!first){
                sb.append(", ");

            }
            sb.append(category.getName());
            first = false;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String getIngredientsAsString(){
        StringBuilder sb = new StringBuilder();
        for(Ingredient ingredient : ingredients){
            sb.append(ingredient);
            sb.append("<br />");
        }

        System.out.println(sb);
        return sb.toString();
    }
}
