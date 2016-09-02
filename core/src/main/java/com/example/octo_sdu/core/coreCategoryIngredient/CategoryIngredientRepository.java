package com.example.octo_sdu.core.coreCategoryIngredient;

import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientRepository {
    List<CategoryIngredient> allCategoryIngredient();

    void addCategoryIngredient(String name, int draw);

    CategoryIngredient findOneCategory(String name);
}
