package com.example.octo_sdu.cookpartyv3.back.realm.pojo;

import io.realm.RealmObject;

public class StepInRecipeRealm extends RealmObject{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
