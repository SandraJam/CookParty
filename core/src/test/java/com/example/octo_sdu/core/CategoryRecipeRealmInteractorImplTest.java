package com.example.octo_sdu.core;

import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractor;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeInteractorImpl;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipePresenter;
import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

public class CategoryRecipeRealmInteractorImplTest {
    CategoryRecipeInteractor categoryRecipeInteractor;
    CategoryRecipeRepository categoryRecipeRepository;
    CategoryRecipePresenter categoryRecipePresenter;

    @Before
    public void setUp() throws Exception {
        categoryRecipePresenter = mock(CategoryRecipePresenter.class);
        categoryRecipeRepository = mock(CategoryRecipeRepository.class);
        categoryRecipeInteractor = new CategoryRecipeInteractorImpl(categoryRecipeRepository, categoryRecipePresenter);
    }

    @Test
    public void testAllCategoryRecipe() {
        categoryRecipeInteractor.allCategoryRecipe();
        Mockito.verify(categoryRecipeRepository).allCategoryRecipe();
    }

    @Test
    public void testAddCategoryRecipeWhenNameIsNull(){
        categoryRecipeInteractor.addCategoryRecipe(null, 0);
        Mockito.verifyZeroInteractions(categoryRecipeRepository);
    }

    @Test
    public void testAddCategoryRecipeWhenNameIsTooShort(){
        categoryRecipeInteractor.addCategoryRecipe("aa", 0);
        Mockito.verifyZeroInteractions(categoryRecipeRepository);
    }

    @Test
    public void testAddCategoryRecipeWhenNameIsTooLong(){
        categoryRecipeInteractor.addCategoryRecipe("anagrammatically", 0);
        Mockito.verifyZeroInteractions(categoryRecipeRepository);
    }

    @Test
    public void testAddCategoryRecipeWhenNameAlreadyExist() {
        Mockito.when(categoryRecipeRepository.findCategoryRecipe("abracadabra")).thenReturn(new CategoryRecipe("abracadabra", 0));
        categoryRecipeInteractor.addCategoryRecipe("abracadabra", 0);
        Mockito.verify(categoryRecipeRepository, never()).addCategoryRecipe("abracadabra", 0);
    }

    @Test
    public void testAddCategoryRecipeWhenOk(){
        categoryRecipeInteractor.addCategoryRecipe("alabama", 0);
        Mockito.verify(categoryRecipeRepository).addCategoryRecipe("alabama", 0);
    }

}