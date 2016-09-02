package realm.pojo;

import com.example.octo_sdu.core.coreIngredients.model.Ingredient;

import io.realm.RealmObject;

public class IngredientRealm extends RealmObject {
    private String name;
    private CategoryIngredientRealm category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryIngredientRealm getCategory() {
        return category;
    }

    public void setCategory(CategoryIngredientRealm category) {
        this.category = category;
    }

    public Ingredient realmToPojo() {
        return new Ingredient(name, category.realmToPojo());
    }
}
