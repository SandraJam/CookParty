package com.example.octo_sdu.cookpartyv3.back;

import android.content.Context;
import android.content.res.Resources;

import com.example.octo_sdu.cookpartyv3.R;
import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

import java.util.ArrayList;
import java.util.List;

public class MainDependencies {

    private MeasuresRepository measuresRepository;

    public MainDependencies(MeasuresRepository measuresRepository) {
        this.measuresRepository = measuresRepository;
    }

    public List<Integer> givePictureCategoryIngredientList(){
        final ArrayList<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.vegetables);
        pictures.add(R.drawable.fruits);
        pictures.add(R.drawable.meat);
        pictures.add(R.drawable.spice);
        pictures.add(R.drawable.drink);
        pictures.add(R.drawable.grocery);
        return pictures;
    }

    public void checkFirstTime(Context context){
        if (measuresRepository.checkFirstTime() == 0){
            addMeasures(context);
        }
    }

    private void addMeasures(Context context){
        final Resources resources = context.getResources();
        measuresRepository.add(resources.getString(R.string.liter), true);
        measuresRepository.add(resources.getString(R.string.gram), true);
        measuresRepository.add(resources.getString(R.string.unit), false);
        measuresRepository.add(resources.getString(R.string.teaspoon), false);
        measuresRepository.add(resources.getString(R.string.tablespoon), false);
    }
}
