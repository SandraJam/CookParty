package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.back.CategoryRecipeRepository;

import java.util.List;

import io.realm.Realm;

public class CategoryRecipeRepositoryRealmImpl implements CategoryRecipeRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<CategoryRecipe> allCategoryRecipe() {
        return realm.where(CategoryRecipe.class).findAll().sort("name");
    }

    @Override
    public void addCategoryRecipe(String name, int draw) {
        realm.beginTransaction();
        CategoryRecipe categoryRecipe = realm.createObject(CategoryRecipe.class);
        categoryRecipe.setName(name);
        categoryRecipe.setDraw(draw);
        realm.commitTransaction();
    }

    @Override
    public CategoryRecipe findCategoryRecipe(String name) {
        return realm.where(CategoryRecipe.class).equalTo("name", name).findFirst();
    }
}
