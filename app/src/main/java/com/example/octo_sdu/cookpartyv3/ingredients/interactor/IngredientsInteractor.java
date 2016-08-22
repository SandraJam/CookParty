package com.example.octo_sdu.cookpartyv3.ingredients.interactor;

public interface IngredientsInteractor {
    void allIngredientsByCategory(String category);

    void addIngredient(String name, String nameCategory);

    void deleteCategoryAndAllIngredients(String nameCategory);
}
