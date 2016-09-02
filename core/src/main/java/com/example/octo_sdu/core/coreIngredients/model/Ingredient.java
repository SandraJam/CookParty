package com.example.octo_sdu.core.coreIngredients.model;

import com.example.octo_sdu.core.coreCategoryIngredient.model.CategoryIngredient;

public class Ingredient {
    private String name;
    private CategoryIngredient categoryIngredient;

    public Ingredient(String name, CategoryIngredient categoryIngredient) {
        this.name = name;
        this.categoryIngredient = categoryIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryIngredient getCategoryIngredient() {
        return categoryIngredient;
    }

    public void setCategoryIngredient(CategoryIngredient categoryIngredient) {
        this.categoryIngredient = categoryIngredient;
    }
}
