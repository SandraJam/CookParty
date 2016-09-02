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
}
