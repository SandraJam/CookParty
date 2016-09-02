package com.example.octo_sdu.cookpartyv3.back;

import android.content.Context;
import android.content.res.Resources;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.core.coreCategoryIngredient.CategoryIngredientRepository;
import com.example.octo_sdu.core.coreCategoryRecipe.CategoryRecipeRepository;
import com.example.octo_sdu.core.coreIngredients.IngredientsRepository;
import com.example.octo_sdu.core.coreRecipes.MeasuresRepository;

import javax.inject.Inject;

public class FirstTime {
    @Inject MeasuresRepository measuresRepository;
    @Inject CategoryIngredientRepository categoryIngredientRepository;
    @Inject IngredientsRepository ingredientsRepository;
    @Inject CategoryRecipeRepository categoryRecipeRepository;

    public void checkFirstTime(Context context){
        Dependencies.instance.mainComponent.make(this);
        if (measuresRepository.checkFirstTime() == 0){
            addMeasures(context);
            addCategoryIngredient(context);
            addIngredients(context);
            addCategoryRecipe(context);
        }
    }

    private void addCategoryRecipe(Context context) {
        final Resources resources = context.getResources();
        categoryRecipeRepository.addCategoryRecipe(resources.getString(R.string.meal), R.drawable.meal);
        categoryRecipeRepository.addCategoryRecipe(resources.getString(R.string.gratin), R.drawable.gratin);
        categoryRecipeRepository.addCategoryRecipe(resources.getString(R.string.quiche_and_pizza), R.drawable.pizza);
        categoryRecipeRepository.addCategoryRecipe(resources.getString(R.string.pastry), R.drawable.pastry);
        categoryRecipeRepository.addCategoryRecipe(resources.getString(R.string.sauce), R.drawable.sauce);
    }

    private void addMeasures(Context context){
        final Resources resources = context.getResources();
        measuresRepository.add(resources.getString(R.string.liter));
        measuresRepository.add(resources.getString(R.string.gram));
        measuresRepository.add(resources.getString(R.string.unit));
        measuresRepository.add(resources.getString(R.string.teaspoon));
        measuresRepository.add(resources.getString(R.string.tablespoon));
    }

    private void addCategoryIngredient(Context context) {
        final Resources resources = context.getResources();
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.fruit), R.drawable.fruits);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.vegetable), R.drawable.vegetables);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.meat), R.drawable.meat);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.spice), R.drawable.spice);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.aromatic), R.drawable.herb);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.drink), R.drawable.drink);
        categoryIngredientRepository.addCategoryIngredient(resources.getString(R.string.grocery), R.drawable.grocery);
    }

    private void addIngredients(Context context) {
        final Resources resources = context.getResources();
        ingredientsRepository.add(resources.getString(R.string.starwberry), resources.getString(R.string.fruit));
        ingredientsRepository.add(resources.getString(R.string.banana), resources.getString(R.string.fruit));
        ingredientsRepository.add(resources.getString(R.string.cherry), resources.getString(R.string.fruit));
        ingredientsRepository.add(resources.getString(R.string.apple), resources.getString(R.string.fruit));
        ingredientsRepository.add(resources.getString(R.string.apricot), resources.getString(R.string.fruit));

        ingredientsRepository.add(resources.getString(R.string.leek), resources.getString(R.string.vegetable));
        ingredientsRepository.add(resources.getString(R.string.bean), resources.getString(R.string.vegetable));
        ingredientsRepository.add(resources.getString(R.string.potato), resources.getString(R.string.vegetable));
        ingredientsRepository.add(resources.getString(R.string.salad), resources.getString(R.string.vegetable));
        ingredientsRepository.add(resources.getString(R.string.tomato), resources.getString(R.string.vegetable));

        ingredientsRepository.add(resources.getString(R.string.ground_beef), resources.getString(R.string.meat));
        ingredientsRepository.add(resources.getString(R.string.pork_chop), resources.getString(R.string.meat));
        ingredientsRepository.add(resources.getString(R.string.chicken_thigh), resources.getString(R.string.meat));
        ingredientsRepository.add(resources.getString(R.string.beef_steak), resources.getString(R.string.meat));
        ingredientsRepository.add(resources.getString(R.string.roast_pork), resources.getString(R.string.meat));

        ingredientsRepository.add(resources.getString(R.string.curry), resources.getString(R.string.spice));
        ingredientsRepository.add(resources.getString(R.string.paprika), resources.getString(R.string.spice));
        ingredientsRepository.add(resources.getString(R.string.cumin), resources.getString(R.string.spice));
        ingredientsRepository.add(resources.getString(R.string.chili_pepper), resources.getString(R.string.spice));
        ingredientsRepository.add(resources.getString(R.string.mustard), resources.getString(R.string.spice));

        ingredientsRepository.add(resources.getString(R.string.basil), resources.getString(R.string.aromatic));
        ingredientsRepository.add(resources.getString(R.string.laurel), resources.getString(R.string.aromatic));
        ingredientsRepository.add(resources.getString(R.string.tarragon), resources.getString(R.string.aromatic));
        ingredientsRepository.add(resources.getString(R.string.chive), resources.getString(R.string.aromatic));
        ingredientsRepository.add(resources.getString(R.string.onion), resources.getString(R.string.aromatic));

        ingredientsRepository.add(resources.getString(R.string.water), resources.getString(R.string.drink));
        ingredientsRepository.add(resources.getString(R.string.white_wine), resources.getString(R.string.drink));
        ingredientsRepository.add(resources.getString(R.string.red_wine), resources.getString(R.string.drink));
        ingredientsRepository.add(resources.getString(R.string.milk), resources.getString(R.string.drink));
        ingredientsRepository.add(resources.getString(R.string.rum), resources.getString(R.string.drink));

        ingredientsRepository.add(resources.getString(R.string.flour), resources.getString(R.string.grocery));
        ingredientsRepository.add(resources.getString(R.string.white_sugar), resources.getString(R.string.grocery));
        ingredientsRepository.add(resources.getString(R.string.egg), resources.getString(R.string.grocery));
        ingredientsRepository.add(resources.getString(R.string.salt), resources.getString(R.string.grocery));
        ingredientsRepository.add(resources.getString(R.string.pasta), resources.getString(R.string.grocery));
    }
}
