package com.example.octo_sdu.cookpartyv3.categoryIngredient.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientInteractor;

import java.util.concurrent.Executor;

public class CategoryIngredientInteractorDecorate implements CategoryIngredientInteractor {
    public Executor executor = ExecutorInstance.executor;
    private CategoryIngredientInteractor categoryIngredientInteractor;

    public CategoryIngredientInteractorDecorate(CategoryIngredientInteractor categoryIngredientInteractor) {
        this.categoryIngredientInteractor = categoryIngredientInteractor;
    }


    @Override
    public void allCategoryIngredient() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryIngredientInteractor.allCategoryIngredient();
            }
        });
    }

    @Override
    public void addCategoryIngredient(final String name, final int draw) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryIngredientInteractor.addCategoryIngredient(name, draw);
            }
        });
    }
}
