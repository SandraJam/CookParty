package com.example.octo_sdu.cookpartyv3.ingredients.dagger;

import com.example.octo_sdu.cookpartyv3.categoryRecipe.dagger.CategoryRecipeScope;
import com.example.octo_sdu.cookpartyv3.ingredients.decorate.IngredientsInteractorDecorate;
import com.example.octo_sdu.cookpartyv3.ingredients.decorate.IngredientsViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsPresenterImpl;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsViewValidate;
import com.example.octo_sdu.core.coreIngredients.IngredientsInteractor;
import com.example.octo_sdu.core.coreIngredients.IngredientsInteractorImpl;
import com.example.octo_sdu.core.coreIngredients.IngredientsPresenter;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class IngredientsModule {

    @IngredientsScope
    @Provides
    IngredientsViewValidateDecorate providesIngredientsViewValidateDecorate (){
        return new IngredientsViewValidateDecorate();
    }

    @Provides
    IngredientsViewValidate providesIngredientsViewValidate(IngredientsViewValidateDecorate ingredientsViewValidateDecorate) {
        return ingredientsViewValidateDecorate;
    }

    @Provides
    IngredientsPresenter providesIngredientsPresenter(IngredientsViewValidate ingredientsViewValidate) {
        return new IngredientsPresenterImpl(ingredientsViewValidate);
    }

    @Provides
    IngredientsInteractor providesIngredientsInteractor(IngredientsRepository ingredientsRepository, IngredientsPresenter ingredientsPresenter) {
        return new IngredientsInteractorDecorate(
                new IngredientsInteractorImpl(ingredientsRepository, ingredientsPresenter)
        );
    }
}
