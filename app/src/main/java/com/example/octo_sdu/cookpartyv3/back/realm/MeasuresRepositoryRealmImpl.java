package com.example.octo_sdu.cookpartyv3.back.realm;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.MeasureRealm;
import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

import java.util.List;

import io.realm.Realm;

public class MeasuresRepositoryRealmImpl implements MeasuresRepository {
    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void add(String name) {
        realm.beginTransaction();
        MeasureRealm measureRealm = realm.createObject(MeasureRealm.class);
        measureRealm.setName(name);
        realm.commitTransaction();
    }

    @Override
    public List<MeasureRealm> allMeasures() {
        return realm.where(MeasureRealm.class).findAll();
    }

    @Override
    public int checkFirstTime() {
        return realm.where(MeasureRealm.class).findAll().size();
    }
}
