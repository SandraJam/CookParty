package com.example.octo_sdu.cookpartyv3.ingredients.dagger;

import com.example.octo_sdu.cookpartyv3.IngredientsActivity;
import com.example.octo_sdu.cookpartyv3.back.MainComponent;

import dagger.Component;

@IngredientsScope
@Component(dependencies = MainComponent.class, modules = IngredientsModule.class)
public interface IngredientsComponent {
    void inject(IngredientsActivity ingredientsActivity);
}
