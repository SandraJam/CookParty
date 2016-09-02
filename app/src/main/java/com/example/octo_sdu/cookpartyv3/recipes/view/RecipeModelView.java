package com.example.octo_sdu.cookpartyv3.recipes.view;

import java.util.List;

public class RecipeModelView {
    private String title;
    private List<String> ingredients;
    private List<String> steps;

    public RecipeModelView(String title, List<String> ingredients, List<String> steps) {
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
