package com.example.octo_sdu.cookpartyv3.recipes.back;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.RecipeRealm;

import java.util.List;

public interface RecipesRepository {
    void deleteCategoryAndAllRecipes(String nameCategory);

    List<RecipeRealm> allRecipesByCategory(String nameCategory);
}
