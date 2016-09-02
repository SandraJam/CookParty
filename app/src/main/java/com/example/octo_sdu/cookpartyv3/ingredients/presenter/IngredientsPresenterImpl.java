package com.example.octo_sdu.cookpartyv3.ingredients.presenter;

import com.example.octo_sdu.core.coreIngredients.IngredientsPresenter;
import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import java.util.List;

public class IngredientsPresenterImpl implements IngredientsPresenter {
    private IngredientsViewValidate viewValidate;

    public IngredientsPresenterImpl(IngredientsViewValidate viewValidate) {
        this.viewValidate = viewValidate;
    }

    @Override
    public void onEmpty() {
        viewValidate.onEmpty();
    }

    @Override
    public void onSuccess(List<Ingredient> ingredients) {
        viewValidate.onSuccess(ingredients);
    }
}
