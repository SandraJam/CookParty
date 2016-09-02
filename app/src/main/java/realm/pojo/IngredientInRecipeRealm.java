package realm.pojo;

import com.example.octo_sdu.core.coreRecipes.model.IngredientInRecipe;

import io.realm.RealmObject;

public class IngredientInRecipeRealm extends RealmObject{
    private RecipeRealm recipeRealm;
    private IngredientRealm ingredientRealm;
    private float value;
    private MeasureRealm measureRealm;

    public IngredientRealm getIngredientRealm() {
        return ingredientRealm;
    }

    public void setIngredientRealm(IngredientRealm ingredientRealm) {
        this.ingredientRealm = ingredientRealm;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public MeasureRealm getMeasureRealm() {
        return measureRealm;
    }

    public void setMeasureRealm(MeasureRealm measureRealm) {
        this.measureRealm = measureRealm;
    }

    public RecipeRealm getRecipeRealm() {
            return recipeRealm;
        }

    public void setRecipeRealm(RecipeRealm recipeRealm) {
            this.recipeRealm = recipeRealm;
        }

    public IngredientInRecipe realmToPojo() {
        return new IngredientInRecipe(ingredientRealm.realmToPojo(), value, measureRealm.realmToPojo());
    }
}
