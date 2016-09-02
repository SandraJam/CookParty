package com.example.octo_sdu.core.coreRecipes.model;

import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

public class IngredientInRecipe {
    private Ingredient ingredient;
    private float value;
    private Measure measure;

    public IngredientInRecipe(Ingredient ingredient, float value, Measure measure) {
        this.ingredient = ingredient;
        this.value = value;
        this.measure = measure;
    }

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
}
