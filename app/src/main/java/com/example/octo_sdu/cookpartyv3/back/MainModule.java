package com.example.octo_sdu.cookpartyv3.back;

import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientRepository;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;
import com.example.octo_sdu.core.coreRecipes.MeasuresRepository;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;

import javax.inject.Singleton;

import dagger.Provides;
import realm.CategoryIngredientRepositoryRealm;
import realm.CategoryRecipeRepositoryRealmImpl;
import realm.IngredientsRepositoryRealmImpl;
import realm.MeasuresRepositoryRealmImpl;
import realm.RecipesRepositoryRealmImpl;

@dagger.Module
public class MainModule {

    @Singleton @Provides static MeasuresRepository providesMeasuresRepository() {
        return new MeasuresRepositoryRealmImpl();
    }

    @Singleton @Provides static CategoryIngredientRepository providesCategoryIngredientRepository() {
        return new CategoryIngredientRepositoryRealm();
    }

    @Singleton @Provides static CategoryRecipeRepository providesCategoryRecipeRepository() {
        return new CategoryRecipeRepositoryRealmImpl();
    }

    @Singleton @Provides static IngredientsRepository providesIngredientsRepository() {
        return new IngredientsRepositoryRealmImpl();
    }

    @Singleton @Provides static RecipesRepository providesRecipesRepository() {
        return new RecipesRepositoryRealmImpl();
    }

}
