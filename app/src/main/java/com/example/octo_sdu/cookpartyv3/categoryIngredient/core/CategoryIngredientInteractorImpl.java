package com.example.octo_sdu.cookpartyv3.categoryIngredient.core;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;

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
        final List<CategoryIngredient> categoryIngredients = categoryIngredientRepository.allCategoryIngredient();
        categoryIngredientPresenter.onSuccess(categoryIngredients);
    }

    @Override
    public void addCategoryIngredient(String name, int draw) {
        if (name.length() >= 2 && name.length() <= 15 && categoryIngredientRepository.findOneCategory(name) == null){

            categoryIngredientRepository.addCategoryIngredient(name, draw);
            allCategoryIngredient();
        }
    }
}