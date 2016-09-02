package realm;

import realm.pojo.CategoryIngredientRealm;
import realm.pojo.IngredientRealm;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;
import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class IngredientsRepositoryRealmImpl implements IngredientsRepository {

    @Override
    public List<Ingredient> allIngredientsByCategory(String category) {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<IngredientRealm> ingredientRealms = realm.where(IngredientRealm.class).equalTo("category.name", category).findAll().sort("name");
        List<Ingredient> ingredients = new ArrayList<>();
        for(IngredientRealm ing: ingredientRealms) {
            ingredients.add(ing.realmToPojo());
        }
        return ingredients;
    }

    @Override
    public void add(String name, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
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
        final Realm realm = Realm.getDefaultInstance();
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
    public Ingredient findIngredient(String name, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final IngredientRealm ingredientRealm = realm.where(IngredientRealm.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findFirst();
        if (ingredientRealm == null) {
            return null;
        }
        return ingredientRealm.realmToPojo();
    }

    @Override
    public void deleteIngredient(String name, String nameCategory) {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<IngredientRealm> ingredientRealms = realm.where(IngredientRealm.class).equalTo("name", name).findAll().where().equalTo("category.name", nameCategory).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ingredientRealms.deleteFirstFromRealm();
            }
        });
    }
}
