package com.example.octo_sdu.cookpartyv3.categoryRecipe.interactor;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.back.CategoryRecipeRepository;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter.CategoryRecipePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

public class CategoryRecipeInteractorImplTest {
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
        Mockito.when(categoryRecipeRepository.findCategoryRecipe("abracadabra")).thenReturn(new CategoryRecipe());
        categoryRecipeInteractor.addCategoryRecipe("abracadabra", 0);
        Mockito.verify(categoryRecipeRepository, never()).addCategoryRecipe("abracadabra", 0);
    }

    @Test
    public void testAddCategoryRecipeWhenOk(){
        categoryRecipeInteractor.addCategoryRecipe("alabama", 0);
        Mockito.verify(categoryRecipeRepository).addCategoryRecipe("alabama", 0);
    }

}