package com.example.octo_sdu.cookpartyv3.categoryRecipe.back;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;

import java.util.List;

public interface CategoryRecipeRepository {

    List<CategoryRecipeRealm> allCategoryRecipe();

    void addCategoryRecipe(String name, int draw);

    CategoryRecipeRealm findCategoryRecipe(String name);
}
