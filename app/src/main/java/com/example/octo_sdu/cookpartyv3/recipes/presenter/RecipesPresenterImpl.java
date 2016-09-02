package com.example.octo_sdu.cookpartyv3.recipes.presenter;

import com.example.octo_sdu.core.coreRecipes.RecipesPresenter;
import com.example.octo_sdu.core.coreRecipes.model.IngredientInRecipe;
import com.example.octo_sdu.core.coreRecipes.model.Recipe;
import com.example.octo_sdu.core.coreRecipes.model.StepInRecipe;
import com.example.octo_sdu.cookpartyv3.recipes.view.RecipeModelView;

import java.util.ArrayList;
import java.util.List;

public class RecipesPresenterImpl implements RecipesPresenter {
    private RecipesViewValidate recipesViewValidate;

    public RecipesPresenterImpl(RecipesViewValidate recipesViewValidate) {
        this.recipesViewValidate = recipesViewValidate;
    }

    @Override
    public void onSuccess(List<Recipe> recipes) {
        final List<RecipeModelView> recipeModelViews = new ArrayList<>();
        for (Recipe recipe : recipes) {
            final List<String> ingredients = new ArrayList<>();
            for (IngredientInRecipe ingredient : recipe.getIngredientInRecipeList()) {
                ingredients.add(ingredient.getValue()+" "+ingredient.getMeasure().getName()+" "+ingredient.getIngredient().getName());
            }
            final List<String> steps = new ArrayList<>();
            for (StepInRecipe step : recipe.getStepInRecipeList()) {
                steps.add(step.getContent());
            }
            recipeModelViews.add(new RecipeModelView(recipe.getTitle(), ingredients, steps));
        }
        recipesViewValidate.onSuccess(recipeModelViews);
    }

    @Override
    public void onEmpty() {
        recipesViewValidate.onEmpty();
    }
}
