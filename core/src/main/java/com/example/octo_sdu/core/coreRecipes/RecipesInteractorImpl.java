package com.example.octo_sdu.core.coreRecipes;

import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.List;

public class RecipesInteractorImpl implements RecipesInteractor {
    private RecipesRepository recipesRepository;
    private RecipesPresenter recipesPresenter;

    public RecipesInteractorImpl(RecipesRepository recipesRepository, RecipesPresenter recipesPresenter) {
        this.recipesPresenter = recipesPresenter;
        this.recipesRepository = recipesRepository;
    }

    @Override
    public void deleteCategoryAndAllRecipes(String nameCategory) {
        if (nameCategory != null)
            recipesRepository.deleteCategoryAndAllRecipes(nameCategory);
    }

    @Override
    public void deleteRecipe(String name, String nameCategory) {
        if (name != null && nameCategory != null) {
            recipesRepository.deleteRecipe(name, nameCategory);
        }
    }

    @Override
    public void allRecipesByCategory(String nameCategory) {
        if (nameCategory == null){
            recipesPresenter.onEmpty();
        } else {
            final List<Recipe> recipes = recipesRepository.allRecipesByCategory(nameCategory);
            if (recipes.isEmpty()){
                recipesPresenter.onEmpty();
            } else {
                recipesPresenter.onSuccess(recipes);
            }
        }
    }

    @Override
    public void addRecipe(String title, String nameCategory) {
        if (title != null && title.length() <= 50 && title.length() > 2 && recipesRepository.findRecipe(title, nameCategory) == null) {
            recipesRepository.add(title, nameCategory);
            recipesPresenter.addIsOkay();
        }
    }

    @Override
    public void addIngredientsToRecipe(String nameIngredient, String nameRecipe, String value, String measure) {
        if (nameIngredient != null && nameRecipe != null && measure != null) {
            float val = Float.parseFloat(value);
            recipesRepository.addIngredientsToRecipe(nameIngredient, nameRecipe, val, measure);
        }
    }

    @Override
    public void addStepToRecipe(String content, String nameRecipe) {
        if (content != null && nameRecipe != null) {
            recipesRepository.addStepToRecipe(content, nameRecipe);
        }
    }
}
