package com.example.octo_sdu.cookpartyv3.categoryIngredient.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientPresenter {
    void onSuccess(List<CategoryIngredient> categoryIngredientList);

    void onEmptyCategory();
}
