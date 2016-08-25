package com.example.octo_sdu.cookpartyv3.categoryIngredient.core;

import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;

import java.util.List;

public class CategoryIngredientInteractorImpl implements CategoryIngredientInteractor {
    private CategoryIngredientRepository categoryIngredientRepository;
    private CategoryIngredientPresenter categoryIngredientPresenter;

    public CategoryIngredientInteractorImpl(CategoryIngredientRepository categoryIngredientRepository, CategoryIngredientPresenter categoryIngredientPresenter) {
        this.categoryIngredientRepository = categoryIngredientRepository;
        this.categoryIngredientPresenter = categoryIngredientPresenter;
    }

    @Override
    public void allCategoryIngredient() {
        categoryIngredientPresenter.onSuccess(categoryIngredientRepository.allCategoryIngredient());
    }

    @Override
    public void addCategoryIngredient(String name, int draw) {
        if (name.length() >= 2 && name.length() <= 15 && categoryIngredientRepository.findOneCategory(name) == null){

            categoryIngredientRepository.addCategoryIngredient(name, draw);
            allCategoryIngredient();
        }
    }
}
