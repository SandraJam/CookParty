package com.example.octo_sdu.core.coreCategoryIngredient;

import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

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
        if (name != null && name.length() >= 2 && name.length() <= 15 && categoryIngredientRepository.findOneCategory(name) == null){
            categoryIngredientRepository.addCategoryIngredient(name, draw);
        }
    }
}
