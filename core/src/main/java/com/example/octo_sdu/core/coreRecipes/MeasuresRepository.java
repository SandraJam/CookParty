package com.example.octo_sdu.core.coreRecipes;

import com.example.octo_sdu.core.coreRecipes.model.Measure;

import java.util.List;

public interface MeasuresRepository {

    void add(String name);

    List<Measure> allMeasures();

    int checkFirstTime();
}
