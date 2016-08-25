package com.example.octo_sdu.cookpartyv3.categoryRecipe.back;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;

import java.util.List;

public interface CategoryRecipeRepository {

    List<CategoryRecipe> allCategoryRecipe();

    void addCategoryRecipe(String name, int draw);

    CategoryRecipe findCategoryRecipe(String name);
}
