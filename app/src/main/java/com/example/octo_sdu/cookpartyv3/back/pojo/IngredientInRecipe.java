package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmObject;

public class IngredientInRecipe extends RealmObject{
    private Recipe recipe;
    private Ingredient ingredient;
    private float value;
    private Measure measure;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

        public Recipe getRecipe() {
            return recipe;
        }

        public void setRecipe(Recipe recipe) {
            this.recipe = recipe;
        }
}
