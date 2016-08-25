package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.CategoryRecipeRealm;
import com.example.octo_sdu.cookpartyv3.back.realm.pojo.RecipeRealm;
import com.example.octo_sdu.cookpartyv3.recipes.back.RecipesRepository;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecipesRepositoryRealmImpl implements RecipesRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void deleteCategoryAndAllRecipes(String nameCategory) {
        final RealmResults<RecipeRealm> recipeRealms = realm.where(RecipeRealm.class).equalTo("category.name", nameCategory).findAll();
        final RealmResults<CategoryRecipeRealm> categoryRecipeRealm = realm.where(CategoryRecipeRealm.class).equalTo("name", nameCategory).findAll();
        for (final RecipeRealm recipeRealm : recipeRealms) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    recipeRealm.getIngredients().deleteAllFromRealm();
                    recipeRealm.getSteps().deleteAllFromRealm();
                }
            });
        }
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm) {
                recipeRealms.deleteAllFromRealm();
                categoryRecipeRealm.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public List<RecipeRealm> allRecipesByCategory(String nameCategory) {
        return realm.where(RecipeRealm.class).findAll().sort("title");
    }
}
