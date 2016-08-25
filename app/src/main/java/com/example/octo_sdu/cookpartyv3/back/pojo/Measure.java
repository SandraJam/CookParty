package com.example.octo_sdu.cookpartyv3.back.pojo;

import io.realm.RealmObject;

public class Measure extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
