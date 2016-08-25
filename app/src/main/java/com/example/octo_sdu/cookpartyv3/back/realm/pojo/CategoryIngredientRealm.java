package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmObject;

public class CategoryIngredientRealm extends RealmObject{
    private String name;
    private int drawable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
