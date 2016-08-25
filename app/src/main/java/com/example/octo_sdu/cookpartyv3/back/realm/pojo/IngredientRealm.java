package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmObject;

public class IngredientRealm extends RealmObject {
    private String name;
    private CategoryIngredientRealm category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryIngredientRealm getCategory() {
        return category;
    }

    public void setCategory(CategoryIngredientRealm category) {
        this.category = category;
    }
}
