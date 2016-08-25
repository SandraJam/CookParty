package com.example.octo_sdu.cookpartyv3.categoryRecipe.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.back.CategoryRecipeRepository;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipePresenter;

import java.util.List;

public class CategoryRecipeInteractorImpl implements CategoryRecipeInteractor {
    private CategoryRecipeRepository categoryRecipeRepository;
    private CategoryRecipePresenter categoryRecipePresenter;

    public CategoryRecipeInteractorImpl(CategoryRecipeRepository categoryRecipeRepository, CategoryRecipePresenter categoryRecipePresenter) {
        this.categoryRecipeRepository = categoryRecipeRepository;
        this.categoryRecipePresenter = categoryRecipePresenter;
    }

    @Override
    public void allCategoryRecipe() {
        final List<CategoryRecipe> categoryRecipes = categoryRecipeRepository.allCategoryRecipe();
        categoryRecipePresenter.onSuccess(categoryRecipes);
    }

    @Override
    public void addCategoryRecipe(String name, int draw) {
        if (name != null && name.length() > 2 && name.length() < 15 && categoryRecipeRepository.findCategoryRecipe(name) == null) {
            categoryRecipeRepository.addCategoryRecipe(name, draw);
        }
    }
}