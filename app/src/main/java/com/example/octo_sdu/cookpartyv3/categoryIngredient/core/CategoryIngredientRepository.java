package com.example.octo_sdu.cookpartyv3.categoryIngredient.core;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientRepository {
    List<CategoryIngredient> allCategoryIngredient();

    void addCategoryIngredient(String name, int draw);

    CategoryIngredient findOneCategory(String name);
}
