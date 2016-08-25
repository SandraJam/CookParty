package com.example.octo_sdu.cookpartyv3.recipes.interactor;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.RecipeRealm;
import com.example.octo_sdu.cookpartyv3.recipes.back.RecipesRepository;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesPresenter;

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
            final List<RecipeRealm> recipeRealms = recipesRepository.allRecipesByCategory(nameCategory);
            if (recipeRealms.isEmpty()){
                recipesPresenter.onEmpty();
            } else {
                recipesPresenter.onSuccess(recipeRealms);
            }
        }
    }
}
