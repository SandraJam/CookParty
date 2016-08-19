package com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.back.CategoryIngredientRepository;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientPresenter;

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
        if (categoryIngredients == null || !categoryIngredients.isEmpty())
            categoryIngredientPresenter.onSuccess(categoryIngredients);
        else
            categoryIngredientPresenter.onEmptyCategory();
    }

    @Override
    public void saveCategoryIngredient(String name, int draw) {
        if (name.length() >= 2)
            categoryIngredientRepository.saveCategoryIngredient(name, draw);
    }
}
