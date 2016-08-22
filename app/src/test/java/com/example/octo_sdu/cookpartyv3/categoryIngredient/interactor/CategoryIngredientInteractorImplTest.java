package com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.back.CategoryIngredientRepository;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter.CategoryIngredientPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

public class CategoryIngredientInteractorImplTest {
    CategoryIngredientInteractorImpl categoryIngredientInteractor;
    CategoryIngredientPresenter categoryIngredientPresenter;
    CategoryIngredientRepository categoryIngredientRepository;

    @Before
    public void setUp() throws Exception {
        categoryIngredientPresenter = mock(CategoryIngredientPresenter.class);
        categoryIngredientRepository = mock(CategoryIngredientRepository.class);
        categoryIngredientInteractor = new CategoryIngredientInteractorImpl(categoryIngredientRepository, categoryIngredientPresenter);
    }

    @Test
    public void testAllCategoryWhenListIsNull() {
        Mockito.when(categoryIngredientRepository.allCategoryIngredient()).thenReturn(null);
        categoryIngredientInteractor.allCategoryIngredient();
        Mockito.verify(categoryIngredientPresenter).onEmptyCategory();
    }

    @Test
    public void testAllCategoryWhenListIsEmpty() {
        Mockito.when(categoryIngredientRepository.allCategoryIngredient()).thenReturn(new ArrayList<CategoryIngredient>());
        categoryIngredientInteractor.allCategoryIngredient();
        Mockito.verify(categoryIngredientPresenter).onEmptyCategory();
    }

    @Test
    public void testAllCategoryWhenListIsGood() {
        final ArrayList<CategoryIngredient> categoryIngredients = new ArrayList<>();
        categoryIngredients.add(new CategoryIngredient());
        Mockito.when(categoryIngredientRepository.allCategoryIngredient()).thenReturn(categoryIngredients);
        categoryIngredientInteractor.allCategoryIngredient();
        Mockito.verify(categoryIngredientPresenter).onSuccess(categoryIngredients);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameTooShort() {
        categoryIngredientInteractor.saveCategoryIngredient("a", 0);
        Mockito.verifyZeroInteractions(categoryIngredientRepository);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameTooLong() {
        categoryIngredientInteractor.saveCategoryIngredient("anagrammatically", 0);
        Mockito.verifyZeroInteractions(categoryIngredientRepository);
    }

    @Test
    public void testSaveCategoryIngredientWhenNameAlreadyUse() {
        Mockito.when(categoryIngredientRepository.findOneCategory("abracadabra")).thenReturn(new CategoryIngredient());
        categoryIngredientInteractor.saveCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository, never()).saveCategoryIngredient("abracadabra", 0);

    }

    @Test
    public void testSaveCategoryIngredientWhenOk() {
        categoryIngredientInteractor.saveCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository).saveCategoryIngredient("abracadabra", 0);
    }
}