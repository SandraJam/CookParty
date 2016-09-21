package com.example.octo_sdu.core;

import com.example.octo_sdu.core.coreRecipes.RecipesInteractor;
import com.example.octo_sdu.core.coreRecipes.RecipesInteractorImpl;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;
import com.example.octo_sdu.core.coreRecipes.RecipesPresenter;
import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class RecipesInteractorImplTest {
    RecipesRepository recipesRepository;
    RecipesPresenter recipesPresenter;
    RecipesInteractor recipesInteractor;

    @Before
    public void setUp() throws Exception {
        recipesRepository = mock(RecipesRepository.class);
        recipesPresenter = mock(RecipesPresenter.class);
        recipesInteractor = new RecipesInteractorImpl(recipesRepository, recipesPresenter);
    }

    @Test
    public void testDeleteCategoryAndAllRecipesWhenNameIsNull () {
        recipesInteractor.deleteCategoryAndAllRecipes(null);
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void testDeleteCategoryAndAllRecipesWhenOk () {
        recipesInteractor.deleteCategoryAndAllRecipes("aaa");
        Mockito.verify(recipesRepository).deleteCategoryAndAllRecipes("aaa");
    }

    @Test
    public void testAllRecipesByCategoryWhenNameCategoryNull() {
        recipesInteractor.allRecipesByCategory(null);
        Mockito.verify(recipesPresenter).onEmpty();
    }

    @Test
    public void testAllRecipesByCategoryWhenListEmpty() {
        final List<Recipe> recipes = new ArrayList<>();
        Mockito.when(recipesRepository.allRecipesByCategory(Mockito.anyString())).thenReturn(recipes);
        recipesInteractor.allRecipesByCategory("");
        Mockito.verify(recipesPresenter).onEmpty();
    }

    @Test
    public void testAllRecipesByCategoryWhenOk() {
        final List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("", null, null, null));
        Mockito.when(recipesRepository.allRecipesByCategory(Mockito.anyString())).thenReturn(recipes);
        recipesInteractor.allRecipesByCategory("");
        Mockito.verify(recipesPresenter).onSuccess(recipes);
    }

    @Test
    public void testAddRecipesWhenNameNull() {
        recipesInteractor.addRecipe(null, "");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void testAddRecipesWhenNameTooShort() {
        recipesInteractor.addRecipe("aa", "");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void testAddRecipesWhenNameTooLong() {
        recipesInteractor.addRecipe("anagrammatically anagrammatically anagrammatically anagrammatically", "");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void testAddRecipesWhenOk() {
        recipesInteractor.addRecipe("anagrammatically anagrammatically", "");
        Mockito.verify(recipesRepository).add("anagrammatically anagrammatically", "");
    }

    @Test
    public void addIngredientsToRecipeWhenNameIngredientIsIncorrect() {
        recipesInteractor.addIngredientsToRecipe(null, "a", "a", "a");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void addIngredientsToRecipeWhenNameRecipeIsIncorrect() {
        recipesInteractor.addIngredientsToRecipe("a", null, "a", "a");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void addIngredientsToRecipeWhenMeasureIsIncorrect() {
        recipesInteractor.addIngredientsToRecipe("a", "a", "a", null);
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void addIngredientsToRecipeWhenOk() {
        recipesInteractor.addIngredientsToRecipe("a", "a", "0.0", "a");
        Mockito.verify(recipesRepository).addIngredientsToRecipe("a", "a", 0f, "a");
    }

    @Test
    public void addStepToRecipeWhenContentIsNull() {
        recipesInteractor.addStepToRecipe(null, "a");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void addStepToRecipeWhenNameRecipeIsOk() {
        recipesInteractor.addStepToRecipe("a", null);
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void addStepToRecipeWhenOk() {
        recipesInteractor.addStepToRecipe("a", "a");
        Mockito.verify(recipesRepository).addStepToRecipe("a", "a");
    }

    @Test
    public void deleteRecipeWhenNameIsNull() {
        recipesInteractor.deleteRecipe(null, "a");
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void deleteRecipeWhenNameCategoryIsNull() {
        recipesInteractor.deleteRecipe("a", null);
        Mockito.verifyZeroInteractions(recipesRepository);
    }

    @Test
    public void deleteRecipeWhenOk() {
        recipesInteractor.deleteRecipe("a", "a");
        Mockito.verify(recipesRepository).deleteRecipe("a", "a");
    }
}