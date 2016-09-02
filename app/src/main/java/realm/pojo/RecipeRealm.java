package realm.pojo;

import com.example.octo_sdu.core.coreRecipes.model.IngredientInRecipe;
import com.example.octo_sdu.core.coreRecipes.model.Recipe;
import com.example.octo_sdu.core.coreRecipes.model.StepInRecipe;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RecipeRealm extends RealmObject {
    private String title;
    private RealmList<IngredientInRecipeRealm> ingredients;
    private RealmList<StepInRecipeRealm> steps;
    private CategoryRecipeRealm category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<IngredientInRecipeRealm> getIngredients() {
        return ingredients;
    }

    public void setIngredients(RealmList<IngredientInRecipeRealm> ingredients) {
        this.ingredients = ingredients;
    }

    public RealmList<StepInRecipeRealm> getSteps() {
        return steps;
    }

    public void setSteps(RealmList<StepInRecipeRealm> steps) {
        this.steps = steps;
    }

    public CategoryRecipeRealm getCategory() {
        return category;
    }

    public void setCategory(CategoryRecipeRealm category) {
        this.category = category;
    }

    public Recipe realmToPojo() {
        List<IngredientInRecipe> ingredientInRecipes = new ArrayList<>();
        for (IngredientInRecipeRealm ing: ingredients) {
            ingredientInRecipes.add(ing.realmToPojo());
        }
        List<StepInRecipe> stepInRecipes = new ArrayList<>();
        for (StepInRecipeRealm step: steps) {
            stepInRecipes.add(step.realmToPojo());
        }
        return new Recipe(title, ingredientInRecipes, stepInRecipes, category.realmToPojo());
    }
}
