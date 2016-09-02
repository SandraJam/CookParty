package com.example.octo_sdu.core.coreRecipes;

import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.List;

public interface RecipesPresenter {
    void onSuccess(List<Recipe> recipes);

    void onEmpty();
}
