package realm.pojo;

import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

import io.realm.RealmObject;

public class CategoryIngredientRealm extends RealmObject{
    private String name;
    private int drawable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public CategoryIngredient realmToPojo() {
        return new CategoryIngredient(name, drawable);
    }

    @Override
    public String toString() {
        return name;
    }
}
