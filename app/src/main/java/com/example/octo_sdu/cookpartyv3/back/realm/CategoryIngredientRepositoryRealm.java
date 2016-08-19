package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.back.CategoryIngredientRepository;

import java.util.List;

import io.realm.Realm;

public class CategoryIngredientRepositoryRealm implements CategoryIngredientRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<CategoryIngredient> allCategoryIngredient() {
        return realm.where(CategoryIngredient.class).findAll();
    }

    @Override
    public void saveCategoryIngredient(String name, int draw) {
        realm.beginTransaction();
        CategoryIngredient categoryIngredient = realm.createObject(CategoryIngredient.class);
        categoryIngredient.setDrawable(draw);
        categoryIngredient.setName(name);
        realm.commitTransaction();
    }
}
