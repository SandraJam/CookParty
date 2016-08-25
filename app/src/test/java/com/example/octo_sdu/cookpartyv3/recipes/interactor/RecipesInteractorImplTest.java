package com.example.octo_sdu.cookpartyv3.recipes.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.Recipe;
import com.example.octo_sdu.cookpartyv3.recipes.back.RecipesRepository;
import com.example.octo_sdu.cookpartyv3.recipes.presenter.RecipesPresenter;

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
        recipes.add(new Recipe());
        Mockito.when(recipesRepository.allRecipesByCategory(Mockito.anyString())).thenReturn(recipes);
        recipesInteractor.allRecipesByCategory("");
        Mockito.verify(recipesPresenter).onSuccess(recipes);
    }
}