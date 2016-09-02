package com.example.octo_sdu.core.coreIngredients;


import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import java.util.List;

public class IngredientsInteractorImpl implements IngredientsInteractor {
    private IngredientsPresenter ingredientsPresenter;
    private IngredientsRepository ingredientsRepository;

    public IngredientsInteractorImpl(IngredientsRepository ingredientsRepository, IngredientsPresenter ingredientsPresenter) {
        this.ingredientsPresenter = ingredientsPresenter;
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public void allIngredientsByCategory(String category) {
        final List<Ingredient> ingredientRealms = ingredientsRepository.allIngredientsByCategory(category);
        if (ingredientRealms == null || ingredientRealms.isEmpty()) {
            ingredientsPresenter.onEmpty();
        } else{
            ingredientsPresenter.onSuccess(ingredientRealms);
        }
    }

    @Override
    public void addIngredient(String name, String nameCategory) {
        if (name.length() > 2 && name.length() < 15 && nameCategory != null && ingredientsRepository.findIngredient(name, nameCategory) == null)
            ingredientsRepository.add(name, nameCategory);
    }

    @Override
    public void deleteCategoryAndAllIngredients(String nameCategory) {
        if (nameCategory!= null && nameCategory.length() > 2 && nameCategory.length() < 15)
            ingredientsRepository.deleteCategory(nameCategory);
    }

    @Override
    public void deleteIngredient(String name, String nameCategory) {
        if (name != null && name.length() > 2 && name.length() < 15)
            ingredientsRepository.deleteIngredient(name, nameCategory);
    }
}
