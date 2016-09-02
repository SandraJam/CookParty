package com.example.octo_sdu.cookpartyv3.recipes.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractorImpl;
import com.example.octo_sdu.core.coreRecipes.RecipesPresenter;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;

import java.util.concurrent.Executor;

public class RecipesInteractorDecorate implements RecipesInteractor {
    private RecipesInteractor recipesInteractor;
    private Executor executor = ExecutorInstance.executor;

    public RecipesInteractorDecorate(RecipesInteractor recipesInteractor){
        this.recipesInteractor = recipesInteractor;
    }

    @Override
    public void deleteCategoryAndAllRecipes(final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.deleteCategoryAndAllRecipes(nameCategory);
            }
        });
    }

    @Override
    public void deleteRecipe(final String name, final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.deleteRecipe(name, nameCategory);
            }
        });
    }

    @Override
    public void allRecipesByCategory(final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.allRecipesByCategory(nameCategory);
            }
        });
    }
}
