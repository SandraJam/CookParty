package com.example.octo_sdu.cookpartyv3.ingredients.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.core.coreIngredients.model.Ingredient;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsViewValidate;

import java.util.List;
import java.util.concurrent.Executor;

public class IngredientsViewValidateDecorate implements IngredientsViewValidate {
    private Executor mainExecutor = ExecutorInstance.mainExecutor;
    public IngredientsViewValidate viewValidate = null;

    @Override
    public void onEmpty() {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                viewValidate.onEmpty();
            }
        });
    }

    @Override
    public void onSuccess(final List<Ingredient> ingredients) {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                viewValidate.onSuccess(ingredients);
            }
        });
    }
}
