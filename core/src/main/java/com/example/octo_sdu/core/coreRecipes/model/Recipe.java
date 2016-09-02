package com.example.octo_sdu.core.coreRecipes.model;

import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import java.util.List;

public class Recipe {
    private String title;
    private List<IngredientInRecipe> ingredientInRecipeList;
    private List<StepInRecipe> stepInRecipeList;
    private CategoryRecipe categoryRecipe;

    public Recipe(String title, List<IngredientInRecipe> ingredientInRecipeList, List<StepInRecipe> stepInRecipeList, CategoryRecipe categoryRecipe) {
        this.title = title;
        this.ingredientInRecipeList = ingredientInRecipeList;
        this.stepInRecipeList = stepInRecipeList;
        this.categoryRecipe = categoryRecipe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientInRecipe> getIngredientInRecipeList() {
        return ingredientInRecipeList;
    }

    public void setIngredientInRecipeList(List<IngredientInRecipe> ingredientInRecipeList) {
        this.ingredientInRecipeList = ingredientInRecipeList;
    }

    public List<StepInRecipe> getStepInRecipeList() {
        return stepInRecipeList;
    }

    public void setStepInRecipeList(List<StepInRecipe> stepInRecipeList) {
        this.stepInRecipeList = stepInRecipeList;
    }

    public CategoryRecipe getCategoryRecipe() {
        return categoryRecipe;
    }

    public void setCategoryRecipe(CategoryRecipe categoryRecipe) {
        this.categoryRecipe = categoryRecipe;
    }
}
