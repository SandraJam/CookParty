package com.example.octo_sdu.core.coreCategoryRecipe.model;

public class CategoryRecipe {
    private String name;
    private int draw;

    public CategoryRecipe(String name, int draw) {
        this.name = name;
        this.draw = draw;
    }

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
