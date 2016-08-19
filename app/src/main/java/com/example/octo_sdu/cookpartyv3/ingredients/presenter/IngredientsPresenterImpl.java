package com.example.octo_sdu.cookpartyv3.ingredients.presenter;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.ingredients.view.IngredientsViewValidate;

import java.util.List;

public class IngredientsPresenterImpl implements IngredientsPresenter {
    private IngredientsViewValidate viewValidate;

    public IngredientsPresenterImpl(IngredientsViewValidate viewValidate) {
        this.viewValidate = viewValidate;
    }

    @Override
    public void onEmpty() {
        viewValidate.onEmpty();
    }

    @Override
    public void onSuccess(List<Ingredient> ingredients) {
        viewValidate.onSuccess(ingredients);
    }

    @Override
    public void addPossibility(String[] namesMeasures) {

    }
}
