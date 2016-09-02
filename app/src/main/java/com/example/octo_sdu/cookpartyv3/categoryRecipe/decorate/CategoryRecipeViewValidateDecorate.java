package com.example.octo_sdu.cookpartyv3.categoryRecipe.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipeViewValidate;
import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import java.util.List;
import java.util.concurrent.Executor;

public class CategoryRecipeViewValidateDecorate implements CategoryRecipeViewValidate {
    private Executor mainExecutor = ExecutorInstance.mainExecutor;
    public CategoryRecipeViewValidate categoryRecipeViewValidate = null;

    @Override
    public void onSuccess(final List<CategoryRecipe> categoryRecipe) {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryRecipeViewValidate.onSuccess(categoryRecipe);
            }
        });
    }
}
