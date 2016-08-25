package com.example.octo_sdu.cookpartyv3.categoryIngredient.core.model;

public class CategoryIngredient {
    private String name;
    private int drawable;

    public CategoryIngredient(String name, int drawable) {
        this.name = name;
        this.drawable = drawable;
    }

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
