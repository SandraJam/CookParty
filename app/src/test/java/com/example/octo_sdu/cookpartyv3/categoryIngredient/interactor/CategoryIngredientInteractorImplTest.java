package com.example.octo_sdu.cookpartyv3.categoryIngredient.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientInteractorImpl;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientRepository;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientPresenter;

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
    public void testAllCategoryWhenListIsGood() {
        final ArrayList<CategoryIngredient> categoryIngredients = new ArrayList<>();
        categoryIngredients.add(new CategoryIngredient());
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
        Mockito.when(categoryIngredientRepository.findOneCategory("abracadabra")).thenReturn(new CategoryIngredient());
        categoryIngredientInteractor.addCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository, never()).addCategoryIngredient("abracadabra", 0);

    }

    @Test
    public void testSaveCategoryIngredientWhenOk() {
        categoryIngredientInteractor.addCategoryIngredient("abracadabra", 0);
        Mockito.verify(categoryIngredientRepository).addCategoryIngredient("abracadabra", 0);
    }
}