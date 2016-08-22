package com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter;

import com.example.octo_sdu.cookpartyv3.categoryIngredient.view.CategoryIngredientViewValidate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class CategoryIngredientPresenterImplTest {
    CategoryIngredientPresenter categoryIngredientPresenter;
    CategoryIngredientViewValidate categoryIngredientViewValidate;

    @Before
    public void setUp() throws Exception {
        categoryIngredientViewValidate = mock(CategoryIngredientViewValidate.class);
        categoryIngredientPresenter = new CategoryIngredientPresenterImpl(categoryIngredientViewValidate);
    }

    @Test
    public void testOnSuccess() {
        categoryIngredientPresenter.onSuccess(null);
        Mockito.verify(categoryIngredientViewValidate).onSuccess(null);
    }

    @Test
    public void testOnEmpty(){
        categoryIngredientPresenter.onEmptyCategory();
        Mockito.verify(categoryIngredientViewValidate).onEmptyCategory();
    }
}