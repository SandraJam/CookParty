package com.example.octo_sdu.cookpartyv3.categoryIngredient.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientViewValidate;
import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

import java.util.List;
import java.util.concurrent.Executor;

public class CategoryIngredientViewValidateDecorate implements CategoryIngredientViewValidate {
    public Executor mainExecutor = ExecutorInstance.mainExecutor;
    public CategoryIngredientViewValidate categoryIngredientViewValidate;

    @Override
    public void onSuccess(final List<CategoryIngredient> categoryIngredientList) {
            mainExecutor.execute(new Runnable() {
                @Override
                public void run() {
                categoryIngredientViewValidate.onSuccess(categoryIngredientList);
            }
        });
    }
}
