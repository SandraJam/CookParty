package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmObject;

public class StepInRecipe extends RealmObject{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
