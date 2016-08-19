package com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientViewValidate;

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

    @Override
    public void onEmptyCategory() {
        categoryIngredientViewValidate.onEmptyCategory();
    }
}
