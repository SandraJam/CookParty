package com.example.octo_sdu.cookpartyv3.categoryIngredient.dagger;

import com.example.octo_sdu.cookpartyv3.categoryIngredient.decorate.CategoryIngredientInteractorDecorate;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.decorate.CategoryIngredientViewValidateDecorate;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientPresenterImpl;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientViewValidate;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientInteractor;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientInteractorImpl;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientPresenter;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryIngredientModule {

    @CategoryIngredientScope
    @Provides
    public CategoryIngredientViewValidateDecorate providesCategoryIngredientViewValidateDecorate() {
        return new CategoryIngredientViewValidateDecorate();
    }

    @Provides
    public CategoryIngredientInteractor providesCategoryIngredientInteractor(CategoryIngredientRepository repository, CategoryIngredientPresenter presenter) {
        return new CategoryIngredientInteractorDecorate(
                new CategoryIngredientInteractorImpl(repository, presenter)
        );
    }

    @Provides
    public CategoryIngredientPresenter providesCategoryIngredientPresenter(CategoryIngredientViewValidate categoryIngredientViewValidate) {
        return new CategoryIngredientPresenterImpl(categoryIngredientViewValidate);
    }

    @Provides
    public CategoryIngredientViewValidate providesCategoryIngredientViewValidate(CategoryIngredientViewValidateDecorate categoryIngredientViewValidateDecorate) {
        return categoryIngredientViewValidateDecorate;
    }
}
