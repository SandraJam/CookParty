package com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.view.CategoryRecipeViewValidate;

import java.util.List;

public class CategoryRecipePresenterImpl implements CategoryRecipePresenter {
    private CategoryRecipeViewValidate categoryRecipeViewValidate;

    public CategoryRecipePresenterImpl(CategoryRecipeViewValidate categoryRecipeViewValidate) {
        this.categoryRecipeViewValidate = categoryRecipeViewValidate;
    }

    @Override
    public void onSuccess(List<CategoryRecipeRealm> categoryRecipeRealm) {
        categoryRecipeViewValidate.onSuccess(categoryRecipeRealm);
    }
}
