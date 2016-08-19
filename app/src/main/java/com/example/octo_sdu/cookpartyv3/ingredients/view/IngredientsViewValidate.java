package com.example.octo_sdu.cookpartyv3.ingredients.view;

import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;

import java.util.List;

public interface IngredientsViewValidate {
    void onEmpty();

    void onSuccess(List<Ingredient> ingredients);

    void addPossibility(String[] namesMeasures);
}
