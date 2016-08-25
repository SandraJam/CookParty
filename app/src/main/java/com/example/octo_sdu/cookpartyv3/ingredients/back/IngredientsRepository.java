package com.example.octo_sdu.cookpartyv3.ingredients.back;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientRealm;

import java.util.List;

public interface IngredientsRepository {
    List<IngredientRealm> allIngredientsByCategory(String category);

    void add(String name, String nameCategory);

    void deleteCategory(String nameCategory);

    IngredientRealm findIngredient(String name, String nameCategory);

    void deleteIngredient(String name, String nameCategory);
}
