package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmObject;

public class Ingredient extends RealmObject {
    private String name;
    private CategoryIngredient category;
    private Measure measure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryIngredient getCategory() {
        return category;
    }

    public void setCategory(CategoryIngredient category) {
        this.category = category;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
