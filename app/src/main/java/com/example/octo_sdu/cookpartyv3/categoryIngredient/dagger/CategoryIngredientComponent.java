package com.example.octo_sdu.cookpartyv3.categoryIngredient.dagger;

import com.example.octo_sdu.cookpartyv3.CategoryIngredientActivity;
import com.example.octo_sdu.cookpartyv3.back.MainComponent;

import dagger.Component;

@CategoryIngredientScope
@Component(dependencies = MainComponent.class, modules = CategoryIngredientModule.class)
public interface CategoryIngredientComponent {
    void inject(CategoryIngredientActivity categoryIngredientActivity);
}
