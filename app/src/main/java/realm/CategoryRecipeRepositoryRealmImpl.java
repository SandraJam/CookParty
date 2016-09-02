package realm;

import realm.pojo.CategoryRecipeRealm;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;
import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CategoryRecipeRepositoryRealmImpl implements CategoryRecipeRepository {

    @Override
    public List<CategoryRecipe> allCategoryRecipe() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<CategoryRecipeRealm> categoryRecipeRealms = realm.where(CategoryRecipeRealm.class).findAll().sort("name");
        List<CategoryRecipe> categoryRecipes = new ArrayList<>();
        for(CategoryRecipeRealm cat: categoryRecipeRealms){
            categoryRecipes.add(cat.realmToPojo());
        }
        return categoryRecipes;
    }

    @Override
    public void addCategoryRecipe(String name, int draw) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        CategoryRecipeRealm categoryRecipeRealm = realm.createObject(CategoryRecipeRealm.class);
        categoryRecipeRealm.setName(name);
        categoryRecipeRealm.setDraw(draw);
        realm.commitTransaction();
    }

    @Override
    public CategoryRecipe findCategoryRecipe(String name) {
        final Realm realm = Realm.getDefaultInstance();
        final CategoryRecipeRealm categoryRecipeRealm = realm.where(CategoryRecipeRealm.class).equalTo("name", name).findFirst();
        if (categoryRecipeRealm == null){
            return null;
        }
        return categoryRecipeRealm.realmToPojo();
    }
}