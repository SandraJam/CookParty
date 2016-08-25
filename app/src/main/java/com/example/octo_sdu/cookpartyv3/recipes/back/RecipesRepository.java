package com.example.octo_sdu.cookpartyv3.recipes.back;

import com.example.octo_sdu.cookpartyv3.back.pojo.Recipe;

import java.util.List;

public interface RecipesRepository {
    void deleteCategoryAndAllRecipes(String nameCategory);

    List<Recipe> allRecipesByCategory(String nameCategory);
}
