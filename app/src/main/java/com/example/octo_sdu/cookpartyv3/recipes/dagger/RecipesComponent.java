package com.example.octo_sdu.cookpartyv3.recipes.dagger;

import com.example.octo_sdu.cookpartyv3.RecipesActivity;
import com.example.octo_sdu.cookpartyv3.back.MainComponent;

import dagger.Component;

@RecipesScope
@Component(dependencies = MainComponent.class, modules = RecipesModule.class)
public interface RecipesComponent {
    void inject(RecipesActivity recipesActivity);
}
