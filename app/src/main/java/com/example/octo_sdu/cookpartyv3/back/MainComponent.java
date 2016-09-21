package com.example.octo_sdu.cookpartyv3.back;

import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientRepository;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;
import com.example.octo_sdu.core.coreRecipes.MeasuresRepository;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;

import javax.inject.Singleton;

@dagger.Component(modules = MainModule.class) @Singleton
public interface MainComponent {
    void make(FirstTime firstTime);

    MeasuresRepository measuresRepository();
    CategoryIngredientRepository categoryIngredientRepository();
    CategoryRecipeRepository categoryRecipeRepository();
    IngredientsRepository ingredientsRepository();
    RecipesRepository recipesRepository();
}
