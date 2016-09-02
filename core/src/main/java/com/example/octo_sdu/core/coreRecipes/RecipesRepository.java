package com.example.octo_sdu.core.coreRecipes;

import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.List;

public interface RecipesRepository {
    void deleteCategoryAndAllRecipes(String nameCategory);

    List<Recipe> allRecipesByCategory(String nameCategory);
}
