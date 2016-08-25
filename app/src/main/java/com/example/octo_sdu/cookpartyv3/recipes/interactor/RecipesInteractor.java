package com.example.octo_sdu.cookpartyv3.recipes.interactor;

public interface RecipesInteractor {
    void deleteCategoryAndAllRecipes(String nameCategory);

    void deleteRecipe(String name, String nameCategory);

    void allRecipesByCategory(String nameCategory);
}
