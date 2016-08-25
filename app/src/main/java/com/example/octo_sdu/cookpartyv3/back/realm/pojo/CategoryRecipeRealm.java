package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmObject;

public class CategoryRecipeRealm extends RealmObject{
    private String name;
    private int draw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
