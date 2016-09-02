package com.example.octo_sdu.cookpartyv3.categoryRecipe.dagger;

import com.example.octo_sdu.cookpartyv3.categoryRecipe.decorate.CategoryRecipeInteractorDecorate;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.decorate.CategoryRecipeViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipePresenterImpl;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipeViewValidate;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractor;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractorImpl;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipePresenter;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryRecipeModule {

    @CategoryRecipeScope
    @Provides
    CategoryRecipeViewValidateDecorate providesCategoryRecipeViewValidateDecorate() {
        return new CategoryRecipeViewValidateDecorate();
    }

    @Provides
    CategoryRecipePresenter providesCategoryRecipePresenter(CategoryRecipeViewValidate categoryRecipeViewValidate) {
        return new CategoryRecipePresenterImpl(categoryRecipeViewValidate);
    }

    @Provides
    CategoryRecipeViewValidate providesCategoryRecipeViewValidate (CategoryRecipeViewValidateDecorate categoryRecipeViewValidateDecorate) {
        return categoryRecipeViewValidateDecorate;
    }

    @Provides
    CategoryRecipeInteractor providesCategoryRecipeInteractor (CategoryRecipeRepository categoryRecipeRepository, CategoryRecipePresenter categoryRecipePresenter) {
        return new CategoryRecipeInteractorDecorate(
                new CategoryRecipeInteractorImpl(categoryRecipeRepository, categoryRecipePresenter)
        );
    }

}