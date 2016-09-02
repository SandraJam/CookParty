package com.example.octo_sdu.core;

import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientInteractorImpl;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientPresenter;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientRepository;
import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class CategoryIngredientRealmInteractorImplTest {
    CategoryIngredientInteractorImpl categoryIngredientInteractor;
    CategoryIngredientPresenter categoryIngredientPresenter;
    CategoryIngredientRepository categoryIngredientRepository;

    @Before
    public void setUp() throws Exception {
        categoryIngredientPresenter = Mockito.mock(CategoryIngredientPresenter.class);
        categoryIngredientRepository = Mockito.mock(CategoryIngredientRepository.class);
        categoryIngredientInteractor = new CategoryIngredientInteractorImpl(categoryIngredientRepository, categoryIngredientPresenter);
    }

    @Test
    public void testAllCategoryWhenListIsGood() {
        final ArrayList<CategoryIngredient> categoryIngredients = new ArrayList<>();
        categoryIngredients.add(new CategoryIngredient("", 0));
        Mockito.when(categoryIngredientRepository.allCategoryIngredient()).thenReturn(categoryIngredients);
        categoryIngredientInteractor.allCategoryIngredient();
        Mockito.verify(categoryIngredientPresenter).onSuccess(categoryIngredients);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameTooShort() {
        categoryIngredientInteractor.addCategoryIngredient("a", 0);
        Mockito.verifyZeroInteractions(categoryIngredientRepository);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameTooLong() {
        categoryIngredientInteractor.addCategoryIngredient("anagrammatically", 0);
        Mockito.verifyZeroInteractions(categoryIngredientRepository);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameAlreadyUse() {
        Mockito.when(categoryIngredientRepository.findOneCategory("abracadabra")).thenReturn(new CategoryIngredient("abracadabra", 0));
        categoryIngredientInteractor.addCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository, Mockito.never()).addCategoryIngredient("abracadabra", 0);

    }

    @Test
    public void testSaveCategoryIngredientWhenOk() {
        categoryIngredientInteractor.addCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository).addCategoryIngredient("abracadabra", 0);
    }
}