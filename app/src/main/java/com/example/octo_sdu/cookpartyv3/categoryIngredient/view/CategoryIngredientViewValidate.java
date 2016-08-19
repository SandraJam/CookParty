package com.example.octo_sdu.cookpartyv3.categoryIngredient.view;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;

import java.util.List;

public interface CategoryIngredientViewValidate {
    void onSuccess(List<CategoryIngredient> categoryIngredientList);

    void onEmptyCategory();
}
