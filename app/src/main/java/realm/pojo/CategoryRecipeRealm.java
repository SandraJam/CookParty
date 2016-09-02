package realm.pojo;

import com.example.octo_sdu.core.coreCategoryRecipe.model.CategoryRecipe;

import io.realm.RealmObject;

public class CategoryRecipeRealm extends RealmObject{
    private String name;
    private int draw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public CategoryRecipe realmToPojo() {
        return new CategoryRecipe(name, draw);
    }
}
