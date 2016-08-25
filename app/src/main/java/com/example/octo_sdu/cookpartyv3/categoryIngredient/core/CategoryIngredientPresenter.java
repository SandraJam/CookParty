package com.example.octo_sdu.cookpartyv3.categoryIngredient.core;

import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientPresenter {
    void onSuccess(List<CategoryIngredient> categoryIngredientRealmList);
}
