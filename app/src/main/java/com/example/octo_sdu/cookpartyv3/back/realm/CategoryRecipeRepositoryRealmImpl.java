package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.back.CategoryRecipeRepository;

import java.util.List;

import io.realm.Realm;

public class CategoryRecipeRepositoryRealmImpl implements CategoryRecipeRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<CategoryRecipeRealm> allCategoryRecipe() {
        return realm.where(CategoryRecipeRealm.class).findAll().sort("name");
    }

    @Override
    public void addCategoryRecipe(String name, int draw) {
        realm.beginTransaction();
        CategoryRecipeRealm categoryRecipeRealm = realm.createObject(CategoryRecipeRealm.class);
        categoryRecipeRealm.setName(name);
        categoryRecipeRealm.setDraw(draw);
        realm.commitTransaction();
    }

    @Override
    public CategoryRecipeRealm findCategoryRecipe(String name) {
        return realm.where(CategoryRecipeRealm.class).equalTo("name", name).findFirst();
    }
}
