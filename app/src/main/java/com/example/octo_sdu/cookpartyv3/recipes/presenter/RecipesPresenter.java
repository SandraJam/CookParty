package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.Recipe;

import java.util.List;

public interface RecipesPresenter {
    void onSuccess(List<Recipe> recipes);

    void onEmpty();
}
