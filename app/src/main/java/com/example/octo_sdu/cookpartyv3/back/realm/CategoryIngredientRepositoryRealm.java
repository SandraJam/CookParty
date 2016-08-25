package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryIngredientRealm;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientRepository;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model.CategoryIngredient;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CategoryIngredientRepositoryRealm implements CategoryIngredientRepository {

    @Override
    public List<CategoryIngredient> allCategoryIngredient() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<CategoryIngredientRealm> categoryIngredientRealms = realm.where(CategoryIngredientRealm.class).findAll().sort("name");
        final List<CategoryIngredient> categoryIngredients = new ArrayList<>();
        for (CategoryIngredientRealm cat: categoryIngredientRealms) {
            categoryIngredients.add(new CategoryIngredient(cat.getName(), cat.getDrawable()));
        }
        return categoryIngredients;
    }

    @Override
    public void addCategoryIngredient(String name, int draw) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        CategoryIngredientRealm categoryIngredientRealm = realm.createObject(CategoryIngredientRealm.class);
        categoryIngredientRealm.setDrawable(draw);
        categoryIngredientRealm.setName(name);
        realm.commitTransaction();
    }

    @Override
    public CategoryIngredient findOneCategory(String name) {
        final Realm realm = Realm.getDefaultInstance();
        final CategoryIngredientRealm categoryIngredientRealm = realm.where(CategoryIngredientRealm.class).equalTo("name", name).findFirst();
        return new CategoryIngredient(categoryIngredientRealm.getName(), categoryIngredientRealm.getDrawable());
    }
}
