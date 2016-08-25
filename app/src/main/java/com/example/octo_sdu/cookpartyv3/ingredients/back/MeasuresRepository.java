package com.example.octo_sdu.cookpartyv3.ingredients.back;

import com.example.octo_sdu.cookpartyv3.back.realm.pojo.MeasureRealm;

import java.util.List;

public interface MeasuresRepository {

    void add(String name);

    List<MeasureRealm> allMeasures();

    int checkFirstTime();
}
