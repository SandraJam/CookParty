package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmObject;

public class CategoryIngredient extends RealmObject{
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
