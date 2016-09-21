package realm.pojo;

import com.example.octo_sdu.core.coreRecipes.model.StepInRecipe;

import io.realm.RealmObject;

public class StepInRecipeRealm extends RealmObject{
    private String content;
    private RecipeRealm recipeRealm;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StepInRecipe realmToPojo() {
        return new StepInRecipe(content);
    }

    public RecipeRealm getRecipeRealm() {
        return recipeRealm;
    }

    public void setRecipeRealm(RecipeRealm recipeRealm) {
        this.recipeRealm = recipeRealm;
    }
}
