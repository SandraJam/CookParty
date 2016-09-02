package com.example.octo_sdu.cookpartyv3.ingredients.decorate;

import com.example.octo_sdu.cookpartyv3.back.ExecutorInstance;
import com.example.octo_sdu.core.coreIngredients.IngredientsInteractor;

import java.util.concurrent.Executor;

public class IngredientsInteractorDecorate implements IngredientsInteractor {
    private IngredientsInteractor interactor;
    private Executor executor = ExecutorInstance.executor;

    public IngredientsInteractorDecorate(IngredientsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void allIngredientsByCategory(final String category) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.allIngredientsByCategory(category);
            }
        });
    }

    @Override
    public void addIngredient(final String name, final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.addIngredient(name, nameCategory);
            }
        });
    }

    @Override
    public void deleteCategoryAndAllIngredients(final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.deleteCategoryAndAllIngredients(nameCategory);
            }
        });
    }

    @Override
    public void deleteIngredient(final String name, final String nameCategory) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.deleteIngredient(name, nameCategory);
            }
        });
    }
}
