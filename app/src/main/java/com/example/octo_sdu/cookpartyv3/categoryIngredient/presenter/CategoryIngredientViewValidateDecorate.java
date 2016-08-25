package com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter;

import com.example.octo_sdu.cookpartyv3.back.MainDependencies;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;

import java.util.List;

public class CategoryIngredientViewValidateDecorate implements CategoryIngredientViewValidate {
    private CategoryIngredientViewValidate categoryIngredientViewValidate;

    public CategoryIngredientViewValidateDecorate(CategoryIngredientViewValidate categoryIngredientViewValidate) {
        this.categoryIngredientViewValidate = categoryIngredientViewValidate;
    }

    @Override
    public void onSuccess(final List<CategoryIngredient> categoryIngredientList) {
        MainDependencies.mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryIngredientViewValidate.onSuccess(categoryIngredientList);
            }
        });
    }
}
