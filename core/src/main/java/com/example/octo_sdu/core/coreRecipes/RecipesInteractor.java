package com.example.octo_sdu.core.coreRecipes;

public interface RecipesInteractor {
    void deleteCategoryAndAllRecipes(String nameCategory);

    void allRecipesByCategory(String nameCategory);

    void addRecipe(String title, String nameCategory);

    void addIngredientsToRecipe(String nameIngredient, String nameRecipe, String value, String measure);

    void addStepToRecipe(String content, String nameRecipe);

    void deleteRecipe(String name, String nameCategory);

}
