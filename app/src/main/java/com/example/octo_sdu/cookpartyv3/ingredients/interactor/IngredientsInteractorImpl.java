package com.example.octo_sdu.cookpartyv3.ingredients.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsPresenter;

import java.util.List;

public class IngredientsInteractorImpl implements IngredientsInteractor {
    private IngredientsPresenter ingredientsPresenter;
    private IngredientsRepository ingredientsRepository;

    public IngredientsInteractorImpl(IngredientsPresenter ingredientsPresenter, IngredientsRepository ingredientsRepository) {
        this.ingredientsPresenter = ingredientsPresenter;
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public void allIngredientsByCategory(String category) {
        final List<Ingredient> ingredients = ingredientsRepository.allIngredientsByCategory(category);
        if (ingredients == null || ingredients.isEmpty()) {
            ingredientsPresenter.onEmpty();
        } else{
            ingredientsPresenter.onSuccess(ingredients);
        }
    }

    @Override
    public void addIngredient(String name, String nameCategory) {
        if (name.length() > 2 && name.length() < 15 && nameCategory != null)
            ingredientsRepository.add(name, nameCategory);
    }

    @Override
    public void deleteCategoryAndAllIngredients(String nameCategory) {
        if (nameCategory!= null && nameCategory.length() > 2 && nameCategory.length() < 15)
            ingredientsRepository.deleteCategory(nameCategory);
    }
}
