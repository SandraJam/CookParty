package com.example.octo_sdu.core.coreCategoryRecipe;

import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import java.util.List;

public interface CategoryRecipeRepository {

    List<CategoryRecipe> allCategoryRecipe();

    void addCategoryRecipe(String name, int draw);

    CategoryRecipe findCategoryRecipe(String name);
}
