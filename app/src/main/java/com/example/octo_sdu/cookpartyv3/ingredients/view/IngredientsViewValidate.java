package com.example.octo_sdu.cookpartyv3.ingredients.view;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientRealm;

import java.util.List;

public interface IngredientsViewValidate {
    void onEmpty();

    void onSuccess(List<IngredientRealm> ingredientRealms);
}
