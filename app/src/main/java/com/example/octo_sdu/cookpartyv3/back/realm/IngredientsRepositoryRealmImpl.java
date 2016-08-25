package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryIngredient;
import com.example.octo_sdu.cookpartyv3.back.pojo.Ingredient;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class IngredientsRepositoryRealmImpl implements IngredientsRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<Ingredient> allIngredientsByCategory(String category) {
        return realm.where(Ingredient.class).equalTo("category.name", category).findAll().sort("name");
    }

    @Override
    public void add(String name, String nameCategory) {
        CategoryIngredient categoryIngredient = realm.where(CategoryIngredient.class).equalTo("name", nameCategory).findFirst();
        if (categoryIngredient != null){
            realm.beginTransaction();
            Ingredient ingredient = realm.createObject(Ingredient.class);
            ingredient.setName(name);
            ingredient.setCategory(categoryIngredient);
            realm.commitTransaction();
        }
    }

    @Override
    public void deleteCategory(String nameCategory) {
        final RealmResults<Ingredient> ingredients = realm.where(Ingredient.class).equalTo("category.name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ingredients.deleteAllFromRealm();
            }
        });

        final RealmResults<CategoryIngredient> categoryIngredients = realm.where(CategoryIngredient.class).equalTo("name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                categoryIngredients.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public Ingredient findIngredient(String name, String nameCategory) {
        return realm.where(Ingredient.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findFirst();
    }

    @Override
    public void deleteIngredient(String name, String nameCategory) {
        final RealmResults<Ingredient> ingredients = realm.where(Ingredient.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ingredients.deleteFirstFromRealm();
            }
        });
    }
}
