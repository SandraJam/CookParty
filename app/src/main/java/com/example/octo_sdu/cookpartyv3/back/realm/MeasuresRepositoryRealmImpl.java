package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.pojo.Measure;
import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

import java.util.List;

import io.realm.Realm;

public class MeasuresRepositoryRealmImpl implements MeasuresRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void add(String name, boolean extensible) {
        realm.beginTransaction();
        Measure measure = realm.createObject(Measure.class);
        measure.setName(name);
        measure.setExtensible(extensible);
        realm.commitTransaction();
    }

    @Override
    public List<Measure> allMeasures() {
        return realm.where(Measure.class).findAll();
    }

    @Override
    public boolean checkFirstTime() {
        return realm.where(Measure.class).findAll().size() == 0;
    }
}