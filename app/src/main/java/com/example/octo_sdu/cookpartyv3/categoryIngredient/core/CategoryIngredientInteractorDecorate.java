package com.example.octo_sdu.cookpartyv3.categoryIngredient.core;

import com.example.octo_sdu.cookpartyv3.back.MainDependencies;

public class CategoryIngredientInteractorDecorate implements CategoryIngredientInteractor {
    private CategoryIngredientInteractor categoryIngredientInteractor;

    public CategoryIngredientInteractorDecorate(CategoryIngredientRepository categoryIngredientRepository, CategoryIngredientPresenter categoryIngredientPresenter) {
        categoryIngredientInteractor = new CategoryIngredientInteractorImpl(categoryIngredientRepository, categoryIngredientPresenter);
    }

    @Override
    public void allCategoryIngredient() {
        MainDependencies.executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryIngredientInteractor.allCategoryIngredient();
            }
        });
    }

    @Override
    public void addCategoryIngredient(String name, int draw) {
        categoryIngredientInteractor.addCategoryIngredient(name, draw);
    }
}
