package com.example.octo_sdu.cookpartyv3.recipes.view;

import java.util.List;

public interface RecipesViewValidate {

    void onEmpty();

    void onSuccess(List<RecipeModel> recipeModelList);
}
