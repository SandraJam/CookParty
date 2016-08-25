package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Recipe extends RealmObject {
    private String title;
    private RealmList<IngredientInRecipe> ingredients;
    private RealmList<StepInRecipe> steps;
    private CategoryRecipe category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<IngredientInRecipe> getIngredients() {
        return ingredients;
    }

    public void setIngredients(RealmList<IngredientInRecipe> ingredients) {
        this.ingredients = ingredients;
    }

    public RealmList<StepInRecipe> getSteps() {
        return steps;
    }

    public void setSteps(RealmList<StepInRecipe> steps) {
        this.steps = steps;
    }

    public CategoryRecipe getCategory() {
        return category;
    }

    public void setCategory(CategoryRecipe category) {
        this.category = category;
    }
}
