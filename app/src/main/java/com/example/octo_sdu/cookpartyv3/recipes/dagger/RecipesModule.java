package com.example.octo_sdu.cookpartyv3.recipes.dagger;

import com.example.octo_sdu.cookpartyv3.recipes.decorate.RecipesInteractorDecorate;
import com.example.octo_sdu.cookpartyv3.recipes.decorate.RecipesViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesPresenterImpl;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesViewValidate;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractorImpl;
import com.example.octo_sdu.core.coreRecipes.RecipesPresenter;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RecipesModule {

    @RecipesScope
    @Provides
    RecipesViewValidateDecorate providesRecipesViewValidateDecorate() {
        return new RecipesViewValidateDecorate();
    }

    @Provides
    RecipesViewValidate providesRecipesViewValidate(RecipesViewValidateDecorate recipesViewValidateDecorate) {
        return recipesViewValidateDecorate;
    }

    @Provides
    RecipesPresenter providesRecipesPresenter(RecipesViewValidate recipesViewValidate) {
        return new RecipesPresenterImpl(recipesViewValidate);
    }

    @Provides
    RecipesInteractor providesRecipesInteractor(RecipesRepository recipesRepository, RecipesPresenter recipesPresenter) {
        return new RecipesInteractorDecorate(
                new RecipesInteractorImpl(recipesRepository, recipesPresenter)
        );
    }
}
