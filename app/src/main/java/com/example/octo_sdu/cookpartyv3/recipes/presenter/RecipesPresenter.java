package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.RecipeRealm;

import java.util.List;

public interface RecipesPresenter {
    void onSuccess(List<RecipeRealm> recipeRealms);

    void onEmpty();
}
