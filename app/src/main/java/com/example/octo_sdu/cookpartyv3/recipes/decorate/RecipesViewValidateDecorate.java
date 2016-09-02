package com.example.octo_sdu.cookpartyv3.recipes.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesViewValidate;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModelView;

import java.util.List;
import java.util.concurrent.Executor;

public class RecipesViewValidateDecorate implements RecipesViewValidate {
    private Executor mainExecutor = ExecutorInstance.mainExecutor;
    public RecipesViewValidate recipesViewValidate = null;

    @Override
    public void onEmpty() {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                recipesViewValidate.onEmpty();
            }
        });
    }

    @Override
    public void onSuccess(final List<RecipeModelView> recipeModelViewList) {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                recipesViewValidate.onSuccess(recipeModelViewList);
            }
        });
    }
}
