package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.CategoryRecipe;
import com.example.octo_sdu.cookpartyv3.back.pojo.Recipe;
import com.example.octo_sdu.cookpartyv3.recipes.back.RecipesRepository;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecipesRepositoryRealmImpl implements RecipesRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void deleteCategoryAndAllRecipes(String nameCategory) {
        final RealmResults<Recipe> recipes = realm.where(Recipe.class).equalTo("category.name", nameCategory).findAll();
        final RealmResults<CategoryRecipe> categoryRecipe = realm.where(CategoryRecipe.class).equalTo("name", nameCategory).findAll();
        for (final Recipe recipe: recipes) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    recipe.getIngredients().deleteAllFromRealm();
                    recipe.getSteps().deleteAllFromRealm();
                }
            });
        }
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm) {
                recipes.deleteAllFromRealm();
                categoryRecipe.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public List<Recipe> allRecipesByCategory(String nameCategory) {
        return realm.where(Recipe.class).findAll().sort("title");
    }
}
