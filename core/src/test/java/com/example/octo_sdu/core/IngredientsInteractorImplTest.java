package com.example.octo_sdu.core;

import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;
import com.example.octo_sdu.core.coreIngredients.IngredientsInteractorImpl;
import com.example.octo_sdu.core.coreIngredients.IngredientsPresenter;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;
import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

public class IngredientsInteractorImplTest {
    IngredientsPresenter ingredientsPresenter;
    IngredientsRepository ingredientsRepository;
    IngredientsInteractorImpl interactor;

    @Before
    public void setUp() throws Exception {
        ingredientsPresenter = mock(IngredientsPresenter.class);
        ingredientsRepository = mock(IngredientsRepository.class);
        interactor = new IngredientsInteractorImpl(ingredientsRepository, ingredientsPresenter);
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
        final ArrayList<Ingredient> ingredientRealms = new ArrayList<>();
        ingredientRealms.add(new Ingredient("ingredient", null));
        Mockito.when(ingredientsRepository.allIngredientsByCategory(Mockito.anyString())).thenReturn(ingredientRealms);
        interactor.allIngredientsByCategory("");
        Mockito.verify(ingredientsPresenter).onSuccess(ingredientRealms);
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
    public void testAddIngredientWhenAlreadyExist() {
        Mockito.when(ingredientsRepository.findIngredient("aaa", "bbb")).thenReturn(new Ingredient("aaa", new CategoryIngredient("bbb", 0)));
        interactor.addIngredient("aaa", "bbb");
        Mockito.verify(ingredientsRepository, never()).add("aaa", "bbb");
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

    @Test
    public void testDeleteWhenNameIsNull() {
        interactor.deleteIngredient(null, "aa");
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteWhenNameIsTooShort() {
        interactor.deleteIngredient("aa", "aa");
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteWhenNameIsTooLong() {
        interactor.deleteIngredient("anagrammatically", "aa");
        Mockito.verifyZeroInteractions(ingredientsRepository);
    }

    @Test
    public void testDeleteWhenNameIsOk() {
        interactor.deleteIngredient("abracadabra", "aa");
        Mockito.verify(ingredientsRepository).deleteIngredient("abracadabra", "aa");
    }
}