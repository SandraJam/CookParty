package com.example.octo_sdu.cookpartyv3.categoryRecipe.dagger;

import com.example.octo_sdu.cookpartyv3.CategoryRecipeActivity;
import com.example.octo_sdu.cookpartyv3.back.MainComponent;

import dagger.Component;

@CategoryRecipeScope
@Component(dependencies = MainComponent.class, modules = CategoryRecipeModule.class)
public interface CategoryRecipeComponent {
    void inject(CategoryRecipeActivity categoryRecipeActivity);
}
