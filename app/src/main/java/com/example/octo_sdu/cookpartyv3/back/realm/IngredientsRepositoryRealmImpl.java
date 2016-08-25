package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryIngredientRealm;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.IngredientRealm;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class IngredientsRepositoryRealmImpl implements IngredientsRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public List<IngredientRealm> allIngredientsByCategory(String category) {
        return realm.where(IngredientRealm.class).equalTo("category.name", category).findAll().sort("name");
    }

    @Override
    public void add(String name, String nameCategory) {
        CategoryIngredientRealm categoryIngredientRealm = realm.where(CategoryIngredientRealm.class).equalTo("name", nameCategory).findFirst();
        if (categoryIngredientRealm != null){
            realm.beginTransaction();
            IngredientRealm ingredientRealm = realm.createObject(IngredientRealm.class);
            ingredientRealm.setName(name);
            ingredientRealm.setCategory(categoryIngredientRealm);
            realm.commitTransaction();
        }
    }

    @Override
    public void deleteCategory(String nameCategory) {
        final RealmResults<IngredientRealm> ingredientRealms = realm.where(IngredientRealm.class).equalTo("category.name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ingredientRealms.deleteAllFromRealm();
            }
        });

        final RealmResults<CategoryIngredientRealm> categoryIngredientRealms = realm.where(CategoryIngredientRealm.class).equalTo("name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                categoryIngredientRealms.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public IngredientRealm findIngredient(String name, String nameCategory) {
        return realm.where(IngredientRealm.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findFirst();
    }

    @Override
    public void deleteIngredient(String name, String nameCategory) {
        final RealmResults<IngredientRealm> ingredientRealms = realm.where(IngredientRealm.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ingredientRealms.deleteFirstFromRealm();
            }
        });
    }
}
