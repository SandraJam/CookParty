package com.example.octo_sdu.cookpartyv3.ingredients.back;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;

import java.util.List;

public interface IngredientsRepository {
    List<Ingredient> allIngredientsByCategory(String category);

    void add(String name, String nameCategory);

    void deleteCategory(String nameCategory);

    Ingredient findIngredient(String name, String nameCategory);

    void deleteIngredient(String name, String nameCategory);
}
