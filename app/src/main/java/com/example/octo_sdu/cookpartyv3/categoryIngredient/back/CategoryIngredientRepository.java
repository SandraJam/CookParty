package com.example.octo_sdu.cookpartyv3.categoryIngredient.back;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientRepository {
    List<CategoryIngredient> allCategoryIngredient();

    void saveCategoryIngredient(String name, int draw);
}
