package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.IngredientInRecipe;
import com.example.octo_sdu.cookpartyv3.back.pojo.Recipe;
import com.example.octo_sdu.cookpartyv3.back.pojo.StepInRecipe;
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
    public void onSuccess(List<Recipe> recipes) {
        final List<RecipeModel> recipeModels = new ArrayList<>();
        for (Recipe recipe : recipes) {
            final List<String> ingredients = new ArrayList<>();
            for (IngredientInRecipe ingredient : recipe.getIngredients()) {
                ingredients.add(ingredient.getValue()+" "+ingredient.getMeasure().getName()+" "+ingredient.getIngredient().getName());
            }
            final List<String> steps = new ArrayList<>();
            for (StepInRecipe step : recipe.getSteps()) {
                steps.add(step.getContent());
            }
            recipeModels.add(new RecipeModel(recipe.getTitle(), ingredients, steps));
        }
        recipesViewValidate.onSuccess(recipeModels);
    }

    @Override
    public void onEmpty() {
        recipesViewValidate.onEmpty();
    }
}
