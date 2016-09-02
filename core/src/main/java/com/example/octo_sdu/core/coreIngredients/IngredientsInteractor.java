package com.example.octo_sdu.core.coreIngredients;

public interface IngredientsInteractor {
    void allIngredientsByCategory(String category);

    void addIngredient(String name, String nameCategory);

    void deleteCategoryAndAllIngredients(String nameCategory);

    void deleteIngredient(String name, String nameCategory);
}
