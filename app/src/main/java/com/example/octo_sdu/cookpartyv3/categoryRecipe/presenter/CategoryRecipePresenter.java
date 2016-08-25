package com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;

import java.util.List;

public interface CategoryRecipePresenter {
    void onSuccess(List<CategoryRecipeRealm> categoryRecipeRealm);
}
