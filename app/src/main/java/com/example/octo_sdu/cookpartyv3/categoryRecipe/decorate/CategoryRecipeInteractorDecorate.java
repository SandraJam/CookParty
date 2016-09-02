package com.example.octo_sdu.cookpartyv3.categoryRecipe.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractor;

import java.util.concurrent.Executor;

public class CategoryRecipeInteractorDecorate implements CategoryRecipeInteractor {
    private final Executor executor = ExecutorInstance.executor;
    private CategoryRecipeInteractor categoryRecipeInteractor;

    public CategoryRecipeInteractorDecorate(CategoryRecipeInteractor categoryRecipeInteractor) {
        this.categoryRecipeInteractor = categoryRecipeInteractor;
    }

    @Override
    public void allCategoryRecipe() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryRecipeInteractor.allCategoryRecipe();
            }
        });
    }

    @Override
    public void addCategoryRecipe(final String name, final int draw) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryRecipeInteractor.addCategoryRecipe(name, draw);
            }
        });
    }
}
