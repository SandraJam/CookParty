package com.example.octo_sdu.cookpartyv3.ingredients.presenter;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientRealm;

import java.util.List;

public interface IngredientsPresenter {
    void onEmpty();

    void onSuccess(List<IngredientRealm> ingredientRealms);
}
