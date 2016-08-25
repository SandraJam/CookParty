package com.example.octo_sdu.cookpartyv3.categoryRecipe.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;

import java.util.List;

public interface CategoryRecipePresenter {
    void onSuccess(List<CategoryRecipe> categoryRecipe);
}
