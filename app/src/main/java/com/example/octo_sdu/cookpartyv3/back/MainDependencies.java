package com.example.octo_sdu.cookpartyv3.back;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.categoryIngredient.core.CategoryIngredientRepository;
import com.example.octo_sdu.cookpartyv3.categoryRecipe.back.CategoryRecipeRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.back.IngredientsRepository;
import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainDependencies {

    public static Executor executor =  Executors.newSingleThreadExecutor();
    public static Executor mainExecutor = new Executor() {
        @Override
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    };

    private MeasuresRepository measuresRepository;
    private CategoryIngredientRepository categoryIngredientRepository;
    private IngredientsRepository ingredientsRepository;
    private CategoryRecipeRepository categoryRecipeRepository;

    private static MainDependencies mainDependenciesInstance = null;

    public static MainDependencies getInstance() {
        if (mainDependenciesInstance==null){
            mainDependenciesInstance = new MainDependencies();
        }
        return mainDependenciesInstance;
    }

    public void checkFirstTime(Context context){
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

    public void setMeasuresRepository(MeasuresRepository measuresRepository) {
        this.measuresRepository = measuresRepository;
    }

    public void setCategoryIngredientRepository(CategoryIngredientRepository categoryIngredientRepository) {
        this.categoryIngredientRepository = categoryIngredientRepository;
    }

    public void setIngredientsRepository(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public void setCategoryRecipeRepository(CategoryRecipeRepository categoryRecipeRepository) {
        this.categoryRecipeRepository = categoryRecipeRepository;
    }
}
