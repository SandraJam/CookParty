package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.back.pojo.Measure;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;

import java.util.List;

import io.realm.Realm;

public class IngredientsRepositoryRealmImpl implements IngredientsRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<Ingredient> allIngredientsByCategory(String category) {
        return realm.where(Ingredient.class).equalTo("category.name", category).findAll();
    }

    @Override
    public void add(String name, String nameCategory, String nameMeasure) {
        CategoryIngredient categoryIngredient = realm.where(CategoryIngredient.class).equalTo("name", nameCategory).findFirst();
        Measure measure = realm.where(Measure.class).equalTo("name", nameMeasure).findFirst();
        if (categoryIngredient != null && measure != null){
            realm.beginTransaction();
            Ingredient ingredient = realm.createObject(Ingredient.class);
            ingredient.setName(name);
            ingredient.setCategory(categoryIngredient);
            ingredient.setMeasure(measure);
            realm.commitTransaction();
        }
    }
}
