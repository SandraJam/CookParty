package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmObject;

public class IngredientInRecipeRealm extends RealmObject{
    private RecipeRealm recipeRealm;
    private IngredientRealm ingredientRealm;
    private float value;
    private MeasureRealm measureRealm;

    public IngredientRealm getIngredientRealm() {
        return ingredientRealm;
    }

    public void setIngredientRealm(IngredientRealm ingredientRealm) {
        this.ingredientRealm = ingredientRealm;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public MeasureRealm getMeasureRealm() {
        return measureRealm;
    }

    public void setMeasureRealm(MeasureRealm measureRealm) {
        this.measureRealm = measureRealm;
    }

        public RecipeRealm getRecipeRealm() {
            return recipeRealm;
        }

        public void setRecipeRealm(RecipeRealm recipeRealm) {
            this.recipeRealm = recipeRealm;
        }
}
