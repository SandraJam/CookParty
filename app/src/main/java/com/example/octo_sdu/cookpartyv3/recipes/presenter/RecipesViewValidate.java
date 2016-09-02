package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModelView;

import java.util.List;

public interface RecipesViewValidate {

    void onEmpty();

    void onSuccess(List<RecipeModelView> recipeModelViewList);
}
