package com.example.octo_sdu.core.coreIngredients;

import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import java.util.List;

public interface IngredientsPresenter {
    void onEmpty();

    void onSuccess(List<Ingredient> ingredients);
}
