package com.example.octo_sdu.cookpartyv3.back;

import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

public class FirstTime {

    private MeasuresRepository measuresRepository;

    public FirstTime(MeasuresRepository measuresRepository) {
        this.measuresRepository = measuresRepository;
    }

    public void checkFirstTime(){
        if (measuresRepository.checkFirstTime()){
            addMeasures();
        }
    }

    public void addMeasures(){
        measuresRepository.add("gramme", true);
        measuresRepository.add("litre", true);
        measuresRepository.add("c.c.", false);
        measuresRepository.add("c.s.", false);
    }
}
