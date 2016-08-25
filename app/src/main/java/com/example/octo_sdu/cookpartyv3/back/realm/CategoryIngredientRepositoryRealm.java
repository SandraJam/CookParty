package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientRepository;

import java.util.List;

import io.realm.Realm;

public class CategoryIngredientRepositoryRealm implements CategoryIngredientRepository {


    @Override
    public List<CategoryIngredient> allCategoryIngredient() {
        final Realm realm = Realm.getDefaultInstance();
        return realm.where(CategoryIngredient.class).findAll().sort("name");
    }

    @Override
    public void addCategoryIngredient(String name, int draw) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        CategoryIngredient categoryIngredient = realm.createObject(CategoryIngredient.class);
        categoryIngredient.setDrawable(draw);
        categoryIngredient.setName(name);
        realm.commitTransaction();
    }

    @Override
    public CategoryIngredient findOneCategory(String name) {
        final Realm realm = Realm.getDefaultInstance();
        return realm.where(CategoryIngredient.class).equalTo("name", name).findFirst();
    }
}
