package com.example.octo_sdu.cookpartyv3.ingredients.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.presenter.IngredientsPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class IngredientsInteractorImplTest {
    IngredientsPresenter ingredientsPresenter;
    IngredientsRepository ingredientsRepository;
    IngredientsInteractorImpl interactor;

    @Before
    public void setUp() throws Exception {
        ingredientsPresenter = mock(IngredientsPresenter.class);
        ingredientsRepository = mock(IngredientsRepository.class);
        interactor = new IngredientsInteractorImpl(ingredientsPresenter, ingredientsRepository);
    }

    @Test
    public void testAllIngredientsByCategoryWithNullIngredientsList() {
        Mockito.when(ingredientsRepository.allIngredientsByCategory(Mockito.anyString())).thenReturn(null);
        interactor.allIngredientsByCategory("");
        Mockito.verify(ingredientsPresenter).onEmpty();
    }

    @Test
    public void testAllIngredientsByCategoryWithEmptyIngredientsList() {
        Mockito.when(ingredientsRepository.allIngredientsByCategory(Mockito.anyString())).thenReturn(new ArrayList<Ingredient>());
        interactor.allIngredientsByCategory("");
        Mockito.verify(ingredientsPresenter).onEmpty();
    }

    @Test
    public void testAllIngredientsByCategoryWithCoolIngredientsList() {
        final ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        Mockito.when(ingredientsRepository.allIngredientsByCategory(Mockito.anyString())).thenReturn(ingredients);
        interactor.allIngredientsByCategory("");
        Mockito.verify(ingredientsPresenter).onSuccess(ingredients);
    }

    @Test
    public void testAddIngredientWhenTooShortName() {
        interactor.addIngredient("aa", "");
        Mockito.verifyZeroInteractions(ingredientsPresenter);
    }

    @Test
    public void testAddIngredientWhenTooLongName() {
        interactor.addIngredient("anagrammatically", "");
        Mockito.verifyZeroInteractions(ingredientsPresenter);
    }

    @Test
    public void testAddIngredientWhenNullCategory() {
        interactor.addIngredient("abracadabra", null);
        Mockito.verifyZeroInteractions(ingredientsPresenter);
    }

    @Test
    public void testAddIngredientWhenOk() {
        interactor.addIngredient("abracadabra", "category");
        Mockito.verify(ingredientsRepository).add("abracadabra", "category");
    }

    @Test
    public void testDeleteCategoryAndAllIngredientsWhenNameCategoryIsNull() {
        interactor.deleteCategoryAndAllIngredients(null);
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteCategoryAndAllIngredientsWhenNameTooShort() {
        interactor.deleteCategoryAndAllIngredients("aa");
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteCategoryAndAllIngredientsWhenNameTooLong() {
        interactor.deleteCategoryAndAllIngredients("anagrammatically");
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteCategoryAndAllIngredientsWhenNameOk() {
        interactor.deleteCategoryAndAllIngredients("abracadabra");
        Mockito.verify(ingredientsRepository).deleteCategory("abracadabra");
    }
}