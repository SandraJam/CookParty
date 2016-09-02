package com.example.octo_sdu.cookpartyv3.ingredients.presenter;

import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import java.util.List;

public interface IngredientsViewValidate {
    void onEmpty();

    void onSuccess(List<Ingredient> ingredients);
}
