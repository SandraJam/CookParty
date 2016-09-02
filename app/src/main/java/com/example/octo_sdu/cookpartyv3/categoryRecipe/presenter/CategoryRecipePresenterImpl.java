package com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter;

import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipePresenter;
import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

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
