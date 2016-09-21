package com.example.octo_sdu.core.coreRecipes;

import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.List;

public interface RecipesRepository {
    void deleteCategoryAndAllRecipes(String nameCategory);

    List<Recipe> allRecipesByCategory(String nameCategory);

    void add(String title, String nameCategory);

    void addIngredientsToRecipe(String nameIngredient, String nameRecipe, float value, String measure);

    void addStepToRecipe(String content, String nameRecipe);

    void deleteRecipe(String title, String nameCategory);

    Recipe findRecipe(String title, String nameCategory);
}