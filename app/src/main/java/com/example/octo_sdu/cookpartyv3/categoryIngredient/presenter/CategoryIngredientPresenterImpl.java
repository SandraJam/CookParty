package com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter;

import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientPresenter;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;

import java.util.List;

public class CategoryIngredientPresenterImpl implements CategoryIngredientPresenter {
    CategoryIngredientViewValidate categoryIngredientViewValidate;

    public CategoryIngredientPresenterImpl(CategoryIngredientViewValidate categoryIngredientViewValidate) {
        this.categoryIngredientViewValidate = categoryIngredientViewValidate;
    }

    @Override
    public void onSuccess(List<CategoryIngredient> categoryIngredientList) {
        categoryIngredientViewValidate.onSuccess(categoryIngredientList);
    }
}
