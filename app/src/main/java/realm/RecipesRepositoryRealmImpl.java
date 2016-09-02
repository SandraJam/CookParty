package realm;

import realm.pojo.CategoryRecipeRealm;
import realm.pojo.RecipeRealm;
import com.example.octo_sdu.core.coreRecipes.RecipesRepository;
import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecipesRepositoryRealmImpl implements RecipesRepository {

    @Override
    public void deleteCategoryAndAllRecipes(String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
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
    public List<Recipe> allRecipesByCategory(String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<RecipeRealm> recipeRealms = realm.where(RecipeRealm.class).findAll().sort("title");
        final List<Recipe> recipes = new ArrayList<>();
        for (RecipeRealm rec: recipeRealms) {
           recipes.add(rec.realmToPojo());
        }
        return recipes;
    }
}
