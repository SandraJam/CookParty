package realm;

import com.example.octo_sdu.core.coreRecipes.RecipesRepository;
import com.example.octo_sdu.core.coreRecipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import realm.pojo.CategoryRecipeRealm;
import realm.pojo.IngredientInRecipeRealm;
import realm.pojo.RecipeRealm;
import realm.pojo.StepInRecipeRealm;

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

    @Override
    public void add(String title, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<CategoryRecipeRealm> categoryRecipes = realm.where(CategoryRecipeRealm.class).equalTo("name", nameCategory).findAll();
        realm.beginTransaction();
        RecipeRealm recipeRealm = realm.createObject(RecipeRealm.class);
        recipeRealm.setCategory(categoryRecipes.first());
        recipeRealm.setTitle(title);
        recipeRealm.setIngredients(new RealmList<IngredientInRecipeRealm>());
        recipeRealm.setSteps(new RealmList<StepInRecipeRealm>());
        realm.commitTransaction();
    }

    @Override
    public void addIngredientsToRecipe(String nameIngredient, String nameRecipe, float value, String measure) {

    }

    @Override
    public void addStepToRecipe(String content, String nameRecipe) {

    }

    @Override
    public void deleteRecipe(String title, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<RecipeRealm> recipeRealms = realm.where(RecipeRealm.class).equalTo("category.name", nameCategory).findAll().where().equalTo("title", title).findAll();
        final RealmResults<IngredientInRecipeRealm> ingredientInRecipeRealms = realm.where(IngredientInRecipeRealm.class).equalTo("recipeRealm.title", title).findAll();
        final RealmResults<StepInRecipeRealm> stepInRecipeRealms = realm.where(StepInRecipeRealm.class).equalTo("recipeRealm.title", title).findAll();

        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm) {
                ingredientInRecipeRealms.deleteAllFromRealm();
                stepInRecipeRealms.deleteAllFromRealm();
                recipeRealms.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public Recipe findRecipe(String title, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final RecipeRealm recipeRealm = realm.where(RecipeRealm.class).equalTo("title", title).findAll().where().equalTo("category.name", nameCategory).findFirst();
        if (recipeRealm == null) {
            return null;
        }
        return recipeRealm.realmToPojo();
    }
}
