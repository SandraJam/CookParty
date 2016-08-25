package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientInRecipeRealm;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.RecipeRealm;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.StepInRecipeRealm;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModel;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipesViewValidate;

import java.util.ArrayList;
import java.util.List;

public class RecipesPresenterImpl implements RecipesPresenter {
    private RecipesViewValidate recipesViewValidate;

    public RecipesPresenterImpl(RecipesViewValidate recipesViewValidate) {
        this.recipesViewValidate = recipesViewValidate;
    }

    @Override
    public void onSuccess(List<RecipeRealm> recipeRealms) {
        final List<RecipeModel> recipeModels = new ArrayList<>();
        for (RecipeRealm recipeRealm : recipeRealms) {
            final List<String> ingredients = new ArrayList<>();
            for (IngredientInRecipeRealm ingredient : recipeRealm.getIngredients()) {
                ingredients.add(ingredient.getValue()+" "+ingredient.getMeasureRealm().getName()+" "+ingredient.getIngredientRealm().getName());
            }
            final List<String> steps = new ArrayList<>();
            for (StepInRecipeRealm step : recipeRealm.getSteps()) {
                steps.add(step.getContent());
            }
            recipeModels.add(new RecipeModel(recipeRealm.getTitle(), ingredients, steps));
        }
        recipesViewValidate.onSuccess(recipeModels);
    }

    @Override
    public void onEmpty() {
        recipesViewValidate.onEmpty();
    }
}
