package com.example.octo_sdu.core.coreRecipes;

public interface RecipesInteractor {
    void deleteCategoryAndAllRecipes(String nameCategory);

    void deleteRecipe(String name, String nameCategory);

    void allRecipesByCategory(String nameCategory);
}
