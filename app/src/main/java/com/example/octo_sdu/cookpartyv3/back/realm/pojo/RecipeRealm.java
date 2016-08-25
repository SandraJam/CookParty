package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RecipeRealm extends RealmObject {
    private String title;
    private RealmList<IngredientInRecipeRealm> ingredients;
    private RealmList<StepInRecipeRealm> steps;
    private CategoryRecipeRealm category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<IngredientInRecipeRealm> getIngredients() {
        return ingredients;
    }

    public void setIngredients(RealmList<IngredientInRecipeRealm> ingredients) {
        this.ingredients = ingredients;
    }

    public RealmList<StepInRecipeRealm> getSteps() {
        return steps;
    }

    public void setSteps(RealmList<StepInRecipeRealm> steps) {
        this.steps = steps;
    }

    public CategoryRecipeRealm getCategory() {
        return category;
    }

    public void setCategory(CategoryRecipeRealm category) {
        this.category = category;
    }
}
