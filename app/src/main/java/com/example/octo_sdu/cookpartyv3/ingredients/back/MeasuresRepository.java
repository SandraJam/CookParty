package com.example.octo_sdu.cookpartyv3.ingredients.back;

import com.example.octo_sdu.cookpartyv3.back.pojo.Measure;

import java.util.List;

public interface MeasuresRepository {

    void add(String name, boolean extensible);

    List<Measure> allMeasures();

    boolean checkFirstTime();
}
