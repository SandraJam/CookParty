package com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.view.CategoryRecipeViewValidate;

import java.util.List;

public class CategoryRecipePresenterImpl implements CategoryRecipePresenter {
    private CategoryRecipeViewValidate categoryRecipeViewValidate;

    public CategoryRecipePresenterImpl(CategoryRecipeViewValidate categoryRecipeViewValidate) {
        this.categoryRecipeViewValidate = categoryRecipeViewValidate;
    }

    @Override
    public void onSuccess(List<CategoryRecipe> categoryRecipe) {
        categoryRecipeViewValidate.onSuccess(categoryRecipe);
    }
}
